/**
   An interface for a class of wheels that can count, and
   whose counts rollover to a minimum value when increased
   from a maximum value, and rollover a maximum value when
   decreased from a minimum value.

   @author Charles Hoot,
   @author Frank M. Carrano 
   @version 5.0
*/
public interface WheelInterface
{
   /** Sets the minimum and maximum values that this wheel can attain.
       @param minimumValue  The smallest value of the wheel.
       @param maximumValue  The largest value of the wheel.
   */
   public void setRange(int minimumValue, int maximumValue);
   
   /** Resets this wheel's value to the minimum value. */
	public void reset();

   /** Sets the value of this wheel.
       @param wheelValue  The desired value of the wheel. */
   public void setValue(int wheelValue);

   /** Gets the value of this wheel.
       @return  The current value of the wheel. */
   public int getValue();
   
   /** Increases this wheel's value by one unit with rollover. */
   public void increaseValue();
   
   /** Decreases this wheel's value by one unit with rollover. */
   public void decreaseValue();
   
   /** Tests whether wheel's value became the minimum value during its last increase.
    @return  True if the last increase caused a rollover, or false if not. */
   public boolean hasRolledToMinimum();
   
   /** Tests whether wheel's value became the maximum value during its last decrease.
    @return  True if the last decrease caused a rollover, or false if not. */
   public boolean hasRolledToMaximum();
   
   /** Sees whether this wheel's value is minimum.
       @return  True if the value is the minimum value, false if not. */
   public boolean isMinimum();
   
   /** Sees whether this wheel's value is maximum.
    @return  True if the value is the maximum value, false if not. */
   public boolean isMaximum();
   
   /** Gets a string representation of this wheel's value.
       @return  A string form of the wheel's value. */
   public String toString();
} // end WheelInterface
