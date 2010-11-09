
template <int N>
struct Identity {
	enum { result = N };
};

template <int M, int N>
struct SumOf {
	enum { result = M + N};
};

template <int M, int N>
struct DivisionOf {
	enum { result = M / N};
};

template <int M>
struct DivisionOf<M, 0> {
};

template <typename T>
struct NumberTraits {
};

template <>
struct NumberTraits<int> {
	static int minimumValue() {
		return -12345;
	}
};

template <>
struct NumberTraits<short> {
	static short minimumValue() {
		return -123;
	}
};

template <int N>
struct FactorialOf {
	enum { result = N * FactorialOf<N - 1>::result };
};

template <>
struct FactorialOf<0> {
	enum { result = 1 };
};

template <int N>
struct FibonacciOf {
	enum { result = FibonacciOf<N - 1>::result + FibonacciOf<N - 2>::result };
};

template <>
struct FibonacciOf<0> {
	enum { result = 1 };
};

template <>
struct FibonacciOf<1> {
	enum { result = 1 };
};

template <typename H, typename T>
struct TypeList {
	typedef H Head;
	typedef T Tail;
};

struct EmptyList {
};

typedef TypeList<int, TypeList<char, TypeList<double, EmptyList> > > MyList;

template <typename L>
struct LengthOf {
	enum { result = 1 + LengthOf<typename L::Tail>::result };
};

template <>
struct LengthOf<EmptyList> {
	enum { result = 0 };
};

//int n = 10;
//int m[n];


struct A {

};

#include <iostream>

using namespace std;



int main() {
	cout << DivisionOf<10, 0>::result << endl;
	cout << LengthOf<MyList>::result << endl;
//	cout << LengthOf<A>::result << endl;
//	cout << NumberTraits<int>::minimumValue() << endl;
//	cout << NumberTraits<short>::minimumValue() << endl;
//	cout << FactorialOf<10>::result << endl;
//	cout << FibonacciOf<6>::result << endl;
}
