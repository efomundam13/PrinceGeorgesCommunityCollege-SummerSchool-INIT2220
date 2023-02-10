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

	/**
	 * Sets initial values in constructor to null
	 */
	public BasicLinkedList() {
		head = null;
		tail = null;
		listSize = 0;
	}
	
	/**
	 * Allows access to the size 
	 * @return size
	 */
	public int getSize() {
		return listSize;
	}
	
	/**
	 * Creates a node with the data at the end of the list
	 * If the list is empty makes new node that is both the head and tail
	 * It increments size accordingly
	 * Returns current list
	 * @param data
	 * @return this
	 */
	public BasicLinkedList<T> addToEnd(T data) {
		Node newNode = new Node(data);
		if(tail == null) {
			tail = newNode;
			if (head == null) {
				head = newNode;
			}
			else {
				head.next = tail;
			}
		}
		else {
			tail.next = newNode;
			tail = newNode;
			tail.next = null;
		}
		listSize++;
		return this;	
	}
	
	/**
	 * Creates a node with the data at the front of the list
	 * Increments the size of the list
	 * Returns current list
	 * @param data
	 * @return this
	 */
	public BasicLinkedList<T> addToFront(T data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		listSize++;
		return this;
	}
	
	/**
	 * Returns the data that is stored in the head
	 * @return head.name
	 */
	public T getFirst() {
	    if (head == null) {
	        return null;
	    }
	    return head.data;
	}
	
	/**
	 * Returns the data that is stored in the tail
	 * @return tail.name
	 */
	public T getLast() {
	    if(tail == null){
	        return null;
	    }
	    return tail.data;
	}
	
	/**
	 * Returns the head.name
	 * Removes first node in list makes second node the new head
	 * @return head.name
	 */
	public T retrieveFirstElement() {
		Node temp = ((head.next).next);
		Node result = head;
		head = head.next;
		head.next = temp;
		listSize--;
		return (T) result.data;
	}
	
	/**
	 * Returns the tail.name
	 * Removes last node in list makes second to last node the new tail
	 * @return tail.name
	 */
	public T retrieveLastElement() {
		//need to add in what occurs if tail is null
		Node temp = head;
		Node result;
		boolean found = false;
		while(temp.next.next != null) {
				temp = temp.next;
				
		}
		result = tail;
		tail = new Node((T) temp);
		tail.next = null;
		
		listSize--;
		return (T) result.data;
	}
	
	/**
	 * Passes in name that needs to be removed and the comparator needed to test it.
	 * Checks to see if head is null, if it is no changes made
	 * Checks to see if the target is at the head if it is removes head
	 * Checks to see if the target is at the tail if it is removes tail
	 * If not the head using a loop cycles through the list to find target to remove makes (previous node).next = (target.next)
	 * Returns current list
	 * @param targetData
	 * @param comparator
	 * @return this
	 */
	public void remove(T targetData, Comparator<T> comparator) {
	    Node prev = null;
	    Node curr = head;
	    while(curr != null) {
	        if(comparator.compare(curr.data, targetData) == 0) {
	            //Check to see if we need to remove the very first element
	            if(curr == head) {
	                head = head.next;
	                curr = head;
	            } 
	            //Check to see if we need to remove the last element, in which case update the tail
	            else if(curr == tail) {
	                curr = null;
	                tail = prev;
	                prev.next = null;
	            }
	            //If anywhere else in the list
	            else {
	                prev.next = curr.next;
	                curr = curr.next;
	            }
	            listSize--;
	        } 
	        else {
	            prev = curr;
	            curr = curr.next;
	        }
	    }
	}
	
	/**
	 * called version of iterator
	 */
	@Override
	public Iterator<T> iterator() {
		return new BasicLinkedList.theIterator();
	}
	
	public ArrayList<T> getReverseArrayList() {
		ArrayList<T> revArrList = new ArrayList<T>();
		BasicLinkedList<T> rev = getReverseList();

		Node curr = rev.head;

		while(curr != null) {
			revArrList.add(curr.data);
			curr = curr.next;
		}
		return revArrList;
	}

	public BasicLinkedList<T> getReverseList() {
		BasicLinkedList<T> rev = new BasicLinkedList<T>();
		rev.head = reverseRecursive(duplicateList(this).head);
		Node curr = rev.head;
		while(curr.next != null) {
			curr = curr.next;
		}
		rev.tail = curr;
		rev.listSize = listSize;

		return rev;
	}
	
	private Node reverseRecursive(Node curr) {
		if(curr == null || curr.next == null) {
			return curr;
		}
		Node rev = reverseRecursive(curr.next);
		curr.next.next = curr;
		curr.next = null;
		return rev;
	}

	public BasicLinkedList<T> duplicateList(BasicLinkedList<T> original) {
		if(listSize == 0) {
			return null;
		}

		BasicLinkedList<T> cloned = new BasicLinkedList<T>();
		cloned.head = new Node(head.data);

		if (this.listSize == 1) {
			return cloned;
		}

		Node currC = cloned.head;
		Node currO = this.head;

		while (currO != null) {
			if (currO != head) {
				Node added = new Node(currO.data);
				currC.next = added;
				currC = currC.next;
			}
			currO = currO.next;
		}
		cloned.listSize = listSize;
		return cloned;
	}


	/**
	 * Creates Iterator where pos is the position of the nodes when cycling through the list
	 *
	 */
	public class theIterator implements Iterator<T> {
		public Node pos = head;
		
		@Override
		public boolean hasNext() {
			return (pos == null)?(false):(true);
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			else {
				T element = (T) pos.data;
				pos = pos.next;
				return (T) (element);
			}
		}
	}
	
	
}