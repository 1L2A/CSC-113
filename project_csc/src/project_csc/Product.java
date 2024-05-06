package project_csc;


public abstract class Product {

	 
	protected double price;
	protected String productName;
	protected int quant;
	
	

	public Product ( double price , String productName ,int quant ) {
		
		this.price = price;  
		this.productName = productName;
		this.quant= quant; 
	}
	
	public Product(Product p) {
		price =p.price;
		productName=p.productName;
		quant=p.quant;
		
	}
	
	public abstract double calculatePrice() ;
	
	
	public String toString() {
		
		return ("Product Name: "+productName +"  -  Quantity: "+quant+"  -  Price: "+price+" SAR");
	}


	public double getPrice() {
	
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}



	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
	public int getQuant() {
		return quant;
	}


	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	
	

}
