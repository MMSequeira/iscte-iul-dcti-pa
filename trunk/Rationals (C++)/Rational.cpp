#include "Rational.hpp"

pt::iscte::dcti::pa::Rational::Rational(int const numerator, int const denominator) :
	numerator_(numerator), denominator_(denominator) {
	assert(denominator != 0);

	if (denominator < 0) {
		numerator_ = -numerator;
		denominator_ = -denominator;
	}

	reduce();

	checkInvariant();
}

int pt::iscte::dcti::pa::Rational::gcd(int firstValue, int secondValue) {
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

void pt::iscte::dcti::pa::Rational::operator+=(Rational otherRational) {
	checkInvariant();

	numerator_ = otherRational.denominator() * numerator() + denominator() * otherRational.numerator();
	denominator_ *= otherRational.denominator();

	reduce();

	checkInvariant();
}

bool pt::iscte::dcti::pa::Rational::operator==(Rational otherRational) const {
	checkInvariant();

	return numerator() == otherRational.numerator() && denominator() == otherRational.denominator();
}


#include <iostream>

using namespace std;
using namespace pt::iscte::dcti::pa;

int main() {
	cout << "Starting tests." << endl;

	cout << "Constructing r1." << endl;
	Rational r1(3, 2);

	cout << "Constructing r2." << endl;
	Rational r2(1, 2);

	cout << "Adding r2 to r1." << endl;
	r1 += r2;

	cout << "Assigning r1 to r2." << endl;
	r2 = r1;

	cout << "Checking correction of addition." << endl;
	assert(r1 == 2);

	Rational const r3(1, 3);

	cout << r3.numerator() << endl;
}


