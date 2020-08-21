/**
 * @(#)Supplier.java
 *
 *
 * @author 
 * @version 1.00 2020/8/8
 */

import java.util.Date;
import java.util.Scanner;

public class Supplier extends Personal_info{
    private Product [] p = new Product[75];
    private static int count = 0;
    private Date joinDate;

    
    public Supplier(int id, String fName, String lName, String phNum,int age, char gender, String email, String street, String city, String state, int posCode, String country) {
        super( id, fName, lName, phNum, age, gender, email,street, city, state, posCode, country);
        this.joinDate = new Date();
    }


    public Date getJoinDate() {
        return joinDate;
    }
    
    
    public boolean addProduct(){
        Scanner scan = new Scanner(System.in);
        
        //prompt and read
        System.out.print("Enter product id > ");
        int id = scan.nextInt();  
        System.out.print("Enter product name > ");
        String name = scan.nextLine();
        System.out.print("Enter product description > ");
        String description = scan.nextLine();
        System.out.print("Enter product quantity > ");
        int qty = scan.nextInt();
        System.out.print("Enter product price > ");
        double price = scan.nextDouble();
        
        p[count] = new Product(id,name,description,qty,price);
        if(p[count]!= null){
        	System.out.println("1 Product added !");
        	count++;
        	return true;
        }else {
        	System.out.println("No Product added !");
        	return false;
        }
    } 
    public boolean deleteProduct(){
        Scanner scan = new Scanner(System.in);
        boolean isDelete = false;
        int deleteID = 0;
        
        //prompt and read
        System.out.print("Enter product id > ");
        int id = scan.nextInt();  
        	
        for(int i=0;i<p.length;i++){
        	if (p[i].getId() == id){
        		deleteID=i;
        		System.out.println("Product ID > " + p[i].getId());
        		System.out.println("Product name > " + p[i].getName());
        		System.out.println("Product description > " + p[i].getDescription());
        		System.out.println("Product quantity > " + p[i].getQuantity());
        		System.out.println("Product total quantity purchased > " + p[i].getTotalQtyPurchased());
        		System.out.println("Price per unit > " + p[i].getPrice());
        		
        		System.out.print("Confirm Deletion ? (Y=yes & N=no)");
        		char delete = scan.next().charAt(0);  
        			if(Character.toUpperCase(delete) == 'Y'){
        				for (int l=i; l<p.length; l++){
			        		p[l] = p[l-1];
			        		isDelete = true;
			        	}
	        		}else {
	        			isDelete = false;
	        		}
	        	break;
        	}else {
        		isDelete = false;
        	}
        }
        if (isDelete == true){
        	System.out.println("Product : " + p[deleteID].getId() + " is deleted !");
        	return true;
        }else {
        	System.out.println("No record is deleted !");
        	return false;
        }
    } 
    public boolean updateProduct(int product_id){
        Scanner scan = new Scanner(System.in);
    	int updateID=0;
    	boolean isUpdate = false;
    	
    	for(int i=0;i<p.length;i++){
        	if (p[i].getId() == product_id){
        		updateID=i;
        		System.out.println("Initial Product Details");
        		System.out.println("=======================");
        		System.out.println("Product ID > " + p[i].getId());
        		System.out.println("Product name > " + p[i].getName());
        		System.out.println("Product description > " + p[i].getDescription());
        		System.out.println("Product quantity > 0");
        		System.out.println("Product total quantity purchased > " + p[i].getTotalQtyPurchased());
        		System.out.println("Price per unit > " + p[i].getPrice());
        		
        		System.out.print("Enter product id > ");
      	 		int id = scan.nextInt();  
        		System.out.print("Enter product name > ");
        		String name = scan.nextLine();
        		System.out.print("Enter product description > ");
        		String description = scan.nextLine();
        		System.out.print("Product quantity > ");
        		int qty = scan.nextInt();
        		System.out.print("Total Product purchased quantity > " + p[i].getTotalQtyPurchased());
        		System.out.print("Enter product price > ");
        		double price = scan.nextDouble();
        		
        		System.out.println("Latest Product Details");
        		System.out.println("=======================");
        		System.out.println("Product ID > " + p[i].getId());
        		System.out.println("Product name > " + p[i].getName());
        		System.out.println("Product description > " + p[i].getDescription());
        		System.out.println("Product quantity > " + p[i].getQuantity());
        		System.out.println("Product total quantity purchased > " + p[i].getTotalQtyPurchased());
        		System.out.println("Price per unit > " + p[i].getPrice());
        		
        		System.out.print("Update Product Details to Latest Version ? (Y=yes & N=no)");
        		char update = scan.next().charAt(0);  
        			if(Character.toUpperCase(update) == 'Y'){
        				for (int l=i; l<p.length; l++){
			        		p[i].setId(id);
			        		p[i].setName(name);
			        		p[i].setDescription(description);
			        		p[i].setQuantity(qty);
			        		p[i].setPrice(price);
			        		isUpdate = true;
			        	}
	        		}else {
	        			isUpdate = false;
	        		}
	        	break;
        	}else {
        		isUpdate = false;
        	}
        }
        if (isUpdate == true){
        	System.out.println("Product : " + p[updateID].getId() + " is Updated !");
        	return true;
        }else {
        	System.out.println("No record is updated !");
        	return false;
        }
    }
    public void totalSales(int id){
    	double subtotal = 0;
    	int count = 0;
    	if(id == 0){ //calculate subtotal of all product
    		for(int i=0; i<p.length; i++){
    			subtotal += p[i].subtotal();
    			count = i;
    		}
    		System.out.println("RM " + subtotal + " of Sales for " + ++count + " Product(s)");
    	}else { //calculate subtotal of particular product_id
    		for(int i=0; i<p.length; i++) {
    			if (p[i].getId() == id){
    				subtotal = p[i].subtotal();
    				System.out.println("RM " + subtotal + " of Sales for Product(s) > " + id);
    				break;	
    			}
    		}
    	}
    }
    public void productList(){
    	System.out.printf("%8d %20s %30s %3d %6d %6.2lf %4d","Prod_ID", "Name", "Description", "Quantity", "Total Qty Purchased", "Price", "No");
    	
    	for (int i=0; i<p.length; i++){
    		if(p[i] != null){
    			p[i].displayDetails();
    		}
    	}
    }

    
    
    public String toString() {
        
        return  super.toString() +   
                "Join Date : " + joinDate + "\n";
    }
    
    

    
    
   
}