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
	private ArrayList<Integer> myKwh;
	public double avgConsumption;
	
	/**
	 * @author Walter Hanson
	 */
	public EnergyHistory() {
		myMonths = new ArrayList<Integer>();
		myYears = new ArrayList<Integer>();
		myKwh = new ArrayList<Integer>();
		avgConsumption = 0;
	}
	
	/**
	 * @author Walter Hanson
	 * Method to add data to the ArrayLists.
	 * Precondition:A string containing the name of a month, an int representing a year in the 
	 * range 2000 through 2017, and an int representing energy used this month
	 * Postcondition:theMonth was added to myMonths, theYear added to myYears, and theKwh added to myKwh
	 */
	public void add(String theMonth, int theYear, int theKwh) {
		int monthNum = findMonthInt(theMonth);
		int repeat = checkList(monthNum, theYear);
		if(repeat >= 0) {
			myKwh.set(repeat, theKwh);
		}else {
			int idx = findLocation(monthNum, theYear);
			myMonths.add(idx, monthNum);
			myYears.add(idx, theYear);
			myKwh.add(idx, theKwh);
		}
		setChanged();
	    notifyObservers();
	}
	/**
	 * @author Walter Hanson
	 * Method to check if the month and year has already been added 
	 * Precondition: monthNum and theYear is the month and year to check if they been already added
	 * Postcondition: The idx of the month and year if already in the list or -1 if not in the list
	 */
	private int checkList(int monthNum, int theYear) {
		int idx = -1;
		int count = 0;
		for(int el: myYears) {
			if(el == theYear) {
				if(myMonths.get(count) == monthNum) {
					return count;
				}
			}
			count++;
		}
		return idx;
	}

	/**
	 * @author Walter Hanson
	 * Method to remove an element from the history
	 * Precondition: Idx is less than the size of the list
	 * Postcondition: Removes the element at the given idx from history
	 */
	public void delete(int theIdx) {
		myMonths.remove(theIdx);
		myYears.remove(theIdx);
		myKwh.remove(theIdx);
		setChanged();
	    notifyObservers();
	}

	/**
	 * @author Walter Hanson
	 * Method to get the Months list 
	 * Precondition: The list Months is instantiated
	 * Postcondition: Returns the Months list
	 */
	public ArrayList<Integer> getMonths() {
		return (ArrayList<Integer>) myMonths.clone();
	}
	
	/**
	 * @author Walter Hanson
	 * Method to get the Years list 
	 * Precondition: The list Years is instantiated
	 * Postcondition: Returns the Years list
	 */
	public ArrayList<Integer> getYears() {
		return (ArrayList<Integer>) myYears.clone();
	}
	
	/**
	 * @author Walter Hanson
	 * Method to get the kWh list 
	 * Precondition: The list kWh is instantiated
	 * Postcondition: Returns the kWh list
	 */
	public ArrayList<Integer> getKwh() {
		return (ArrayList<Integer>) myKwh.clone();
	}
	
	/**
	 * @author Walter Hanson
	 * Method to convert the string representation of a month to its int form. 
	 * Precondition: A String with the name of the month to convert
	 * Postcondition:The int representation of the String passed in
	 */
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
	
	/**
	 * @author Walter Hanson
	 * Method to find the location to place the month and year so it's in order 
	 * Precondition: monthNum and theYear is the month and year to order
	 * Postcondition: The idx to place the new month and year
	 */
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
