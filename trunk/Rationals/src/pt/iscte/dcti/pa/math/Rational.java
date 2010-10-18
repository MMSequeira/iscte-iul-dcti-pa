package pt.iscte.dcti.pa.math;

// TODO Extend class Number and implement conversion methods.

/*
 * Operations to implements:
 * Addition
 * Subtraction
 * Product
 * Division
 * Symmetrical
 * Inverse
 * equals
 * toString
 * compareTo
 */
public class Rational {

	private int numerator;
	private int denominator;

	public Rational(final int numerator, final int denominator) {
		if (denominator == 0)
			throw new IllegalArgumentException(
					"Illegal value of denominator. Should be != 0, was "
							+ denominator + ".");

		this.numerator = numerator;
		this.denominator = denominator;

		normalize();

		checkInvariant();
	}

	public Rational(final int number) {
		this(number, 1);
	}

	public Rational() {
		this(0, 1);
	}

	public int getNumerator() {
		checkInvariant();

		return numerator;
	}

	public int getDenominator() {
		checkInvariant();

		return denominator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denominator;
		result = prime * result + numerator;
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;
		
		Rational other = (Rational) object;
		
		return denominator == other.denominator && numerator == other.numerator;
	}

	public void add(Rational r1) {
		// TODO Auto-generated method stub
		
	}

	private void checkInvariant() {
		assert 0 < denominator : "Illegal state. Denominator should be > 0, is "
				+ denominator + ".";
		assert gcd(numerator, denominator) == 1 : "Illegal state. gcd(numerator, denominator) should be 1, is "
				+ gcd(numerator, denominator) + ".";
	}

	private void normalize() {
		if (numerator == 0 && denominator == 0)
			return;

		if (denominator < 0) {
			numerator = -numerator;
			denominator = -denominator;
		}

		int gcd = gcd(numerator, denominator);

		numerator /= gcd;
		denominator /= gcd;
	}

	private static int gcd(int firstValue, int secondValue) {
		assert firstValue != 0 || secondValue != 0 : "IIlegal value of arguments. Cannot be both zero.";

		if (firstValue < 0)
			firstValue = -firstValue;
		if (secondValue < 0)
			secondValue = -secondValue;

		while (firstValue != 0) {
			final int oldFirstValue = firstValue;
			firstValue = secondValue % firstValue;
			secondValue = oldFirstValue;
		}

		return secondValue;
	}

	// TODO Remove main from Rational class.
	public static void main(final String[] arguments) {
		new Rational(2, 4);
	}

}
