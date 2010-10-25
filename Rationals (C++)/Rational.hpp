#ifndef RATIONAL_HPP_
#define RATIONAL_HPP_

#include <cassert>

namespace pt {
	namespace iscte {
		namespace dcti {
			namespace pa {
				class Rational {
				public:
					Rational(int const numerator = 0, int const denominator = 1);

					int numerator() const;

					int denominator() const;

					void operator+=(Rational otherRational);

					bool operator==(Rational otherRational) const;

				private:

					static int gcd(int firstValue, int secondValue);

					void reduce();

					void checkInvariant() const;

					int numerator_;
					int denominator_;
				};

				inline int Rational::numerator() const {
					checkInvariant();

					return numerator_;
				}

				inline int Rational::denominator() const {
					checkInvariant();

					return denominator_;
				}

				inline void Rational::checkInvariant() const {
					assert(0 < denominator_);
					assert(gcd(numerator_, denominator_) == 1);
				}

				inline void Rational::reduce() {
					assert(numerator_ != 0 || denominator_ != 0);

					int const greatest_common_divisor = gcd(numerator_, denominator_);

					numerator_ /= greatest_common_divisor;
					denominator_ /= greatest_common_divisor;
				}
			}
		}
	}
}

#endif /* RATIONAL_HPP_ */
