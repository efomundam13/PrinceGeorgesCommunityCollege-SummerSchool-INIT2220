import java.util.EmptyStackException;
/**
 * A class of stacks in a chain of nodes.
 * @author Frank M. Carrano and Timothy M. Henry
 * @version 4.0
 */
public class LinkedStack<T> implements StackInterface<T> {
	private Node topNode; //references the first node in chain
	
	public LinkedStack() {
		topNode = null;
	} //end default constructor
	
	public void push(T newEntry) {
		Node newNode = new Node(newEntry);
		newNode.next = topNode;
		topNode = newNode;
	}
	
	public T pop() {
		T result = topNode.data;
		topNode = topNode.next;
		return result;
	}
	
	public T peek() {
		return topNode.data;
	}
	
	public boolean isEmpty() {
		return topNode == null;
	}
	
	public void clear() {
		T tempNode;
		while(!isEmpty())
			tempNode = pop();
	}
	
private class Node {
	private T data; //Entry in stack
	private Node next; //Link to next node
	
	private Node(T dataPortion) {
		this(dataPortion, null);
	} //End constructor
	
	private Node(T dataPortion, Node linkPortion) {
		data = dataPortion;
		next = linkPortion;
	} //End constructor
	
	private T getData() {
		return data;
	} //End getData
	
	private void setData(T newData) {
		data = newData;
	} //end setData
	
	private Node getNextNode() {
		return next;
	} //end getNextNode
	
	private void setNextNode(Node nextNode) {
		next = nextNode;
	} //end setNextNode
} //end Node
} //end LinkedStack
