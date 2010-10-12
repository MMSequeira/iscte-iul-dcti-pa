package pt.iscte.dcti.pa.math;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RationalTester {
	// TODO Create testers for constructors with 0 and 1 arguments.
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testTwoArgumentsConstructor() {
		Rational r = new Rational(2, 4);

		assertEquals(1, r.getNumerator());
		assertEquals(2, r.getDenominator());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTwoArgumentsConstructorWithZeroDenominator() {
		new Rational(1, 0);
	}

}
