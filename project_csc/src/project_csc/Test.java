package project_csc;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Test {
  static TestGui mainFrame = new TestGui();
    
	public static void main(String[] args) {
            mainFrame.setVisible(true);
            
		
		Scanner input = new Scanner (System.in);
/*
		// List of our products in the market and prices.

		String [] Food = {"Red Onions","Cucumber","Potatoes","Carrot","Red Apples","Oranges","Alshalan Rice","15 Eggs","Entaj Chicken","Herfy Sliced Bread white","Almarai milk 1 liter","Pepsi 360 ml","XXL Pringles Original","KitKat two fingers","Nova Water 550 ml"};
		String [] Care = { "Body Lotion","Toothbrush","Toothpaste","Face Mask","Soft Rose hand soap","Hair Shampoo","Vaseline 100 ml","Black Lash Mascara","Hair comb","Cleaning Gel for face"};
		String [] brand = {"NIVEA","sensodyne ","Sensodyne","Neutrogena"," Lux ","PANTENE","Vaseline","Essence ","wet brush","Eucerin "};
		double [] PriceFood = {4.95, 3.95,3.95,4.95, 4.95,3.95, 99.95,15,18.85,6,4,2.7,19.25,1.75,1};
		double [] PriceCare = {14,28,12,13,9.13,28.24,10,11.80,40,54.27};
		
		market inv = new market (100);// giving a Operational value depends on the user how use the system. 
	System.out.println("** Welcome to our System **");
	int select=1 ;
	
	System.out.println("\nfor the FIRST time you MUST make new Invoice to be able to do the rest");
	System.out.println("*note that you can only add "+inv.getAllinvoices().length +" Invoices to the System");


	do { // do while for invoice 
		
		if(select<1 || select>5) 
			System.out.println("\nPlease enter vaild number from the list");
		
		boolean enter=true;
		while(enter) {
		try {
		System.out.println("\n\nWhat do you want to perform ? Choose the NUMBER from the list:");
		System.out.println("1- Make new Invoice");//for each time ,if that one be chosen then, Invoice obj will be created and the Market System will Start for the Current customer,also the list Of products will appear and the current customer can do a list of commands.  
		System.out.println("2- Search for Invoice");
		System.out.println("3- Delete Invoice ");
		System.out.println("4- Display All Invoices Information");
		System.out.println("5- End the program ");
		
		
		select= input.nextInt();
		enter=false;
		}
		catch(InputMismatchException i) {
			System.out.println("\n"+i.toString()+"   "+"The type of your input is wrong");
			 input.next();
		}
		}
	
	
				switch (select) { // switch for cases for invoice
				
				case 1 :
					
					System.out.println("\nPlease Enter the following:");
					
					System.out.println("The first name and last name for the customer:");
					String firstName = input.next();
					String lastName = input.next();
					
					String name = firstName +" " +lastName;
					
					
					
					System.out.println("The phone number:");
					String number = input.next();
					
					Invoice cus1 = new Invoice (name , number);
					
					
					
					System.out.println("\n\n************************ Market *****************************");
					System.out.println("          Welcome to The Market our Dear Customer ");
						
						
					System.out.println("\nWe have in the Market:");
					System.out.println("\nThe Food List: \n*note that selecting Vegetables and Fruit depends on Kilograms\n");
				          int i=0;
						while (i<Food.length ) {
							
							
							System.out.printf((i+1)+"- %-30s price: %.2f" +" SAR%n",Food[i] ,PriceFood [i]);	
							i++;
							}
						
						System.out.println("\nThe Care List: \n");
						 int j=0;
							while (j<Care.length ) {
								System.out.printf((j+1)+"- %-30s Brand: %-15s price: %.2f" +" SAR%n",Care[j] ,brand[j],PriceCare[j]);
									
								
								j++;
								}							
								
						
						int choice=1 ;
						System.out.println("*note that you can add only 100 products to your Basket");

						do {   // choice
							if(choice<1 || choice>7) 
								System.out.println("\nPlease enter vaild number from the list");
							

							boolean enter2=true;
							while(enter2) {
							try {
							System.out.println("\n\nWhat do you want to perform ? Choose the NUMBER from the list:");
							System.out.println("1- Add a product to my Basket");
							System.out.println("2- Remove a whole product from my Basket");
							System.out.println("3- Display the products");
							System.out.println("4- Display my Food products");
							System.out.println("5- Display my Care products");
							System.out.println("6- Display my Basket");
							System.out.println("7- End Shopping");
							
							
							choice= input.nextInt();
							enter2=false;
							}
							catch(InputMismatchException e) {
								System.out.println("\n"+e.toString()+"   "+"The type of your input is wrong");
								 input.next();
							}
							}
							
							switch(choice) {
							
							case 1:
								int check=0;
								System.out.println("Please Enter the product Name to add it: ");
								input.nextLine();
								
								while(check==0) {
								String pName= input.nextLine(); // product name
								double pGrams=0;                // grams of product
								int pQuant=0;                   // product quantity
								
								for(int r=0 ; r<6 ; r++) {  // loop from 0 to 6 because we have in list 6 product have kg.
									if(Food[r].equalsIgnoreCase(pName)) {
										boolean enter1=true;
										while(enter1) {
										try {
										System.out.println("Please Enter the Kilograms: ");
										pGrams=input.nextDouble();
										if(pGrams<=0)
											throw new NegativQuantity();
										enter1=false;
										}
										catch(NegativQuantity n) {System.out.println(n.toString());}
									}
										cus1.addProduct(new Food (PriceFood[r], Food[r], 1,pGrams));
										check++;
												break;
									}}//end if&for loop
								
								for(int r=6 ; r<Food.length ; r++) { // loop start from 6 because that display products without kg.
									if(Food[r].equalsIgnoreCase(pName)) {
										boolean enter1=true;
										while(enter1) {
										try {
										System.out.println("Please Enter the Quantity: ");
										pQuant=input.nextInt();
										if(pQuant<=0)
											throw new NegativQuantity();
										enter1=false;
										}
										catch(NegativQuantity n) {System.out.println(n.toString());}
										}

										cus1.addProduct(new Food (PriceFood[r], Food[r], pQuant,0));
										check++;
												break;
									}}//end if&for loop
								
								for(int r=0 ; r<Care.length ; r++) {
									if(Care[r].equalsIgnoreCase(pName)) {
										boolean enter1=true;
										while(enter1) {
										try {
										System.out.println("Please Enter the Quantity: ");
										pQuant=input.nextInt();
										if(pQuant<=0)
											throw new NegativQuantity();
										enter1=false;
										}
										catch(NegativQuantity n) {System.out.println(n.toString());}
										}

										
										cus1.addProduct(new Care (PriceCare[r], Care[r], pQuant,brand[r]));
										check++;
												break;
									}}//end for loop& if
							
							if(check==0) 
								System.out.println("Sorry, we couldn't find that product\nplease Re-Enter The product Name:");
								}//end while
							break;
							
							case 2 :
								
								System.out.println("Please Enter the product Name to remove it: ");
								input.nextLine();
								String pName= input.nextLine();
								cus1.removeProduct(pName);
								break;
								
							case 3 :
								System.out.println("The Food List: ");
								for(int r=0; r<Food.length ; r++) {
									System.out.printf((r+1)+"- %-30s price: %.2f" +" SAR%n",Food[r] ,PriceFood [r]);
									}
								
								System.out.println("----------------------------");
								
								System.out.println("The Care List: ");
								for(int r=0; r<Care.length ; r++) {
									System.out.printf((r+1)+"- %-30s Brand: %-15s price: %.2f" +" SAR%n",Care[r] ,brand[r],PriceCare[r]);
									}
								System.out.println("----------------------------");
								
								break;
								
							case 4:
								cus1.printBillF();
								break;
								
							case 5:
								cus1.printBillC();
								break;
							
							case 6:
								cus1.printBill();
								break;	
							}//end switch
								
						}while(choice!=7);
						
								if (cus1.getnumOfProd() != 0) // means the productBasket not empty
								{
						
						System.out.println("Fine, your Final Bill is: ");
						cus1.printBill();
						
						System.out.println("\nHow would you like to take your Order?:\n1-Face-to-Face in Market\n2-By delivery\nEnter The NUMBER");
						int cho=input.nextInt();  // Choice 
						
						switch(cho){
						case 1:
							
							System.out.println("How do you prefer to pay?:\n1-in the Market\n2-online payment\nEnter The NUMBER");
							if(input.nextInt()==2) {
								System.out.println("Okay, Enter the payment amount:");
								double payAmoun= input.nextDouble();
								while(cus1.calculateTotalBill()!=payAmoun) {// acting like a payment System ,the customer must pay -enter- the same amount that appear in the final Bill
									System.out.println("Error! , incorrect amount , please to Finish the payment you have to Enter the correct value as it appear in your Bill");
									payAmoun= input.nextDouble();
								}//end while loop	
							}//end if
							System.out.println("Gorgeous!, every thing is Good , your Basket waiting you\n\nthat's the information for the casher man:\nName;Mohamad Abdullah\nphone number:0538667789\nFinally we hope you enjoyed in our Market System .");
						
							break;
						
						case 2:
							System.out.println("Okay, your delivery Charge is 50SAR");
							System.out.println("Then, your total Bill is :"+ ( cus1.calculateTotalBill()+50 ) );
							System.out.println("Please you have to pay now, Enter the payment amount:");
							double payAmoun= input.nextDouble();
							while((cus1.calculateTotalBill()+50)!=payAmoun) {// acting like a payment System ,the customer must pay -enter- the same amount that appear in the final Bill
								System.out.println("Incorrect amount!, please to Finish the payment you have to Enter the correct value as it appear in your final Bill");
								payAmoun= input.nextDouble();
							}//end while loop	
							System.out.println("Gorgeous!, every thing is Good , your Delivery in the way to you\n\nthat's the information for the delivery man:\nName: Mohamad Abdullah\nphone number: 0538667789\nFinally we hope you enjoyed in our Market System .");

						break;
						
						}// end switch 
								}	// end if 
				
								inv.addInvoice(cus1);
						break;
					
					
				case 2:
					System.out.println("Please enter the phone number for the customer invoice that you search for it");
					number = input.next();
					
					
					if ( inv.searchForInvoice(number) != -1)
						inv.getAllinvoices()[inv.searchForInvoice(number)].printBill();
					else 
						System.out.println(	"There is no invoice for the entered phone number");
                         
					break;
					
				case 3:
					System.out.println("Please enter the phone number for the customer invoice that you to delete it");
					number = input.next();
					
					inv.deleteInvoice(number);
					
					break;
					
					
				case 4:
					
					inv.display();;
					
					break;
				case 5:
					
					System.out.println("Thank you to choose our System, have a good day");
					break;
				
					
				
				} // end switch cases of invoice
					
				}while(select!=5);// end do while for invoice
		
				
				
		*/		
	} // end main


	}// end class
