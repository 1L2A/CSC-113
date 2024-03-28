package project_csc;

import java.util.Scanner;

public class market {
	Scanner in = new Scanner(System.in);


	private Invoice[] Allinvoices;
	private int numOfInvoice ;
	
	public market(int size) {
		Allinvoices=new Invoice[size];
		numOfInvoice =0;
	}
	
	/* inserts and received Invoice to the first empty location in Allinvoices,
	   the method print a successful message if the Invoice add successfully,
	    or unsuccessful message otherwise.*/
	public void addInvoice(Invoice invoice) {
		
		if(numOfInvoice<Allinvoices.length) {
			Allinvoices[numOfInvoice++]=new Invoice(invoice);
			System.out.println("\nThe Invoice added successfully ");
			return;
			}
		System.out.println("Sorry,the list of Invoices full, you can't add more Invoice,");
		
	}
	
	
	//return the index of invoice in the Allinvoices ,if not found it return -1.
	public int searchForInvoice(String phone) {
		
		for(int i=0 ; i<numOfInvoice ;i++) {
			if(Allinvoices[i].getPhone().equals(phone))
			return 	i;
		}
		return -1;
	}
	
	/*delete the invoice with the specified phone number (replace the deleted one with 
	 the last element in the array), and validate whether the entered  phone number is 
	 found or not ,if not the user will be able to choose
	 either re-enter the phone number or not remove. */
	public void deleteInvoice(String phone) {
		

		if(searchForInvoice(phone)>=0)
		{
			if(searchForInvoice(phone)==(numOfInvoice-1)) {
				Allinvoices[--numOfInvoice]=null;
			System.out.println("Removed successfully ");}
			
			else {
				Allinvoices[searchForInvoice(phone)]=Allinvoices[numOfInvoice-1];
			Allinvoices[--numOfInvoice]=null;
			System.out.println("Removed successfully ");}
		}
		else { //else2
			System.out.println("Can't find the phone number ,\nDo you want to Re-remove the invoice? Yes or No");
		String answer = in.next();
		if(answer.equalsIgnoreCase("yes")) {
			in.nextLine();
			System.out.println("Enter the phone number that you want to remove"); 
			phone=in.next();
			deleteInvoice(phone);
			return;}
		
		else {System.out.println("Fine , the invoice Still in the store"); 
		return;}
		}//end else2
	}//end method
	
	//returns a string containing all information about store. 
	public void display() {
		
		System.out.println("\nThe Invoices Information:");
		
		for(int i= 0 ; i<numOfInvoice;i++) {
			System.out.print("\n-----------------------------------------------------------------------------------"+"\nInvoice "+(i+1));
			Allinvoices[i].printBill() ;
		}
	}//end display

	public int getNumOfInvoice() {
		return numOfInvoice;
	}

	public Invoice[] getAllinvoices() {
		return Allinvoices;
	}

	
	
	
	
}//end class Story