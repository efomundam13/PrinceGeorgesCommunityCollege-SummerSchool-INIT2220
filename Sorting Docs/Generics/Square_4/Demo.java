//
// Illustartes the need for bounded type parameters
//
public class Demo
{
       public static void main(String args[])
    {
	Square<Integer> intSquare = new Square<>(5);
	Square<Double> realSquare = new Square<>(2.1);

	System.out.println("Side of intSquare is " + intSquare.getSide());

 	System.out.println("Side of realSquare is " + realSquare.getSide());

 	System.out.println("Area of realSquare is " + realSquare.getArea());


    } // end main
} // end Example
