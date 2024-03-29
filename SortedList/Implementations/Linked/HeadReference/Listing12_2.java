/** 
   A driver that demonstrates the class LList.
   See Listing 12-2
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class Listing12_2
{
   public static void main(String[] args)
   {
      System.out.println("Create an empty list.");
      ListInterface<String> myList = new LList<String>();
      System.out.println("List should be empty; isEmpty returns " +
                         myList.isEmpty() + ".");

      System.out.println("\nTesting add to end:");
      myList.add("15");
      myList.add("25");
      myList.add("35");
      myList.add("45");
      System.out.println("List should contain 15 25 35 45.");
      displayList(myList);
      System.out.println("List should not be empty; isEmpty() returns " +
                         myList.isEmpty() + ".");
      System.out.println("\nTesting clear():");
      myList.clear();
      System.out.println("List should be empty; isEmpty returns " +
                         myList.isEmpty() + ".");
   }  // end main

   public static void displayList(ListInterface<String> list)
   {
      System.out.println("The list contains " + list.getLength() +
                         " entries, as follows:");
      Object[] listArray = list.toArray();
      for (int index = 0; index < listArray.length; index++)
      {
         System.out.print(listArray[index] + " ");
      } // end for
      System.out.println();
   } // end displayList
}  // end Listing12_2
/*
 Create an empty list.
 List should be empty; isEmpty returns true.
 
 Testing add to end:
 List should contain 15 25 35 45.
 The list contains 4 entries, as follows:
 15 25 35 45
 List should not be empty; isEmpty() returns false.
 
 Testing clear():
 List should be empty; isEmpty returns true.
 
*/
