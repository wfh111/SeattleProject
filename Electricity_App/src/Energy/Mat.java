package Energy;


/**
 * @author Dino Hadzic
 */
public class Mat {
	
	private double watts; // watts of bulb
	
	private double price; // price of bulb
	
	private double installCost; // installation cost
	
	private int amount; // number of bulbs 
	
	
	public Mat(double watts, double price, int amount) {
		this.watts = watts;
		this.price = price;
		this.amount = amount;
		this.installCost = price * amount;
	}
	
	public double getWatts() {
		return watts;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getInstallCost() {
		return installCost;
	}
	
	public int getAmount() {
		return amount;
	}
	
	
}