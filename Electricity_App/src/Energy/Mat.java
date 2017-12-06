package Energy;


public class Mat {
	
	private double KwH;
	
	private double price;
	
	private Material type;
	
	private double installCost;
	
	public enum Material {
		HALOGEN, INCANDESCENT, LED, CFL
	}
	
	
	public Mat(Material type, double KwH, double price, double installCost) {
		this.KwH = KwH;
		this.type = type;
		this.price = price;
		this.installCost = installCost;
	}
	
	public double getKwH() {
		return KwH;
	}
	
	public double getPrice() {
		return price;
	}
	
	public Material getMaterialType() {
		return type;
	}
	
	public double getInstallCost() {
		return installCost;
	}
	
	
}