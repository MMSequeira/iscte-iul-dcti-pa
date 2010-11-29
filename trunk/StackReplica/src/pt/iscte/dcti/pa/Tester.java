package pt.iscte.dcti.pa;

import static java.lang.System.out;

import java.util.Arrays;

public class Tester {

	public static void main(final String[] arguments) {
		try {
			new A().foo1();
			new A().foo2();
		} catch (Throwable throwable) {
			out.println(Arrays.toString(throwable.getStackTrace()));
		}
	}
}
