//calculator class
package Energy;
import java.util.ArrayList;

public class Calculator {
	private double average;
	private double sum;
	private int number; 
	private EnergyHistory history;

public Calculator(EnergyHistory myHistory) {
	history = myHistory;
	sum = 0;
	number = 0;
	average = 0;
	getNums(myHistory);
	
}

private void getNums(EnergyHistory history) {
	ArrayList<Integer> num = history.getKwh();
	for(int i = 0; i < num.size(); i++){
		sum += num.get(i);
		number = i+1;	
	}
	average = sum / number;
}

public double getAverage() {
	return average;
}

}