/**
An interface for methods that return
the perimeter and area of an object.
*/

interface Measurable {
	/** Returns the perimeter. */
	 public double getPerimeter ();
	 /** Returns the area. */
	 public double getArea ();
}

class Circle implements Measurable {
	private double radius;

	//Contructor
	public Circle(double radius) {
		this.radius = radius;
	}
	
	@Override
	//Returns the perimeter of a circle
	public double getPerimeter() {
		double perimeter = 2 * Math.PI * radius;
		return perimeter;
	}

	@Override
	//Returns the area of a circle
	public double getArea() {
		double area = Math.PI * radius * radius;
		return area;
	}
}

class Square implements Measurable {
	private double length;
	private double width;
	
	//Contructor
	public Square(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	@Override
	//Returns the perimeter of a square
	public double getPerimeter() {
		double perimeter = 2 * (length + width);
		return perimeter;
	}

	@Override
	//Returns the area of a square
	public double getArea() {
		double area = length * width;
		return area;
	}
}

//Main method
public class Shape {
	public static void main(String[] args) {
		Circle circle = new Circle(5);
		Square square = new Square(5,5);
		
		System.out.println("The area of the circle is " + circle.getArea());
		System.out.println("The perimeter of the circle is " + circle.getPerimeter());
		
		System.out.println("The area of the square is " + square.getArea());
		System.out.println("The perimeter of the square is " + square.getPerimeter());
	}
}
