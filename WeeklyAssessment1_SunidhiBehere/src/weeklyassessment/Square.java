package weeklyassessment;

//Class Square which extends the abstract class Shape and implements the interface Area
public class Square extends Shape implements Area{
	double side;
	
	//Square class parameterized constructor
	public Square(double side){
		super("Square",4);
		this.side=side;
	}
	
	//Overriding area method to return area of square
	@Override
	public double area() {
		return side*side;
	}
}
