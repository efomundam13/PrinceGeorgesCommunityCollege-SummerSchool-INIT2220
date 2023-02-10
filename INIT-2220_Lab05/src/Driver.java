import java.util.*;
/** 
   A driver that demonstrates the iterator's remove method
   with the class LinkedListWithIterator.

   @author Frank M. Carrano
   @version 5.0
 */
public class Driver 
{
	public static void main (String args[])
	{
		ListWithIteratorInterface<String> list = new LinkedListWithIterator<>();

		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		System.out.println("Here is the list as seen by the iterator:");
		Iterator<String> iter = list.getIterator();
		while(iter.hasNext())
		{
			String data = iter.next();
			System.out.println("Data value is " + data);
		} // end while

		try
		{
			iter.next();		   // Should throw an error
			System.out.println("Oops... No exception");
		} // end try
		catch (NoSuchElementException e)
		{
			System.out.println("The expected exception was thrown!");
		} // end catch

		System.out.println("Begin iteration:");
		iter = list.getIterator();
		System.out.println("next() returns " + iter.next() + " (should be A)");

		System.out.println("remove() should remove A");
		iter.remove();

		System.out.println("next() returns " + iter.next() + " (should be B)");
		System.out.println("next() returns " + iter.next() + " (should be C)");

		System.out.println("remove() should remove C");
		iter.remove();

		System.out.println("List is now:");
		displayList(list);

		try
		{
			iter.remove();		   // Should throw an error
			System.out.println("Oops... No exception");
		} // end try
		catch (IllegalStateException e)
		{
			System.out.println("The expected exception was thrown!");
		} // end catch
	} // end main

	public static void displayList(ListInterface<String> aList)
	{
		System.out.println("The list contains " + aList.getLength() +
				" string(s), as follows:");		
		Object[] listArray = aList.toArray();
		for (int index = 0; index < listArray.length; index++)
		{
			System.out.print(listArray[index] + " ");
		} // end for

		System.out.println();
	}  // end displayList
}  // end Driver

/*
 Here is the list as seen by the iterator:
 Data value is A
 Data value is B
 Data value is C
 Data value is D
 The expected exception was thrown!
 Begin iteration:
 next() returns A (should be A)
 remove() should remove A
 next() returns B (should be B)
 next() returns C (should be C)
 remove() should remove C
 List is now:
 The list contains 2 string(s), as follows:
 B D
 The expected exception was thrown!
 */
