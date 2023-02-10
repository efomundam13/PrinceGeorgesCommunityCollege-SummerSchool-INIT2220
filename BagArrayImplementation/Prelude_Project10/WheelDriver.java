/**
   This class demonstrates the class Wheel.

   @author Frank M. Carrano
   @version 5.0
 */
public class WheelDriver
{
	public static void main(String[] args)
	{
      Wheel counter = new Wheel(0, 3); // Counting 0 to 3

      System.out.println("Initial count: " + counter);
      System.out.print("Counting to 3: ");
      for (int i = 0; i < 3; i++)
      {
         counter.increaseValue();
         System.out.print(counter + " ");
      } // end for
      System.out.println();
      
      System.out.print("Counting further: ");
      for (int i = 0; i < 81; i++)
      {
         counter.increaseValue();
         System.out.print(counter + " ");
      } // end for
      System.out.println();
	} // end main
	
} // end WheelDriver

/*
 Initial count: 0
 Counting to 3: 1 2 3
 Counting further: 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 0
 */
 
