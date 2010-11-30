package pt.iscte.dcti.pa;

import static java.lang.System.out;

import java.util.Arrays;

public class B {

	public void foo1() {
		out.println("B.foo1()");
		foo2();
	}

	public void foo2() {
		out.println("B.foo2()");
		foo3();
	}

	public void foo3() {
		out.println("B.foo3()");
		foo4();
	}

	@Leaf
	public void foo4() {
		out.println("B.foo4()");
//		out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
//		out.println(StackReplicaBuilder.getStackReplica());
	}

}
