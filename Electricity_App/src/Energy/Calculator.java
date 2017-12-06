//calculator class
package Energy;
import java.util.ArrayList;

/**
 * This class computes the average kwh consumption based on the user's energy history
 * @author giovannagraciani
 *
 */
public class Calculator {
	private double average;
	private double sum;
	private int number; 
	private EnergyHistory history;

/**
 * @author giovannagraciani
 * Instantiate calculator
 */
public Calculator(EnergyHistory myHistory) {
	history = myHistory;
	sum = 0;
	number = 0;
	average = 0;
	getNums(myHistory);
	
}

/**
 * Calculate stuff
 * @author giovannagraciani
 */
private void getNums(EnergyHistory history) {
	ArrayList<Integer> num = history.getKwh();
	for(int i = 0; i < num.size(); i++){
		sum += num.get(i);
		number = i+1;	
	}
	average = sum / number;
}

/**
 * Return the average
 * @author giovannagraciani
 * @return average
 */
public double getAverage() {
	return average;
}

}