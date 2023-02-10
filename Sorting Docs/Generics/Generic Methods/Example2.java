//
// Illustartes use of a Generic method
//
public class Example2
{
   public static <T> void displayArray(T[] anArray)
   {
      for (int count=0; count < anArray.length; count++)
      {
         System.out.print(anArray[count]);
         System.out.print(' ');
      } // end for
      System.out.println();
    } // end displayArray

    public static void main(String args[])
    {
       String[] stringArray = {"apple", "banana", "carrot", "dandelion"};
       System.out.print("stringArray contains ");
       displayArray(stringArray);

       Character[] characterArray = {'a', 'b', 'c', 'd'};
       System.out.print("characterArray contains ");
       displayArray(characterArray);

       Integer[] integerArray = {1987, 2019, 1066, 1929};
       System.out.print("integerArray contains ");
       displayArray(integerArray);

    } // end main
} // end Example
