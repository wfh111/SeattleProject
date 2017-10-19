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
//		System.out.println("Hello World");
////tests
////Dab on walter
//		// SZECHUAN SAUCE MEME LORD DAB ON BRAIN!! v2!! - Dino
	}
	public static void walterMethod() {
		System.out.println("My name is Walter Hanson");
		System.out.println("I like the Seahawks and Mariners");
	}
}
