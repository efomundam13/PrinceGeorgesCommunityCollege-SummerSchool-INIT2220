//
// Need to use a numeric value for the side of a square.
// Tell the compiler that T is derived from Number, the superclass of all of Java's numeric wrapper classes.
//

public class Square<T extends Number>
//
// Number : an upper bound on T
// Will get a syntax error, if we try to set up a square with a string-type side
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
   public double getArea() 
   { 
	double s = side.doubleValue(); //return value of side as a double value
	return s * s; 
   } // end getArea} 
}// end Square
