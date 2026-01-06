package carengine;

public class Car {
	private Engine engine;
	
	public Car() {
		//default constructor needed for byName/byType
	}
	
	public Car(Engine engine) {
		this.engine=engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void showCarDetails() {
		System.out.println("Car has engine type:" + engine.getType());
	}
}
