import java.util.*;
/*
 * This is Iteration 0 of an Easter Egg. When triggered the Easter Egg
 * will present the user with information about the team.
 * 
 * User Stories:
 * As a user I want to see something interesting when I trigger an Easter Egg
 * As the product manager I want an Easter Egg that shows the team
 * As a developer I want to my name in the "We are . . . " Easter Egg
 * 
 * @authors Team Seattle
 * @version 0
 * @since 2017-10-19
 */
public class EasterEgg {
	/*
	 * This method intereacts with the user and then calls each
	 * team member's method to display information to the user.
	 * @param args grabs arguments from command line.
	 */
	public static void main(String[] args) {
		/*
		 * User interface
		 */
		Scanner s = new Scanner(System.in);
		String c;
		System.out.println("Press 'e' to activate easter egg");
		c = s.next();
		
		/*
		 *  Do not print "We are..." message until after user indicates to do so 
		 */
		while(!c.equals("e")) {
			System.out.println("Easter egg not activated.");
			System.out.println("Press 'e' to activate easter egg");
			c = s.next();
		}
		System.out.println("We are... TEAM SEATTLE!");
		walterMethod();
		brianMethod();
		dinoMethod(); 
		//Print information about team member Giovanna
		giovannaMethod();
		s.close();

	}
	/*
	 * This method prints out Walter's name and a fun fact about him when 
	 * easter egg has been triggered.
	 * @author Walter Hanson
	 */
	public static void walterMethod() {
		System.out.println("My name is Walter Hanson");
		System.out.println("I like the Seahawks and Mariners");
	}
	
	/*
	 * This methods prints out Brian's name and a random fun fact.
	 * @author Brian
	 * @return void - unused
	 */
	public static void brianMethod() {
		System.out.println("System Online.");
		System.out.println("Welcome back Brian Khang.");
		System.out.println("Loading Quote: I like watching pandas fly across the sky! Derp");
	}
	
	/*
	 * This method prints out Dino's name and a fun fact about him.
	 * @author Dino
	 * @return void - unused
	 */
	public static void dinoMethod() {
		System.out.println("My name is Dino Hadzic");
		System.out.println("I like cheese and playing Old School RuneScape");
	}
	
	/*
	 * This method prints out Giovanna's name and a fun fact about her.
	 * @author Giovanna
	 * @return void - unused
	 */
	public static void giovannaMethod() {
		System.out.println("I am Giovanna.");
		System.out.println("I like watching Game of Thrones, and sleeping (-.-)Zzz…");
		
	}
}
