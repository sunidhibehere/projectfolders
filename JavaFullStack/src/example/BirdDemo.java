package example;

public class BirdDemo {
	public static void main(String args[]) {
		Eagle eagle = new Eagle("BirdEagle",true);
		eagle.fly();
		System.out.println("Is eagle a glider " +eagle.isGlider());
		
		Hawk hawk = new Hawk("Hawk", false);
		hawk.fly();
		System.out.println("Is Hawk a glider " +hawk.isGlider());
	}
}
