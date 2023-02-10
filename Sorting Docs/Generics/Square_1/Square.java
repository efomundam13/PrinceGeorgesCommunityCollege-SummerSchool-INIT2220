//
// Class Square can receive any class type for its parameter?
//
//public class Square<T> implements Measurable
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
/**   public double getPerimeter()
   {
	return side * 4;
   }
   public double getArea()
   {
	return side * side;
   }
*/
} // end Square
