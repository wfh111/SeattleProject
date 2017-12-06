package Energy;


public class Mat {
	
	private double KwH;
	
	private double price;
	
	private String type;
	
	
	public Mat(String type, double KwH, double price) {
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
	
	public String getMaterialType() {
		return type;
	}
	
	
}