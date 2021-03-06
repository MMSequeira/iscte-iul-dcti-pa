package pt.iscte.dcti.pa;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public abstract aspect LeafControlEnforcer {
	
	pointcut none();
	
	pointcut all() : !none();
	
	pointcut scope() : all();
	
	pointcut exclusions() : within(LeafControlEnforcer+);
	
	pointcut methodExecutions() : execution(@Leaf * *(..));
	
	pointcut constructorExecutions() : execution(@Leaf *.new(..));
	
	pointcut executions() : methodExecutions() || constructorExecutions();

	before () : scope() && !exclusions() && executions() {
		for (StackReplicaBuilder.StackElement stackElement : StackReplicaBuilder.getStackReplica())
			if(((MethodSignature)stackElement.getJoinPoint().getSignature()).getMethod().getAnnotation(Root.class) != null)
				return;
		throw new RuntimeException("@Leaf without @Root!!");
	}
	

}
