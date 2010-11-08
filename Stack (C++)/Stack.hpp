#ifndef STACK_HPP_
#define STACK_HPP_

#include <cassert>
#include <algorithm>

template <typename I>
class Stack {
public:
	typedef I Item;

	Stack()
	: capacity(10), number_of_items(0), items(new Item[capacity]) {
		cout << "Constructing stack!" << endl;
	}

	Stack(Stack const& originalStack)
	: capacity(originalStack.capacity),
	  number_of_items(originalStack.number_of_items),
	  items(new Item[capacity]) {

		for(int i = 0; i != number_of_items; ++i)
			items[i] = originalStack.items[i];

		cout << "Constructing stack by copy!" << endl;
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

	Item top() {
		assert(!isEmpty());

		return items[number_of_items - 1];
	}

	void push(Item const& newItem) {
		if(number_of_items == capacity)
			increaseCapacity();

		items[number_of_items] = newItem;

		++number_of_items;
	}

	void pop() {
		// TODO Shrink array capacity to half whenever possible.
		assert(!isEmpty());

		--number_of_items;
	}

	void swap(Stack& anotherStack) {
		std::swap(capacity, anotherStack.capacity);
		std::swap(number_of_items, anotherStack.number_of_items);
		std::swap(items, anotherStack.items);
	}

	Stack& operator=(Stack const& modelStack) {
		Stack clone{modelStack};

		swap(clone);

		return *this;
	}

private:
	void increaseCapacity() {
		capacity *= 2;

		Item* new_items = new Item[capacity];

		for(int i = 0; i != number_of_items; ++i)
			new_items[i] = items[i];

		delete[] items;
		items = new_items;
	}

	int capacity;
	int number_of_items;
	Item *items;
};

#endif /* STACK_HPP_ */
