import java.util.*;


/**
 * Implements a generic sorted list using a provided Comparator. It extends
 * BasicLinkedList class.
 * 
 *  @author Dept of Computer Science, UMCP
 *  
 */

public class SortedLinkedList<T> extends BasicLinkedList<T> {
	private Comparator<T> comparator;
	
	/**
	 * Passes super from BasicLinkedList class
	 * Stores comparator to be called in add and remove methods
	 * @param comparator
	 */
	public SortedLinkedList(java.util.Comparator<T> theComparator) {
		super();
		comparator = theComparator;
	}
	
	/**
	 * Passes the element to put in newNode
	 * First checks to see if head is null if (true) then makes newNode head and head.next = tail
	 * Next checks checks to see if the element that is passed is null or if the tail is not null then
	 * 		**Checks to see element is null then puts newNode as tail
	 * 		**Checks to see if element is before the head then sent as head when true
	 * 		**Checks to see if element is after the tail then set as tail when true
	 * 		**Else cycles through compares nodes to find placement in list to add newNode
	 *  
	 * @param element
	 * @return this
	 */
	public SortedLinkedList<T> add(T element) {
		Node newNode = new Node(element);
		Node temp = head;

		if(head == null) {
			newNode.next = tail;
			head = newNode;
			tail = newNode;
		} 
		else {
			if(comparator.compare((T) head.data, element) > 0) {
				newNode.next = head;
				head = newNode;
			} 
			else {
				if(comparator.compare((T) tail.data, element) < 0) {
					tail.next = newNode;
					tail = newNode;
					tail.next = null;
				} 
				else {
					while(comparator.compare((T) temp.next.data, element) < 0) {
						temp = temp.next;
					}
					newNode.next = temp.next;
					temp.next = newNode;
				}
			} 
		}
		listSize++;
		return this;
	}
	
	/**
	 * See remove doc in BasicLinkedList
	 * @param targetData
	 * @return
	 */
	public BasicLinkedList<T> remove(T targetData) {
		super.remove(targetData, comparator);
		return this;
		
	}
	
	/**
	 * Cannot be added to specific place if sorted list
	 * @param data
	 * @return this
	 */
	public BasicLinkedList<T> addToEnd(T data) {
		if(this instanceof SortedLinkedList) {
			throw new UnsupportedOperationException("Invalid operation for sorted list");
		}
		super.addToEnd(data);
		return this;
	}
	
	/**
	 * Cannot be added to specific place if sorted list
	 * @param data
	 * @return this
	 */
	public BasicLinkedList<T> addToFront(T data) {
		if(this instanceof SortedLinkedList) {
			throw new UnsupportedOperationException("Invalid operation for sorted list");
		}
		super.addToFront(data);
		return this;	
	}
}