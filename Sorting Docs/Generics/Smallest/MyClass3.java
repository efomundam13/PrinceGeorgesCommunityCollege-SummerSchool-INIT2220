public class MyClass3
{
   

   public static <T extends Comparable<T>> T arrayMinimum(T[] anArray)
   {
      T minimum = anArray[0];
      for (T arrayEntry : anArray)
      {
         if (arrayEntry.compareTo(minimum) < 0)
            minimum = arrayEntry;
      } // end for

      return minimum;
   } // end arrayMinimum

   public static <T> void displayArray(T[] anArray)
   {
      for (T arrayEntry : anArray)
      {
         System.out.print(arrayEntry);
         System.out.print(' ');
      } // end for
      System.out.println();
    } // end displayArray

   public static void main(String args[])
   {
       String[] stringArray = {"apple", "banana", "carrot", "dandelion"};
	System.out.print("characterArray contains ");
	displayArray(stringArray);
	System.out.println("Smallest entry in stringArray is " + arrayMinimum(stringArray) );
       
	

	Character[] characterArray = {'a', 'b', 'c', 'd'};
	System.out.print("characterArray contains ");
	displayArray(characterArray);
	System.out.println("Smallest entry in characterArray is " + arrayMinimum(characterArray) );

	Integer[] integerArray = {1987, 2019, 1066, 1929};
	System.out.print("integerArray contains ");
	displayArray(integerArray);
	System.out.println("Smallest entry in integerArray is " + arrayMinimum(integerArray) );

    } // end main
} // end MyClass