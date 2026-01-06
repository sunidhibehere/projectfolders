package weeklyassessment;

public class Main{
	public static void main(String args[]) {
		
		//Creating objects of all the classes
		Rectangle rectangle = new Rectangle(4,4);
		Square square = new Square(5);
		Triangle triangle = new Triangle(13,6);
		Circle circle = new Circle(5.2);
		
		//Printing shape name using getName() method and number of sides using getNumOfSides()method
		//Along with Area of specific shape
		
 		System.out.println(rectangle.getName() + " has sides " + rectangle.getNumOfSides() + " | Area of Rectangle: " + rectangle.area());
		System.out.println(square.getName() + " has sides " + square.getNumOfSides() +" | Area of Square: " +  square.area());
		System.out.println(triangle.getName() + " has sides " + triangle.getNumOfSides()+" | Area of Triangle: " + triangle.area());
		System.out.println(circle.getName() + " has sides:" + circle.getNumOfSides()+ " | Area of Circle: " + circle.area());
		
		}
}