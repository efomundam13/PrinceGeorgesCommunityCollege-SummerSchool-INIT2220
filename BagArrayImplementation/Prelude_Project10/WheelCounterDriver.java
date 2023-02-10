/**
   This class demonstrates the class WheelCounter.

   @author Frank M. Carrano
   @version 5.0
 */
public class WheelCounterDriver
{
	public static void main(String[] args)
	{
      System.out.println("Here is a 4-wheel counter that begins at 0 0 0 0 and counts forward:");
      WheelCounter counter = new WheelCounter(4, 0, 2); // 4 wheels, each counting 0, 1, 2
      System.out.println(counter);

      for (int count = 1; count <= 16; count++)
      {
         counter.increaseCount();
         System.out.println(counter);
      } // end for

      System.out.println("The counter will now count backward:");
      for (int count = 1; count <= 16; count++)
      {
         counter.decreaseCount();
         System.out.println(counter);
      } // end for

      System.out.println("\nDone.");
	} // end main
} // end WheelCounterDriver

/*
 Here is a 4-wheel counter that begins at 0 0 0 0 and counts forward:
 0 0 0 0
 0 0 0 1
 0 0 0 2
 0 0 1 0
 0 0 1 1
 0 0 1 2
 0 0 2 0
 0 0 2 1
 0 0 2 2
 0 1 0 0
 0 1 0 1
 0 1 0 2
 0 1 1 0
 0 1 1 1
 0 1 1 2
 0 1 2 0
 0 1 2 1
 The counter will now count backward:
 0 1 2 0
 0 1 1 2
 0 1 1 1
 0 1 1 0
 0 1 0 2
 0 1 0 1
 0 1 0 0
 0 0 2 2
 0 0 2 1
 0 0 2 0
 0 0 1 2
 0 0 1 1
 0 0 1 0
 0 0 0 2
 0 0 0 1
 0 0 0 0
 
 Done.

 */
 
