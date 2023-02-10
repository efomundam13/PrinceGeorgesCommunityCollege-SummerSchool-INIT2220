public class MyClass
{

   /**

      Because the generic type T can represent any class type, 
      the client could pass to this method an array of objects 
      that do not have a compareTo method. For this reason, the 
      compiler will issue a syntax error.

    */

   // First draft and INCORRECT:

   public static <T> T arrayMinimum(T[] anArray)
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
       System.out.print("Smallest entry in array is " + arrayMinimum(stringArray));

    } // end main
} // end MyClass