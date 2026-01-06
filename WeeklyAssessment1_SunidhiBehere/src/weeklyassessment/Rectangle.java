package weeklyassessment;

//Class rectangle which extends the abstract class Shape and implements the interface Area
public class Rectangle extends Shape implements Area{
	double length;
	double breadth;
	
	//Rectangle class parameterized constructor
	public Rectangle(double length, double breadth){
		super("Rectangle",4);
			this.length = length;
			this.breadth = breadth; 
		}
		
	
	//Overriding area method to return area of rectangle
	@Override
	public double area(){
		return length*breadth;
	}
}
