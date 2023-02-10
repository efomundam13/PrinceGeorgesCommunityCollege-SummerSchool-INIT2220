/**
   An interface for a general wheel counter having a given number of wheels.
   Wheels in the counter are numbered from 1 and from right to left.

   @author Charles Hoot
   @author Frank M. Carrano
   @version 5.2
 */
public interface WheelCounterInterface
{
   /** Sets the number of wheels in this wheel counter.
       @param  number  The integer number of wheels. */
   public void setNumberOfWheels(int number);

   /** Gets the number of wheels in this wheel counter.
       @return  The integer number of wheels. */
   public int getNumberOfWheels();
   
   /** Sets all of the wheels to the minimum value. */
	public void reset();

	/** Increases the value of this wheel counter by one unit, cascading to the other counters as needed. */
	public void increaseCount();

   /** Decreases the value of this wheel counter by one unit, cascading to the other counters as needed. */
   public void decreaseCount();

   /** Gets the value of a wheel given its number beginning with 1.
		 @return  The value of a given wheel. */
	public int getWheelValue(int theWheel);
} // end WheelCounterInterface
