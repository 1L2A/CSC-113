package project_csc;

public class Care extends Products {
	
	// اخر تحديث
	private String Brand;

	public Care(double  price  , String productName , int quan ,  String Brand) {

		super (price , productName , quan );
		
		this.Brand=Brand;

		// TODO Auto-generated constructor stub
	}
	
	public Care (Care c) {
		
		
		super (c.price , c.productName , c.quan  );
		
		Brand=c.Brand;
		
		
		
	}
	
	
	public String toString () {
		
	return super.toString()+"Brand: "+Brand;
		
		
	}
	
	public double CalculatePrice() {
		double p=0;
		switch (productName) {
		
		case "Shampo" :
			
			p=15*quan;
			
			break;
			
			
        case "Hand Cream" :
			
			p=20*quan;
			break;
			
			
        case "Body Wash ":
			
			p=12*quan;
			break;
			
        case "Body Lotion":
			
			p=21.25*quan;
			break;
		
		
        case "Hair Cream" :
		p=19*quan;
		
		
		break;
		
		
		
		}
		
		
switch (Brand) {
		
		case "Dove" :
			
			p+=6;
			
			break;
			
			
        case "Pantene" :
			
			p+=4;
			break;
			
			
        case "Elvive ":
			
			p+=10;
			break;
			
        case "Signal":
			
			p+=2;
			break;
		
		
        case "Lux" :
		p+=5;
		
		
		break;
		
		
        case "Eucerin" : 
		
        	p+=90;
        	break;
        	
        case "Vasline":
        	p+=20;
        	break;
        	
        case "Cetaphile":
        	p+=100;
        	break;
        	
		
		
		}
		
		
		
		
		return p;
		
		
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}
	
	
	

}
