package my.custom.stack;

public interface Stack<E> {
	void push(E e);

	E pop();

	E top();

	boolean empty();

	void clear();

	int size();
}
