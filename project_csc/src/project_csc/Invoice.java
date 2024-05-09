package project_csc;

import java.util.Scanner;
import java.io.*;

public class Invoice implements Serializable {
	Scanner in = new Scanner(System.in);
	
	
	private Product productList[] ;// acting as product Basket for the customer 
	private int numOfProd;
	private String custName;// Name of customer
	private String custPhone;// Phone of customer
	

	public Invoice(String name , String phone) {
		
		custName= name;
		custPhone=phone;
		productList = new Product [100];
		numOfProd=0;
	}

	public Invoice(Invoice v) {
		
	custName= v.custName;
	custPhone=v.custPhone;
		productList = new Product [100];
		numOfProd=v.numOfProd;
		for(int i=0; i<numOfProd ; i++)
			 productList[i]=v.productList[i];
	}

/*check if the product already exist in productList then the quantity Or the Kilograms will be updated 
 ,else inserts and received Product p to the first empty location in productList, 
	the method print a successful message if the product add successfully, 
	or unsuccessful message otherwise.*/
	public void addProduct(Product p) {
		
		int indexOfProduct=searchProduct(p.getProductName());
		
			if(indexOfProduct>=0) {//if1
				if((p instanceof Food && ((Food)p).getKilogram()==0)|| (p instanceof Care))
				productList[indexOfProduct].setQuant(p.getQuant()+productList[indexOfProduct].getQuant());
				else
					((Food)productList[indexOfProduct]).setKilogram(((Food)p).getKilogram()+((Food)productList[indexOfProduct]).getKilogram());
				System.out.println("add successfully to your Basket");
				return ;
			}
			
			else if(productList.length >numOfProd) {//else1
				
				if(p instanceof Food ) {
					productList[numOfProd++]= (Food)p;
					System.out.println("add successfully to your Basket");
					return ;
				}
				else
					productList[numOfProd++]= (Care)p;
					System.out.println("add successfully to your Basket");
					return ;
				
			}//end else1
				
			System.out.println("Sorry, your Basket is full you can't add");

		
	}//end method
	
	
	/*delete the product with the specified name (replace the deleted one with the last element in the array)
	 , and validate whether the entered name is found or not ,if not, the user will be able to choose either 
	 re-enter the name or not remove. 
	 */
	public void removeProduct(String name) {
		
		if(searchProduct(name)>=0) {// if1
			
			if(searchProduct(name) == (numOfProd-1)) {
				productList[--numOfProd]=null;
				System.out.println("Removed successfully from your Basket");}
			
			else{
			productList[searchProduct(name)]=productList[numOfProd-1];
			productList[--numOfProd]=null; 
			System.out.println("Removed successfully from your Basket");} 
			}//end if1
		else {//else2
		
			System.out.println("Can't find the name of product in your Basket,\nDo you want to Re-remove the Product? Yes or No");
			String answer = in.next();
			if(answer.equalsIgnoreCase("yes")) {
				in.nextLine();
				System.out.println("Enter the name of the product that you want to remove"); 
				name=in.nextLine();
				removeProduct(name);
				return;}
			else {System.out.println("Fine , the product Still in your Basket"); 
			return;}
			
		}//end else2
}//end method 
	
		
		
	
	/*returns the index of the product having the specified name, 
	 if the product not found it will return -1.
	 */

	public int searchProduct(String name) {
		
		for(int i = 0 ; i< numOfProd ; i++)
			if(productList[i].getProductName().equalsIgnoreCase(name))
				return i ; 
		
		return -1;
		
	}
	
	
	
	/*print the bill of Food objects in productList.*/
	public String printBillF() {
		
		
		String str1=("\n______________________________")+"\nprint Bill Food";
		int numOfFood=0;
		for(int i=0 ; i<numOfProd ; i++ )
			if(productList[i] instanceof Food  )
				numOfFood++;
		
		if(numOfFood == 0) {
			str1=str1+("\nThere is NO Food product");
		return str1;}
		
		str1=("\n______________________________");

		str1=str1+("\nThe Food Products Bill: ");
		
		double sumOfFood=0;
		for(int i=0 ; i<numOfProd ; i++ )
			if(productList[i] instanceof Food  ) {
				str1= str1+"\n"+(productList[i].toString())+"\n";
				
				sumOfFood+=productList[i].calculatePrice();
			}
		str1=str1+"\n"+("\nThe Total Food Products price: "+sumOfFood+" SAR");
                return str1;
	}//end method
	
	/*print the bill of Care objects in productList.*/
	public String printBillC() {
		
		String str2=("\n______________________________")+"\nprint Bill Care";
		int numOfCare =0 ;
		for(int i=0 ; i<numOfProd ; i++ )
			if(productList[i] instanceof Care )
				numOfCare++;
		
		if(numOfCare == 0) {
			str2=str2+("\nThere is NO Care products");
		return str2;}
		
		str2=("\n______________________________");

		str2=str2+("\nThe Care Products Bill: ");
		double sumOfCare=0;
		
		for(int i=0 ; i<numOfProd ; i++ )
			if(productList[i] instanceof Care  ) {
				str2= str2+"\n"+(productList[i].toString()+"\n");
				 sumOfCare+=productList[i].calculatePrice();
			}
		str2=str2+"\n"+("\nThe Total Care Products price: "+ sumOfCare+" SAR");
		return str2;
	}
	
	/*print the bill include the bill of Food and Care with 
	 the total price of Food and Care in productList .*/
	public String printBill() {
		
		String str3 = "\n______________________________" ;
		str3 =str3+ "\nThe Information of The Customer: ";
		str3=str3+"\nName: " + custName + "  -  Phone: " + custPhone ;
		
		
		str3=str3+ "\n\n\n"+printBillF();
		str3=str3+ "\n\n\n"+printBillC();
		
		double sumOfProducts=0;
		
		for(int i=0 ; i<numOfProd ; i++ )
		sumOfProducts+=productList[i].calculatePrice();
			
		
		str3=str3+("\n______________________________")+("\n\nThe Total Products price: "+ sumOfProducts+" SAR");
		
                return str3;
	}
	
	/*to calculate and return the sum of all product prices in productList.*/
	public double calculateTotalBill() {
		
		double sumOfProducts=0;
		
		for(int i=0 ; i<numOfProd ; i++ )
		sumOfProducts+=productList[i].calculatePrice();
		
		return sumOfProducts;
		
		
	}
	
	public int getnumOfProd() {
		return numOfProd ;
	}

	public String getPhone() {
		return custPhone;
}
        
     
        
        
}//end class
