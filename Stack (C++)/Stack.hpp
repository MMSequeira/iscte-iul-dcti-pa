#ifndef STACK_HPP_
#define STACK_HPP_

#include <cassert>

class Stack {
public:
	Stack()
	: capacity(10), number_of_items(0), items(new int[capacity]) {
		// TODO Implement this.
		cout << "Constructing stack!" << endl;
	}

	~Stack() {
		cout << "Destroying stack!" << endl;
		delete[] items;
	}

	bool isEmpty() {
		return size() == 0;
	}

	int size() {
		return number_of_items;
	}

	int top() {
		assert(!isEmpty());

		return items[number_of_items - 1];
	}

	void push(int const newItem) {
		if(number_of_items == capacity)
			increaseCapacity();

		items[number_of_items] = newItem;

		++number_of_items;
	}

	void pop() {
		assert(!isEmpty());

		--number_of_items;
	}

private:
	void increaseCapacity() {
		capacity *= 2;

		int* new_items = new int[capacity];

		for(int i = 0; i != number_of_items; ++i)
			new_items[i] = items[i];

		delete[] items;
		items = new_items;
	}

	int capacity;
	int number_of_items;
	int *items;
};

#endif /* STACK_HPP_ */
