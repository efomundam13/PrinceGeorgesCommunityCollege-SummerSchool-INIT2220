package listClasses;

import java.util.*;


public class BasicLinkedList<T> implements Iterable<T> {
	
	/* Node definition */
	protected class Node {
		protected T data;
		protected Node next;

		protected Node(T data) {
			this.data = data;
			next = null;
		}
	}

	/* We have both head and tail */
	protected Node head, tail;
	
	/* size */
	protected int listSize;
	
}