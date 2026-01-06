package example;


public class Gliders extends Bird implements Flyable{
	private boolean glide;
	public Gliders(String names, boolean glider) {
		super(names);
		glide=glider;
	}
	
	@Override
	public void fly() {
		System.out.println("Flying");
	}
	public boolean isGlider() {
		return glide;
	}

}
