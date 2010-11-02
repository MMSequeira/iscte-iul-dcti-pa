#include <iostream>

using namespace std;

#include "Stack.hpp"

int main() {
	Stack stack;
	Stack anotherStack = stack;

	for(int i = 0; i != 20; ++i)
		stack.push(i);

	while(!stack.isEmpty()) {
		cout << stack.top() << endl;
		stack.pop();
	}
}
