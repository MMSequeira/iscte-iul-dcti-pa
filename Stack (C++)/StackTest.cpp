#include <iostream>

using namespace std;

#include "Stack.hpp"

class Incrementer {
public:
	Incrementer(int increment)
	: increment(increment) {

	}

	int operator()(int value) {
		return value + increment;
	}

private:
	int increment;
};

template <int n>
struct Factorial {
	enum {value = n * Factorial<n - 1>::value};
};

template <>
struct Factorial<0> {
	enum {value = 1};
};

int m = 10;
int mm[Factorial<5>::value];

int main() {
	Incrementer incrementer{10};

	cout << incrementer(3) << endl;


	Stack<int> stack;
	Stack<int> anotherStack(stack);

	(anotherStack = stack).push(100);

	for(int i = 0; i != 20; ++i)
		stack.push(i);

	while(!stack.isEmpty()) {
		cout << stack.top() << endl;
		stack.pop();
	}
}
