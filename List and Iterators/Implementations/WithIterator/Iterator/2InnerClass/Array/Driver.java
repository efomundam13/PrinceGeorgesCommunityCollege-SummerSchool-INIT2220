import java.util.Iterator;
/**
   A driver that demonstrates the class ArrayListWithIterator.

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
		ListWithIteratorInterface<String> myList = new ArrayListWithIterator<>();
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
		System.out.println("Testing Iterator's hasNext and next methods:");
		
		System.out.println("\n\nList should contain\n15 25 35 45 55 65 75 85 95");
		System.out.println("\n\nUsing ADT list operations, the list contains ");
		displayList(myList);
		
		System.out.println("\n\nUsing Iterator methods, the list contains");
		Iterator<String> myIterator = myList.iterator();

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
      System.out.println("----------------------\n\n");
		System.out.println("\n\nTesting Iterator's remove() method:");
		System.out.println("\n\nReturn iterator to beginning of list\n");
		myIterator = myList.iterator(); // Reset iterator to beginning
		
		System.out.println("Removing current entry : " + myIterator.next() + " : should be 15"); 
		myIterator.remove();                         // Remove entry 1
		System.out.println("List should contain\n25 35 45 55 65 75 85 95");
		System.out.println("\n\nUsing ADT list operations, the list contains ");
		displayList(myList);
		
		System.out.println("Removing current entry: " + myIterator.next() + " : should be 25");
		myIterator.remove();  
		System.out.println("List should contain\n35 45 55 65 75 85 95");
		System.out.println("\n\nUsing ADT list operations, the list contains ");
		displayList(myList);
		
		// Advance twice
		System.out.println("Skipping over " + myIterator.next() + " : should be 35");
		
		System.out.println("Removing current entry: " + myIterator.next() + " : should be 45");
		myIterator.remove();  
		System.out.println("List should contain\n35 55 65 75 85 95");
		System.out.println("\n\nUsing ADT list operations, the list contains ");
		displayList(myList);

		// Aadvance 3 times
		System.out.println("Skipping over " + myIterator.next() + " : should be 55");
		System.out.println("Skipping over " + myIterator.next() + " : should be 65");
		System.out.println("Skipping over " + myIterator.next() + " : should be 75");
		System.out.println("Removing current entry: " + myIterator.next() + " : should be 85");
		myIterator.remove();  
		System.out.println("List should contain\n35 55 65 75 95");
		System.out.println("\n\nUsing ADT list operations, the list contains ");
		displayList(myList);
		
		System.out.println("next() should return 95 : " + myIterator.next());
		System.out.println("hasNext() should return false : " + myIterator.hasNext());
		System.out.println("===========================================================\n\n");
	} // end testIteratorOperations

	public static void testExamples()
	{
      // Example in Segment J4.6 of Java Interlude 4
      System.out.println("\nExample in Segment J4.6 of Java Interlude 4:");
		ListWithIteratorInterface<String> nameList = new ArrayListWithIterator<>();
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
// Example in Segment J4.8 of Java Interlude 4
      System.out.println("-------------------------------" +
                         "\nExample in Segment J4.8 of Java Interlude 4:");
		nameList = new ArrayListWithIterator<>();
		nameList.add("Andy");
		nameList.add("Brittany");
		nameList.add("Chris");
		System.out.println("List is Andy, Brittany, Chris");
		
		nameIterator = nameList.iterator();
		System.out.println("Output should be: Andy Brittany Chris");
		System.out.print(nameIterator.next() + " ");
		System.out.print(nameIterator.next() + " ");
		nameIterator.remove();
		System.out.println(nameIterator.next() + " ");		  
      // ============================================================================

		// Question 1 in Java Interlude 4, but with ArrayListWithIterator
      System.out.println("-------------------------------" +
                         "\nSimilar to Question 1 in Java Interlude 4:");
		nameList = new ArrayListWithIterator<>();
		nameList.add("Jamie");
		nameList.add("Joey");
		nameList.add("Rachel");
		System.out.println("List is Jamie, Joey, Rachel");
		
		nameIterator = nameList.iterator();
		nameIterator.next();
		nameIterator.next();
		nameIterator.remove();
		System.out.println(nameIterator.hasNext());
		System.out.println(nameIterator.next());
		displayList(nameList);          
      // ============================================================================

      // Example in Segments J4.10 and J4.11 of Java Interlude 4, but with ArrayListWithIterator
      System.out.println("-------------------------------" +
                         "\nSimilar to Example in Segments J4.10 and J4.11 of Java Interlude 4:");
		nameList = new ArrayListWithIterator<>();
		
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
		System.out.println("======================");
      // ============================================================================
      
      // Example in Segments J4.10 and J4.11 of Java Interlude 4, but with ArrayListWithIterator
      // and without duplicates

		System.out.println("\nRepeat without duplicates:");
		
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
            {
               nameCount++;
               if (nameCount > 1)
                  countingIterator.remove();
            } // end if
         } // end while
         System.out.println(currentName + " occurs " + nameCount + " times.");
		} // end while
	} // end testExamples

	public static void displayList(ListWithIteratorInterface<String> list)
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
 
 Testing Iterator's hasNext and next methods:
 
 
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
 
 
 
 Using Iterator methods, the list contains
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
 ----------------------
 
 
 
 
 Testing Iterator's remove() method:
 
 
 Return iterator to beginning of list
 
 Removing current entry : 15 : should be 15
 List should contain
 25 35 45 55 65 75 85 95
 
 
 Using ADT list operations, the list contains
 
 The list contains 8 entries, as follows:
 25 is entry 1
 35 is entry 2
 45 is entry 3
 55 is entry 4
 65 is entry 5
 75 is entry 6
 85 is entry 7
 95 is entry 8
 
 Removing current entry: 25 : should be 25
 List should contain
 35 45 55 65 75 85 95
 
 
 Using ADT list operations, the list contains
 
 The list contains 7 entries, as follows:
 35 is entry 1
 45 is entry 2
 55 is entry 3
 65 is entry 4
 75 is entry 5
 85 is entry 6
 95 is entry 7
 
 Skipping over 35 : should be 35
 Removing current entry: 45 : should be 45
 List should contain
 35 55 65 75 85 95
 
 
 Using ADT list operations, the list contains
 
 The list contains 6 entries, as follows:
 35 is entry 1
 55 is entry 2
 65 is entry 3
 75 is entry 4
 85 is entry 5
 95 is entry 6
 
 Skipping over 55 : should be 55
 Skipping over 65 : should be 65
 Skipping over 75 : should be 75
 Removing current entry: 85 : should be 85
 List should contain
 35 55 65 75 95
 
 
 Using ADT list operations, the list contains
 
 The list contains 5 entries, as follows:
 35 is entry 1
 55 is entry 2
 65 is entry 3
 75 is entry 4
 95 is entry 5
 
 next() should return 95 : 95
 hasNext() should return false : false
 ===========================================================
 
 
 
 Example in Segment J4.6 of Java Interlude 4:
 List is Jamie, Joey, Rachel
 Output should be: true Jamie Joey Rachel false
 true Jamie Joey Rachel false
 -------------------------------
 Example in Segment J4.8 of Java Interlude 4:
 List is Andy, Brittany, Chris
 Output should be: Andy Brittany Chris
 Andy Brittany Chris
 -------------------------------
 Similar to Question 1 in Java Interlude 4:
 List is Jamie, Joey, Rachel
 true
 Rachel
 
 The list contains 2 entries, as follows:
 Jamie is entry 1
 Rachel is entry 2
 
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
 ======================
 
 Repeat without duplicates:
 Brad occurs 2 times.
 Jane occurs 3 times.
 Bob occurs 1 times.
 Bette occurs 1 times.
 Brenda occurs 1 times.
 
 
 Done.
*/
