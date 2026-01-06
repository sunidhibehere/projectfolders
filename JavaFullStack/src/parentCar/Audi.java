package parentCar;

public class Audi implements Vehicle{
	int speed=0;
	int gear=1;
	
	public void applyBreak(int decrement) {
		speed = speed - decrement;
	}
	public void changeGear(int value) {
		gear=value;
	}
	public void speedUp(int increment) {
		speed = speed+increment;
	}
	
	void printStates() {
		System.out.println("Speed: "+ speed + " Gear: "+ gear);
	}
	
	public static void main(String args[]) {
		Audi a1 = new Audi();
		a1.speedUp(50);
		a1.changeGear(4);
		a1.printStates();
		a1.changeGear(5);
		a1.speedUp(60);
		a1.printStates();
	}
}
