import java.util.Iterator;
/**
   A driver that demonstrates the class LinkedListWithIterator.

   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Driver 
{
	public static void main(String[] args) 
	{
		testIteratorOperations();
		testExamples();
		System.out.println("\n\nDone.");
	}  // end main

	public static void testIteratorOperations()
	{
		System.out.println("Create a list: ");
		ListWithIteratorInterface<String> myList = new LinkedListWithIterator<>();
		System.out.println("Testing add to end: Add 15, 25, 35, 45, 55, 65, 75, 85, 95");
      myList.add("15");
      myList.add("25");
      myList.add("35");
      myList.add("45");
		myList.add("55");
		myList.add("65");
		myList.add("75");
		myList.add("85");
		myList.add("95");

		System.out.println("\n------------------------\n");
		System.out.println("\n\nList should contain\n15 25 35 45 55 65 75 85 95");
		System.out.println("\n\nUsing ADT list operations, the list contains ");
		displayList(myList);
		
		System.out.println("\n\nUsing Iterator methods hasNext and next, the list contains");
		Iterator<String> myIterator = myList.getIterator(); /// OR myList.iterator()

		while (myIterator.hasNext())
			System.out.print(myIterator.next() + " ");
		System.out.println();
		System.out.println();
		
      System.out.println("\n\nReturn iterator to beginning of list\n");
      myIterator = myList.iterator(); // Reset iterator to beginning
      
      // Advance through list
      System.out.println("next() should return 15 : " + myIterator.next());
      System.out.println("next() should return 25 : " + myIterator.next());
      System.out.println("next() should return 35 : " + myIterator.next());
      System.out.println("next() should return 45 : " + myIterator.next());
      System.out.println("next() should return 55 : " + myIterator.next());
      System.out.println("next() should return 65 : " + myIterator.next());
      System.out.println("next() should return 75 : " + myIterator.next());
      System.out.println("next() should return 85 : " + myIterator.next());
      System.out.println("next() should return 95 : " + myIterator.next());
      
      System.out.println("hasNext() should return false : " + myIterator.hasNext());
	} // end testIteratorOperations

	public static void testExamples()
	{
      // Example in Segment J4.6 of Java Interlude 4
      System.out.println("\nExample in Segment J4.6 of Java Interlude 4:");
		ListWithIteratorInterface<String> nameList = new LinkedListWithIterator<>();
		nameList.add("Jamie");
		nameList.add("Joey");
		nameList.add("Rachel");
		System.out.println("List is Jamie, Joey, Rachel");
		
		Iterator<String> nameIterator = nameList.iterator();
		
		System.out.println("Output should be: true Jamie Joey Rachel false");
		System.out.print(nameIterator.hasNext() + " ");
		System.out.print(nameIterator.next() + " ");
		System.out.print(nameIterator.next() + " ");
		System.out.print(nameIterator.next() + " ");
		System.out.println(nameIterator.hasNext());
//    nameIterator.next(); // Causes a NoSuchElementException.
// ============================================================================
      // Example in Segments J4.10 and J4.11 of Java Interlude 4
      System.out.println("-------------------------------" +
                         "\nSimilar to Example in Segments J4.10 and J4.11 of Java Interlude 4:");
		nameList = new LinkedListWithIterator<>();
		
		nameList.add("Brad");
	   nameList.add("Jane");
		nameList.add("Bob");
		nameList.add("Jane");
		nameList.add("Bette");
		nameList.add("Brad");
		nameList.add("Jane");
		nameList.add("Brenda");
		System.out.println("List contains Brad, Jane, Bob, Jane, Bette, Brad, Jane, Brenda\n"); 
		
      nameIterator = nameList.iterator();
		while (nameIterator.hasNext())
		{
         String currentName = nameIterator.next();
         int nameCount = 0;
         Iterator<String> countingIterator = nameList.iterator();
         while (countingIterator.hasNext())
         {
            String nextName = countingIterator.next();
            if (currentName.equals(nextName))
               nameCount++;
         } // end while
         System.out.println(currentName + " occurs " + 
                            nameCount + " times.");
		} // end while
		
		System.out.println("\nOutput should be:"); 	
		System.out.println("Brad occurs 2 times.");
		System.out.println("Jane occurs 3 times.");
		System.out.println("Bob occurs 1 times.");
		System.out.println("Jane occurs 3 times.");
		System.out.println("Bette occurs 1 times.");
		System.out.println("Brad occurs 2 times.");
		System.out.println("Jane occurs 3 times.");
		System.out.println("Brenda occurs 1 times.");
	} // end testExamples

	public static void displayList(ListInterface<String> list)
	{
      int numberOfEntries = list.getLength();

      System.out.println("\nThe list contains " + numberOfEntries +
                         " entries, as follows:");
      for (int position = 1; position <= numberOfEntries; position++)
         System.out.println(list.getEntry(position) + " is entry " + position);
      System.out.println();
	} // end displayList
}  // end Driver

/*
 Create a list:
 Testing add to end: Add 15, 25, 35, 45, 55, 65, 75, 85, 95
 
 ------------------------
 
 
 
 List should contain
 15 25 35 45 55 65 75 85 95
 
 
 Using ADT list operations, the list contains
 
 The list contains 9 entries, as follows:
 15 is entry 1
 25 is entry 2
 35 is entry 3
 45 is entry 4
 55 is entry 5
 65 is entry 6
 75 is entry 7
 85 is entry 8
 95 is entry 9
 
 
 
 Using Iterator methods hasNext and next, the list contains
 15 25 35 45 55 65 75 85 95
 
 
 
 Return iterator to beginning of list
 
 next() should return 15 : 15
 next() should return 25 : 25
 next() should return 35 : 35
 next() should return 45 : 45
 next() should return 55 : 55
 next() should return 65 : 65
 next() should return 75 : 75
 next() should return 85 : 85
 next() should return 95 : 95
 hasNext() should return false : false
 
 Example in Segment J4.6 of Java Interlude 4:
 List is Jamie, Joey, Rachel
 Output should be: true Jamie Joey Rachel false
 true Jamie Joey Rachel false
 -------------------------------
 Similar to Example in Segments J4.10 and J4.11 of Java Interlude 4:
 List contains Brad, Jane, Bob, Jane, Bette, Brad, Jane, Brenda
 
 Brad occurs 2 times.
 Jane occurs 3 times.
 Bob occurs 1 times.
 Jane occurs 3 times.
 Bette occurs 1 times.
 Brad occurs 2 times.
 Jane occurs 3 times.
 Brenda occurs 1 times.
 
 Output should be:
 Brad occurs 2 times.
 Jane occurs 3 times.
 Bob occurs 1 times.
 Jane occurs 3 times.
 Bette occurs 1 times.
 Brad occurs 2 times.
 Jane occurs 3 times.
 Brenda occurs 1 times.
 
 
 Done.
*/
