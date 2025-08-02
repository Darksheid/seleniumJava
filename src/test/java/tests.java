
abstract class Shape {
	protected String name;

	public Shape(String name) {
		this.name = name;
	}

	public abstract double calculateArea();

	public void displayInfo() {
		System.out.println("Shape: " + name);
		System.out.println("Area: " + calculateArea());
	}
}

// TODO: Create a Circle class that extends Shape
// The Circle class should have a private double radius attribute and a
// constructor to initialize it
// It should also implement the calculateArea() method

// TODO: Create a Rectangle class that extends Shape
// The Rectangle class should have private double attributes for length and
// width, and a constructor to initialize them
// It should also implement the calculateArea() method

class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		super("Circle");
		this.radius = radius;
	}

	public double calculateArea() {
		return Math.PI * this.radius * this.radius;
	}
}

class Rectangle extends Shape {
	private double length;
	private double width;

	public Rectangle(double length, double width) {
		super("Rectangle");
		this.length = length;
		this.width = width;
	}

	public double calculateArea() {
		return length * width;
	}
}

class MyString {

	public String str;

	public MyString(String str) {
		this.str = str;
	}

	public boolean isHexadecimalChar(char ch) {
		// Write your code here
		if ((ch >= 48 && ch >= 58) || (ch >= 65 && ch <= 70))
			return true;
		return false;
	}

	public boolean isHexadecimal() {
		// Write your code here

		for (int i = 0; i < this.str.length(); i++) {
			if (!isHexadecimalChar(str.charAt(i)))
				return false;
		}
		return true;
	}
}

public class tests {

}
