package weeklyassessment;

//Class Triangle which extends the abstract class Shape and implements the interface Area
public class Triangle extends Shape implements Area{
	double base;
	double height;
	
	//Triangle class parameterized constructor
	public Triangle(double base, double height) {
		super("Triangle",3);
		this.base = base;
		this.height = height;
	}
	
	//Overriding area method to return area of triangle
	@Override
	public double area() {
		return 0.5*base*height;
	}
}
