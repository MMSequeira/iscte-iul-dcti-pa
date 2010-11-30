package pt.iscte.dcti.pa;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import org.aspectj.lang.JoinPoint;

import static java.lang.System.out;

public aspect StackReplicaBuilder {
	
	public static class StackElement {
		public StackElement(JoinPoint joinPoint) {
			this.joinPoint = joinPoint;
			this.stackTraceElement = null;
		}
		
		public StackElement(StackTraceElement stackTraceElement) {
			this.joinPoint = null;
			this.stackTraceElement = stackTraceElement;			
		}
		
		public JoinPoint getJoinPoint() {
			return joinPoint;
		}

		public StackTraceElement getStackTraceElement() {
			return stackTraceElement;
		}
		
		@Override
		public String toString() {
			if (joinPoint != null)
				return joinPoint.toString(); 
			return stackTraceElement.toString();
		}

		private JoinPoint joinPoint;
		private StackTraceElement stackTraceElement;
	}

	private static ThreadLocal<Deque<StackElement>> stackReplica = new ThreadLocal<Deque<StackElement>>();

	pointcut none();

	pointcut all() : !none();

	pointcut scope() : !within(C);

	pointcut exclusions() : within(StackReplicaBuilder+);

	pointcut methodExecutions() : execution(* *(..));

	pointcut constructorExecutions() : execution(*.new(..));

	pointcut executions() : methodExecutions() || constructorExecutions();

	before() : scope() && !exclusions() && executions() {
		if(stackReplica.get() == null)
			stackReplica.set(new ArrayDeque<StackElement>());
		
//		if (StackReplicaBuilder.getStackReplica().size() + 1 < Thread.currentThread().getStackTrace().length - 2)
//			
//			0 - conselho
//			1 - getStackTrace
//			2 - joinpoint
//			3 - topo da pilha antes do jointpoint
//			...
		stackReplica.get().addLast(new StackElement(thisJoinPoint));
		
//		out.println(StackReplicaBuilder.getStackReplica());
//		out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
		out.println("Our stack size is " + StackReplicaBuilder.getStackReplica().size() +
				", Java stack size is " + (Thread.currentThread().getStackTrace().length - 2));
	}

	after() : scope() && !exclusions() && executions() {
		assert stackReplica.get() != null : "Duplo ops!";
		assert thisJoinPoint == stackReplica.get().getLast().getJoinPoint() : "Ops!";

//		out.println(StackReplicaBuilder.getStackReplica());
//		out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
		out.println("Our stack size is " + StackReplicaBuilder.getStackReplica().size() +
				", Java stack size is " + (Thread.currentThread().getStackTrace().length - 2));

		stackReplica.get().removeLast();
	}

	public static Deque<StackElement> getStackReplica() {
		return stackReplica.get();
	}
}
