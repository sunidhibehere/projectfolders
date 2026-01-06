package collections;
import java.util.ArrayList;

public class ShoppingList {
	public static void main(String args[]) {
		ArrayList<Integer> ar = new ArrayList<>();
		ar.add(20);
		ar.add(21);
		ar.add(14);
		for(int i:ar) {
			System.out.println(i);
		}
		System.out.println(ar.get(0));
	}
}
