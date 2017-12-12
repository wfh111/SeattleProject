package Energy;


/**
 * @author Dino Hadzic
 */
public class Mat {
	
	private double watts; // watts of bulb
	
	private double price; // price of bulb
	
	private double installCost; // installation cost
	
	private int amount; // number of bulbs 
	
	/**
	 * Material constructor.
	 * @author Dino Hadzic
	 * 
	 * @param watts
	 * @param price
	 * @param amount
	 */
	public Mat(double watts, double price, int amount) {
		this.watts = watts;
		this.price = price;
		this.amount = amount;
		this.installCost = price * amount;
	}
	
	/**
	 * Getter for watts.
	 * @author Dino Hadzic
	 * @return wattage.
	 */
	public double getWatts() {
		return watts;
	}
	
	/**
	 * Getter for price.
	 * @author Dino Hadzic
	 * @return price.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Getter for installation cost.
	 * @author Dino Hadzic
	 * @return installCost.
	 */
	public double getInstallCost() {
		return installCost;
	}
	
	/**
	 * Getter for amount of bulbs.
	 * @author Dino Hadzic
	 * @return amount.
	 */
	public int getAmount() {
		return amount;
	}
	
	
}