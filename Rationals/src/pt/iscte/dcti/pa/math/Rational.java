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
// TODO Create set of annotations to make clear which methods and pure functions and which are non-modifiers.
// TODO Annotate all attributes as instance-private..
public class Rational {

	final private int numerator;
	final private int denominator;

	public Rational(int numerator, int denominator) {
		if (denominator == 0)
			throw new IllegalArgumentException(
					"Illegal value of denominator. Should be != 0, was "
							+ denominator + ".");

		if (denominator < 0) {
			numerator = -numerator;
			denominator = -denominator;
		}

		int gcd = gcd(numerator, denominator);

		this.numerator = numerator / gcd;
		this.denominator = denominator / gcd;

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
		checkInvariant();

		final int prime = 31;
		int result = 1;
		result = prime * result + denominator;
		result = prime * result + numerator;

		checkInvariant();

		return result;
	}

	@Override
	public boolean equals(final Object object) {
		checkInvariant();

		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;

		Rational other = (Rational) object;

		checkInvariant();

		return denominator == other.denominator && numerator == other.numerator;
	}

	public static Rational sumOf(final Rational aRational,
			final Rational anotherRational) {

		// Rethink calculation in order to avoid overflows.
		return new Rational(aRational.getNumerator()
				* anotherRational.getDenominator()
				+ anotherRational.getNumerator() * aRational.getDenominator(),
				aRational.denominator * anotherRational.getDenominator());

	}

	private void checkInvariant() {
		assert 0 < denominator : "Illegal state. Denominator should be > 0, is "
				+ denominator + ".";
		assert gcd(numerator, denominator) == 1 : "Illegal state. gcd(numerator, denominator) should be 1, is "
				+ gcd(numerator, denominator) + ".";
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
