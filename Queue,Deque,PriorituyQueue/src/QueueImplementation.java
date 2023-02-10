/** A class that implements a queue of objects by using
   a chain of linked nodes that has both head and tail references. */
public final class LinkedQueue<T> implements QueueInterface<T>
{
   private Node firstNode; // References node at front of queue
   private Node lastNode;  // References node at back of queue
  	
	public LinkedQueue()
	{
		firstNode = null;
		lastNode = null;
	} // end default constructor

//  < Implementations of the queue operations go here. >
//  . . .

	private class Node
	{
//  < Implementation of the inner class Node goes here. >

	} // end Node
} // end LinkedQueue
public void enqueue(T newEntry)
{
   Node newNode = new Node(newEntry, null);

   if (isEmpty())
      firstNode = newNode;
   else
      lastNode.setNextNode(newNode);
    
   lastNode = newNode;
} // end enqueue
public T getFront()
{
   if (isEmpty())
      throw new EmptyQueueException();
   else
      return firstNode.getData();
} // end getFront
public T dequeue()
{
   T front = getFront();  // Might throw EmptyQueueException
   // Assertion: firstNode != null
   firstNode.setData(null);
   firstNode = firstNode.getNextNode();

   if (firstNode == null)
      lastNode = null;

   return front;
} // end dequeue
public boolean isEmpty()
{
   return (firstNode == null) && (lastNode == null);
} // end isEmpty

public void clear()
{
   firstNode = null;
   lastNode = null;
} // end clear
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Array-Based Implementation of a Queue: Circular Array
Circular Array with One Unused Location
public T getFront()
{
   checkIntegrity();
   if (isEmpty())
      throw new EmptyQueueException();
   else
      return queue[frontIndex];
} // end getFront
public T dequeue()
{
   checkIntegrity();
   if (isEmpty())
      throw new EmptyQueueException();
   else
   {
      T front = queue[frontIndex];
      queue[frontIndex] = null;
      frontIndex = (frontIndex + 1) % queue.length;
      return front;
   } // end if
} // end dequeue

DOUBLE SIZE
// Doubles the size of the array queue if it is full.
// Precondition: checkIntegrity has been called.
private void ensureCapacity()
{
   if (frontIndex == ((backIndex + 2) % queue.length)) // If array is full,
   {                                                   // double size of array
      T[] oldQueue = queue;
      int oldSize = oldQueue.length;
      int newSize = 2 * oldSize;
      checkCapacity(newSize);
      integrityOK = false;

      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempQueue = (T[]) new Object[newSize];
      queue = tempQueue;
      for (int index = 0; index < oldSize - 1; index++)
      {
         queue[index] = oldQueue[frontIndex];
         frontIndex = (frontIndex + 1) % oldSize;
      } // end for
      
      frontIndex = 0;
      backIndex = oldSize - 2;
      integrityOK = true;
   } // end if
} // end ensureCapacity
public boolean isEmpty()
{
   checkIntegrity():
   return frontIndex == ((backIndex + 1) % queue.length);
} // end isEmpty

Two-Part Circular Linked Chain
/**  A class that implements the ADT queue by using
   a two-part circular chain of linked nodes. */
public final class TwoPartCircularLinkedQueue<T> implements QueueInterface<T>
{
   private Node queueNode; // References first node in queue
   private Node freeNode;  // References node after back of queue
   
   public TwoPartCircularLinkedQueue()
   {
      freeNode = new Node(null, null);
      freeNode.setNextNode(freeNode);
      queueNode = freeNode;
   } // end default constructor

   //  < Implementations of the queue operations go here. >
   //  . . .

	private class Node
	{
   //  < Implementation of the nine Node class god here. >
	} // end Node
} // end TwoPartCircularLinkedQueue
public void enqueue(T newEntry)
{
   freeNode.setData(newEntry);

   if (isNewNodeNeeded())
   {
      // Allocate a new node and insert it after the node that
      // freeNode references
      Node newNode = new Node(null, freeNode.getNextNode());
      freeNode.setNextNode(newNode);
   } // end if

   freeNode = freeNode.getNextNode();
} // end enqueue
public T getFront()
{
   if (isEmpty())
      throw new EmptyQueueException();
   else
      return queueNode.getData();
} // end getFront
public T dequeue()
{
   T front = getFront();  // Might throw EmptyQueueException
   // Assertion: Queue is not empty
   queueNode.setData(null);
   queueNode = queueNode.getNextNode();

   return front;
} // end dequeue
public boolean isEmpty()
{
   return queueNode == freeNode;
} // end isEmpty

private boolean isNewNodeNeeded()
{
   return queueNode == freeNode.getNextNode();
} // end isNewNodeNeeded