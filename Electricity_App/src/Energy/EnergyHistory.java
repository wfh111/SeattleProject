package Energy;
import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Walter Hanson
 * Class to keep track of User's energy history. 
 */
public class EnergyHistory extends Observable{
	private ArrayList<Integer> myMonths;
	private ArrayList<Integer> myYears;
	private ArrayList<Double> myKwh;
	public double avgConsumption;
	//comment
	
	public EnergyHistory() {
		myMonths = new ArrayList<Integer>();
		myYears = new ArrayList<Integer>();
		myKwh = new ArrayList<Double>();
		avgConsumption = 0;
	}
	
	public void add(String theMonth, int theYear, double theKwh) {
		int monthNum = findMonthInt(theMonth);
		int idx = findLocation(monthNum, theYear);
		myMonths.add(idx, monthNum);
		myYears.add(idx, theYear);
		myKwh.add(idx, theKwh);
		setChanged();
	    notifyObservers();
	}

	public void getAvgConsumption() {
		int sum = 0;
		for(int i=0; i <=myMonths.size(); i++) {
			sum+=myKwh.get(i);
		}
		avgConsumption = (sum / myMonths.size());
		System.out.println(avgConsumption);
		
	}
	public void delete(int theIdx) {
		myMonths.remove(theIdx);
		myYears.remove(theIdx);
		myKwh.remove(theIdx);
		setChanged();
	    notifyObservers();
	}
	
	public void edit(int theMonth, int theYear, double theKwh, int theIdx) {
		myMonths.set(theIdx, theMonth);
		myYears.set(theIdx, theYear);
		myKwh.set(theIdx, theKwh);
	}
	
	public ArrayList<Integer> getMonths() {
		return (ArrayList<Integer>) myMonths.clone();
	}
	
	public ArrayList<Integer> getYears() {
		return (ArrayList<Integer>) myYears.clone();
	}
	
	public ArrayList<Double> getKwh() {
		return (ArrayList<Double>) myKwh.clone();
	}
	
	public boolean isEmpty() {
		return myMonths.isEmpty();
	}
	
	private int findMonthInt(String theMonth) {
		int month = 1;
		switch (theMonth) {
        case "January":	
        		month = 1;
                 break;
        case "February":
        		month = 2;
                 break;
        case "March":  	
        		month = 3;
                 break;
        case "April":  	
        		month = 4;
                 break;
        case "May":  	
        		month = 5;
                 break;
        case "June":  	
        		month = 6;
                 break;
        case "July": 	
        		month = 7;
                 break;
        case "August":  
        		month = 8;
                 break;
        case "September":	
        		month = 9;
                 break;
        case "October":
        		 month = 10;
                 break;
        case "November":
        		 month = 11;
                 break;
        case "December":
        		 month = 12;
                 break;
		}
		return month;
	}
	
	private int findLocation(int theMonth, int theYear) {
		int idx = 0;
		for (int el: myYears) {
			if (theYear == el) {
				if (theMonth < myMonths.get(idx)) {
					return idx;
				}
				else {
					idx++;
				}
			}
			else if(theYear < el) {
				return idx;
			}
			else {
				idx++;
			}
		}
		return idx;
	}
}
