package project_csc;

public class Food extends Product {
	
	private double Kilogram;
	


		
		public Food(double  price  , String productName , int quant ,  double Kgrams ) {
			
		super(price , productName , quant);	
		Kilogram = Kgrams;
		
		}
		
		
		
		public Food (Food f) throws NegativQuantity {
			super(f.price , f.productName , f.quant);	
			Kilogram =f.Kilogram;	
		}
		
		
		public String toString() {
			return super.toString() +  "  -  Kilogram: " + Kilogram ;
		}
		
/*Calculate and return the price based on the kilograms, 
  if the Food have a kilograms -not equal zero- then 
  the method will calculate the price based on the kilograms,
  else-  kilograms equal zero-,it will calculate the price 
  based on the quantity.*/
		public double calculatePrice() {
			
			if(Kilogram == 0)
				 return  quant * price;
			else
				return Kilogram * price ;
		
		}
	
		public void setKilogram(double grams) {
			Kilogram = grams;
		}
		
		public double getKilogram() {
			return Kilogram;
		}
	}//end class
	
