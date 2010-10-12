package pt.iscte.dcti.pa.math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	public void testEquals() {
		Rational r1 = new Rational(1, 2);
		Rational r2 = new Rational(-2, -4);
		Rational r3 = new Rational(-2, 4);

		assertTrue(r1.equals(r2));
		assertTrue(r2.equals(r1));
		assertFalse(r3.equals(r1));
		assertFalse(r1.equals(r3));
		assertTrue(r1.equals(r1));
		assertFalse(r1.equals(null));
		assertFalse(r1.equals("Hello!"));
	}

//	@Test
//	public void testAdd???() {
//		Rational r1 = new Rational(1, 3);
//		Rational r2 = new Rational(4, 6);
//
//		r2.add(r1);
//		assertEquals(0, r.getNumerator());
//		assertEquals(1, r.getDenominator());
//	}

	@Test
	public void testZeroArgumentsConstructor() {
		Rational r = new Rational();

		assertEquals(0, r.getNumerator());
		assertEquals(1, r.getDenominator());
	}

	@Test
	public void testOneArgumentsConstructor() {
		Rational r = new Rational(2);

		assertEquals(2, r.getNumerator());
		assertEquals(1, r.getDenominator());
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
