package pt.iscte.dcti.pa.math;

public class Rational {

	private int numerator;
	private int denominator;

	public Rational(final int numerator, final int denominator) {
		if(denominator == 0)
			throw new IllegalArgumentException("Illegal value of denominator. Should be != 0, was " + denominator + ".");
		
		this.numerator = numerator;
		this.denominator = denominator;

		normalize();
		
		checkInvariant();
	}

	public int getNumerator() {
		checkInvariant();

		return numerator;
	}

	public int getDenominator() {
		checkInvariant();

		return denominator;
	}

	private void checkInvariant() {
		assert 0 < denominator : "Illegal state. Denominator should be > 0, is " + denominator + ".";
		assert gcd(numerator, denominator) == 1 : "Illegal state. gcd(numerator, denominator) should be 1, is " + gcd(numerator, denominator) + ".";
	}
	
	private void normalize() {
		if(numerator == 0 && denominator == 0)
			return;
		
		if(denominator < 0) {
			numerator = -numerator;
			denominator = -denominator;
		}
		
		int gcd = gcd(numerator, denominator);
		
		numerator /= gcd;
		denominator /= gcd;
	}

	private static int gcd(int firstValue, int secondValue) {
		assert firstValue != 0 || secondValue != 0 : "IIlegal value of arguments. Cannot be both zero.";

		while(firstValue != 0) {
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
