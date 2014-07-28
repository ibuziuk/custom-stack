package my.custom.stack;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private int customCapacity;
	private int size;
	private Object[] elements;

	public ArrayStack() {
		this.elements = new Object[DEFAULT_CAPACITY];
	}

	public ArrayStack(int capacity) {
		if (capacity > 0) {
			this.customCapacity = capacity;
			this.elements = new Object[capacity];
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void push(E e) {
		if (size == elements.length) {
			ensureCapacity();
		}
		elements[size++] = e;
	}

	public E pop() {
		if (!empty()) {
			E e = (E) elements[--size];
			elements[size] = null;
			return e;
		}
		return null;
	}

	public E top() {
		if (!empty()) {
			return (E) elements[size() - 1];			
		}
		return null;
	}

	public boolean empty() {
		return size == 0 ? true : false;
	}

	public void clear() {
		if (customCapacity == 0) {
			this.elements = new Object[DEFAULT_CAPACITY];
		} else {
			this.elements = new Object[customCapacity];
		}
		size = 0;
	}
    
	/** 
	 * @return the number of elements in the stack
	 */
	public int size() {
		return this.size;
	}

	private void ensureCapacity() {
		elements = Arrays.copyOf(elements, elements.length * 2);
	}

}
