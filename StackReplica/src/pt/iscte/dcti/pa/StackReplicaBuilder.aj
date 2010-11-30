package pt.iscte.dcti.pa;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import org.aspectj.lang.JoinPoint;

import static java.lang.System.out;

public aspect StackReplicaBuilder {

	private static ThreadLocal<Deque<JoinPoint>> stackReplica = new ThreadLocal<Deque<JoinPoint>>();

	pointcut none();

	pointcut all() : !none();

	pointcut scope() : !within(C);

	pointcut exclusions() : within(StackReplicaBuilder+);

	pointcut methodExecutions() : execution(* *(..));

	pointcut constructorExecutions() : execution(*.new(..));

	pointcut executions() : methodExecutions() || constructorExecutions();

	before() : scope() && !exclusions() && executions() {
		if(stackReplica.get() == null)
			stackReplica.set(new ArrayDeque<JoinPoint>());
		
		stackReplica.get().addLast(thisJoinPoint);
		
//		out.println(StackReplicaBuilder.getStackReplica());
//		out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
		out.println("Our stack size is " + StackReplicaBuilder.getStackReplica().size() +
				", Java stack size is " + (Thread.currentThread().getStackTrace().length - 2));
	}

	after() : scope() && !exclusions() && executions() {
		assert stackReplica.get() != null : "Duplo ops!";
		assert thisJoinPoint == stackReplica.get().getLast() : "Ops!";

//		out.println(StackReplicaBuilder.getStackReplica());
//		out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
		out.println("Our stack size is " + StackReplicaBuilder.getStackReplica().size() +
				", Java stack size is " + (Thread.currentThread().getStackTrace().length - 2));

		stackReplica.get().removeLast();
	}

	public static Deque<JoinPoint> getStackReplica() {
		return stackReplica.get();
	}
}
