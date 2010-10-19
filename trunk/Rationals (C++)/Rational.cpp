#include "Rational.hpp"

Rational::Rational(int const numerator, int const denominator) :
	numerator_(numerator), denominator_(denominator) {
	assert(denominator != 0);

	if (denominator < 0) {
		numerator_ = -numerator;
		denominator_ = -denominator;
	}

	int const greatest_common_divisor = gcd(numerator_, denominator_);

	numerator_ /= greatest_common_divisor;
	denominator_ /= greatest_common_divisor;

	checkInvariant();
}

int Rational::gcd(int firstValue, int secondValue) {
	assert(firstValue != 0 || secondValue != 0);

	if (firstValue < 0)
		firstValue = -firstValue;
	if (secondValue < 0)
		secondValue = -secondValue;

	while (firstValue != 0) {
		int const oldFirstValue = firstValue;
		firstValue = secondValue % firstValue;
		secondValue = oldFirstValue;
	}

	return secondValue;
}
