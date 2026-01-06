package weeklyassessment;

//abstract class Shape which implements the interface named Area
abstract class Shape implements Area{
	
	//Taking two attributes as Name and Number of Sides of Shape
	private String name;
	private int numOfSides;
	
	//Constructor Shape with two attributes as Name and Number of Sides of Shape
	public Shape(String name,int numOfSides) {
		this.name=name;
		this.numOfSides=numOfSides;
	}
	public String getName() {
		return name;
	}
	public int getNumOfSides() {
		return numOfSides;
	}
	
	//abstract method call so need for implementation
	//public abstract double area();
}
