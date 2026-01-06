package weeklyassessment;

//Class Circle which extends the abstract class Shape and implements the interface Area
public class Circle extends Shape implements Area{
	double radius;
	double pi = 3.142;
	
	//Circle class parameterized constructor
	public Circle(double radius) {
		super("Circle",0);
		this.radius = radius;
	}
	
	//Overriding area method to return area of circle
	@Override
	public double area() {
		return pi*radius*radius;
	}
}
