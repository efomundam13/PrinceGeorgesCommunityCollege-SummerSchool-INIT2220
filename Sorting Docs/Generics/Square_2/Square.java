//
// Class Square can receive any class type for its parameter?
//
public class Square<T>

{
   private T side;
   
   public Square(T initialSide)
   {
      side = initialSide;
   } // end constructor
   
   public T getSide()
   {
      return side;
   } // end getSide
   public void setSide(T Side)
   {
      side = Side;
   } // end setSide

//A call to getArea() causes a compiler error.
//Because T represents any class type, and all classes are derived from Object, 
//the compiler cannot tell whether side has the method doubleValue. 
//If side references a string, for example, it does not have this method.

   public double getArea() 
   { 
	double s = side.doubleValue(); //return value of side as a double value
	return s * s; 
   } // end getArea
} // end Square
