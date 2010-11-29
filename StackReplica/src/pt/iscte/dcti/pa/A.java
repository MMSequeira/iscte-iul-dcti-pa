package pt.iscte.dcti.pa;

import static java.lang.System.out;

public class A {
	
	private static int i;
	
	static {
		i = 10;
	}
	
	@Root
	public void foo1() {
		out.println("A.foo1()");
		foo2();
	}

	public void foo2() {
		out.println("A.foo2()");
		foo3();
	}

	public void foo3() {
		out.println("A.foo3()");
		foo4();
	}

	public void foo4() {
		out.println("A.foo4()");
		new B().foo1();
	}

}
