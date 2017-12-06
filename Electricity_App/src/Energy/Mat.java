package Energy;


public class Mat {
	
	private double KwH;
	
	private double price;
	
	private Material type;
	
	public enum Material {
		HALOGEN, INCANDESCENT, LED, CFL
	}
	
	
	public Mat(Material type, double KwH, double price) {
		this.KwH = KwH;
		this.type = type;
		this.price = price;
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
	
	
}