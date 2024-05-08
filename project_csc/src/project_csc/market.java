package project_csc;

import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;



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
	public boolean addInvoice(Invoice invoice) {
		
		if(numOfInvoice<Allinvoices.length) {
			Allinvoices[numOfInvoice++]=new Invoice(invoice);
			return true;
			}
return false;		
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
	public boolean deleteInvoice(String phone) {
		

		if(searchForInvoice(phone)>=0)
		{
			if(searchForInvoice(phone)==(numOfInvoice-1)) {
				Allinvoices[--numOfInvoice]=null;
                         return true ;}			
			else {
				Allinvoices[searchForInvoice(phone)]=Allinvoices[numOfInvoice-1];
			Allinvoices[--numOfInvoice]=null;
			return true;}
		}
		else  //else2
		return false;			

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

	public boolean saveMarket(String fName) {
     
        try{ 
     File f = new File (fName);
     FileOutputStream out = new FileOutputStream (f);
     ObjectOutputStream fiObj= new ObjectOutputStream(out);
     
     fiObj.writeInt(numOfInvoice);
     
     for(int i =0 ; i<numOfInvoice ; i++)
         fiObj.writeObject(Allinvoices[i]);
     
     fiObj.close();
        }
        catch (IOException e ) {
             JOptionPane.showMessageDialog(null,"Somthing wrong, try agin");
             return false;
    	 }
     return true;
   
     }  
     
     
     public boolean uploadMarket(String fName) {
      
    	 try {
    		 File f = new File (fName);
    		 FileInputStream in = new FileInputStream (f);
    		 ObjectInputStream fobj= new ObjectInputStream(in);
    		 
    		 
    		 int size = fobj.readInt();
    
    		 for (int i =0 ; i<size ; i++) {
    			 
    			Invoice obj = (Invoice ) fobj.readObject() ;
    			this.addInvoice(obj); 
    		 }
    		 
    		 fobj.close();
    		 
    	 }catch(ClassNotFoundException e) {
             JOptionPane.showMessageDialog(null,"Somthing wrong, try agin");
             return false;
    		 
    	 }catch (IOException e ) {
    		 JOptionPane.showMessageDialog(null,"Somthing wrong, try agin");
             return false;  
    	 } 
        
         return true;
     }      
	
	
	
}//end class Story
