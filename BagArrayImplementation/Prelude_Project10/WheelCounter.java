/**
   This class implements a general wheel counter having a given number of wheels
   numbered right to left as 1, 2, ....
   The rightmost wheel turns fastest.

   @author Charles Hoot
   @author Frank M. Carrano 
   @version 5.2
 */
public class WheelCounter implements WheelCounterInterface
{
	private WheelInterface[] wheels; // wheels[0] is wheel #1, wheels[1] is wheel #2, ...
	private int numberOfWheels;
   
   /** Creates a wheel counter having a given number of wheels, each with
       the same range of values and initalized to the minimumValue.
       @param desiredNumberOfWheels  The number of wheels in the counter.
       @param minimumValue  The smallest value of each wheel.
       @param maximumValue  The largest value of each wheel.    */
	public WheelCounter(int desiredNumberOfWheels, int minimumValue, int maximumValue)
	{
		numberOfWheels = desiredNumberOfWheels;
      
      // Allocate the array of wheels
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		WheelInterface[] temp = new Wheel[numberOfWheels]; // Unchecked cast
		wheels = temp;
      
      // Create the wheels
      for (int i = 0; i < numberOfWheels; i++)
         wheels[i] = new Wheel(minimumValue, maximumValue);
	} // end constructor

   public void setNumberOfWheels(int number)
   {
      numberOfWheels = number;
   } // end getNumberOfWheels
   
   public int getNumberOfWheels()
   {
      return numberOfWheels;
   } // end setNumberOfWheels
   
   public void reset()
   {
      for (int i = 0; i < numberOfWheels; i++)
         wheels[i].reset();
   } // end reset

   public void increaseCount()
   {
      increaseCounter(0);
   } // end increaseCount

   private void increaseCounter(int wheelIndex)
   {
      // wheelIndex begins at 0

      if (wheelIndex < numberOfWheels)
      {
         wheels[wheelIndex].increaseValue();
         if ((wheelIndex < numberOfWheels - 1) && (wheels[wheelIndex].hasRolledToMinimum()))
            increaseCounter(wheelIndex + 1);
         // else wheelIndex == numberOfWheels - 1
         else if (wheels[wheelIndex].hasRolledToMinimum())
            throw new RuntimeException("Wheel counter has gone beyond its maximum value.");
      } // end if
   } // end increaseCounter
   
   public void decreaseCount()
   {
      decreaseCounter(0);
   } // end decreaseCount
   
   private void decreaseCounter(int wheelIndex)
   {
      // wheelIndex begins at 0
      
      if (wheelIndex < numberOfWheels)
      {
         wheels[wheelIndex].decreaseValue();
         if ((wheelIndex < numberOfWheels - 1) && (wheels[wheelIndex].hasRolledToMaximum()))
            decreaseCounter(wheelIndex + 1);
         // else wheelIndex == numberOfWheels - 1
         else if (wheels[wheelIndex].hasRolledToMaximum())
            throw new RuntimeException("Wheel counter has gone beyond its minimum value.");
      } // end if
   } // end decreaseCounter

   public int getWheelValue(int wheelNumber)
	{
      // wheelNumber begins at 1
      // wheelIndex begins at 0
      int wheelIndex = wheelNumber - 1;

      int result = -99;
		if ((wheelIndex >= 0) && (wheelIndex < numberOfWheels))
          result = wheels[wheelIndex].getValue();
      return result; // Or throw an exception if wheelNumber is out of range
                     // instead of returning -99
	} // end getWheelValue

	public String toString()
	{
		String result = "";
		for (int i = 0; i < numberOfWheels; i++)
			result = wheels[i].getValue() + " " + result;
      
		return result;
	} // end toString
} // end WheelCounter
