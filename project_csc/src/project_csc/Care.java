package project_csc;

public class Care extends Product  {
	
	private String Brand;

	public Care(double  price  , String productName , int quant ,  String Brand) {

		super (price , productName , quant );
		
		this.Brand=Brand;

	}
	
	
	public Care (Care c) {
		
		super (c.price , c.productName , c.quant );
		
		Brand=c.Brand;
		
	}
	
	
	public String toString () {
		
	return super.toString()+"  -  Brand: "+Brand;
		
		
	}
	//Calculate and return the Price based on quantity.
	public double calculatePrice() {
		double total = price*quant;

	return 	total;
		
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}


	
	
	

}
