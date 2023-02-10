public class MyClass2
{

   /**
       T is bound so that it represents class types
       that provide the method compareTo.

     */
   
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
   public static void main(String args[])
   {
       String[] stringArray = {"apple", "banana", "carrot", "dandelion"};
       System.out.print("Smallest entry in array is " + arrayMinimum(stringArray) );
       

    } // end main
} // end MyClass