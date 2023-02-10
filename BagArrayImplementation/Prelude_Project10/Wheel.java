/**
   Each object in this class records an integer value that is between
   a minimum value and a maximum value. Increasing the count beyond its maximum
   will roll it over to the minimum value. Decreasing the count below its
   minimum will roll it over to the maximum value.

   @author Charles Hoot
   @author Frank M. Carrano
   @version 5.0
*/
public class Wheel implements WheelInterface
{
	private int min;
	private int max;
   private int value;
	private boolean lastIncreaseRolledOver; // Roll over from max value to minimum value
   private boolean lastDecreaseRolledOver; // Roll over from minimum value to max value

   /** Creates a Wheel object with given max and min values,
       and sets its value to the min value. */
	public Wheel(int minimum, int maximum)
	{
		min = minimum;
		max = maximum;
      value = min;
		lastIncreaseRolledOver = false;
      lastDecreaseRolledOver = false;
	} // end constructor

   public void setRange(int minimumValue, int maximumValue)
   {
      min = minimumValue;
      max = maximumValue;
   } // end setRange
   
   public void reset()
   {
      value = min;
      lastDecreaseRolledOver = false;
   } // end reset
   
	public void setValue(int wheelValue)
	{
		value = wheelValue;
	} // end setValue

   public int getValue()
   {
      return value;
   } // end getValue
   
	public void increaseValue()
	{
		if (value == max)
		{  // Roll over to minimum value
			lastIncreaseRolledOver = true;
			setValue(min);
		}
		else
		{
			lastIncreaseRolledOver = false;
			value++;
		}
	} // end increaseValue

	public void decreaseValue()
	{
      if (value == min)
      {
         lastDecreaseRolledOver = true;
         setValue(max);
      }
      else
      {
         lastDecreaseRolledOver = false;
         value--;
      }
	} // end decreaseValue

	public boolean hasRolledToMinimum()
	{
		return lastIncreaseRolledOver;
	} // end hasRolledToMinimum

   public boolean hasRolledToMaximum()
   {
      return lastDecreaseRolledOver;
   } // end hasRolledToMaximum

   public boolean isMinimum()
   {
      return value == min;
   } // end isMinimum

   public boolean isMaximum()
   {
      return value == max;
   } // end isMaximum

   public String toString()
   {
      return value + "";
   } // end toString
} // end Wheel
