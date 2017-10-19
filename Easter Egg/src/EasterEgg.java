import java.util.*;
public class EasterEgg {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String c;
		System.out.println("Press 'e' to activate easter egg");
		c = s.next();
		while(!c.equals("e")) {
			System.out.println("Easter egg not activated.");
			System.out.println("Press 'e' to activate easter egg");
			c = s.next();
		}
		walterMethod();
		brianMethod();

	}
	public static void walterMethod() {
		System.out.println("My name is Walter Hanson");
		System.out.println("I like the Seahawks and Mariners");
	}
	public static void brianMethod() {
		System.out.println("System Online.");
		System.out.println("Welcome back Brian Khang.");
		System.out.println("Loading favorite game preferences and uncaging the panda and delivering sushi.");
	}
}
