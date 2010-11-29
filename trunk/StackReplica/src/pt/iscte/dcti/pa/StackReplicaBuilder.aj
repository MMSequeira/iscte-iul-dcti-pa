package pt.iscte.dcti.pa;

import java.util.ArrayDeque;
import java.util.Deque;

import org.aspectj.lang.JoinPoint;

import static java.lang.System.out;

public aspect StackReplicaBuilder {

	private static Deque<JoinPoint> stackReplica = new ArrayDeque<JoinPoint>();
	
	pointcut none();
	
	pointcut all() : !none();
	
	pointcut scope() : all();
	
	pointcut exclusions() : within(StackReplicaBuilder+);
	
	pointcut methodExecutions() : execution(* *(..));
	
	pointcut constructorExecutions() : execution(*.new(..));
	
	pointcut executions() : methodExecutions() || constructorExecutions();

	before () : scope() && !exclusions() && executions() {
		stackReplica.addLast(thisJoinPoint);
	}

	after () : scope() && !exclusions() && executions() {
		assert thisJoinPoint == stackReplica.getLast() : "Ops!";
		
		stackReplica.removeLast();
	}
	
	public static Deque<JoinPoint> getStackReplica() {
		return stackReplica;
	}
}
