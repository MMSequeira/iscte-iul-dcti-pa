
template <int N>
struct Identity {
	enum { result = N };
};

template <int M, int N>
struct SumOf {
	enum { result = M + N};
};

template <int N>
struct FactorialOf {
	enum { result = N * FactorialOf<N - 1>::result };
};

//int n = 10;
//int m[n];

#include <iostream>

using namespace std;

int main() {
	cout << FactorialOf<20>::result << endl;
}
