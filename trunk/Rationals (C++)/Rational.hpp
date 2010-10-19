#ifndef RATIONAL_HPP_
#define RATIONAL_HPP_

#include <cassert>

class Rational {

public:
	Rational(int const numerator = 0, int const denominator = 1);

	int numerator();

	int denominator();

private:

	static int gcd(int firstValue, int secondValue);

	void checkInvariant();

	int numerator_;
	int denominator_;
};

inline int Rational::numerator() {
	checkInvariant();

	return numerator_;
}

inline int Rational::denominator() {
	checkInvariant();

	return denominator_;
}

inline void Rational::checkInvariant() {
	assert(0 < denominator_);
	assert(gcd(numerator_, denominator_) == 1);
}

#endif /* RATIONAL_HPP_ */
