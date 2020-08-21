/**
 * @(#)Disney.java
 *
 *
 * @author 
 * @version 1.00 2020/8/21
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Disney {
    
    static Scanner scan = new Scanner(System.in);
    static Scanner get = new Scanner(System.in);
    
    
    public static void main (String [] args) {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        
        ArrayList<Staff> staff= new ArrayList<Staff>();
        
        staff.add(new Staff(5001, "Ng", "Jing Chong", "010-282 6133", 19, 'M', "ngjingchong@gmail.com", "Jalan 14/155c", "Bukit Jalil", "Kuala Lumpur", 57000, "Malaysia", "Jc101255", 010207, "Admin", "has higher accessibility to every thing"));
        staff.add(new Staff(5002, "Puah", "Hsien Jian", "012-345 6789", 21, 'M', "puahhj@gmail.com", "Jalan meru", "Cheras", "Kuala Lumpur", 58200, "Malaysia", "Hj123456", 123456, "Cashier", "Collect money from customer"));

    	
    	
    	int staffId;
    	String password;
    	boolean grant = false;
    	int choice = 0;
    	int quit = 1;
    	do{
	    	System.out.printf("Enter Staff ID > ");
	    	staffId = scan.nextInt();
	    	
                System.out.printf("Enter Password > ");
	    	password = get.nextLine();
	    		
	    	for(Staff s : staff){
	    		if(s.getID() == staffId && s.getPassword().equals(password)){
	    			grant = true;
	    			break;
	    		}else {
	    			grant = false;
	    		}
	    	}
	    	
	    	if(!grant){
	    		System.out.println("Staff not exist !");
	    	}else{
	    		System.out.println("Welcome !");
	    		
	    		do{
		    		System.out.println("1. Staff");
			    	System.out.println("2. Customer");
			    	System.out.println("3. Supplier");
			    	System.out.println("4. Package");
			    	System.out.println("5. Exit");
			    	System.out.print("Pick Functional area to Perform Task (1-5) > ");
			    	choice = scan.nextInt();
			    	
			    	switch(choice){
			    		case 1:
			    			staff();
			    			break;
			    		case 2:
			    			customer();
			    			break;
			    		case 3:
			    			supplier();
			    			break;
			    		case 4:
			    			packages();
			    			break;
			    		case 5:
			    			quit = 0;
			    			break;
			    	}
	    		}while (choice != 5);
	    	}	
    	}while (quit != 0);
    	
    }
    
 
    
    public static void staff(){
    	int choice;
    	do{
	    	System.out.println("1. Add new Staff");
		   	System.out.println("2. Edit Personal Details");
		   	System.out.println("3. Display Staff List");
		   	System.out.println("4. Return");
		   	System.out.print("Pick Your Action (1-4) > ");
		   	choice = scan.nextInt();
		   	
		   	switch(choice){
		   		case 1:
		   			addStaff();
		   			break;
		   		case 2:
		   			editStaffInfo();
		   			break;
		   		case 3:
		   			staffDisplay();
		    		break;
		    	case 4:
		    		break;
		   	}
    	}while (choice != 4);
    }
    public static void customer(){
    	int choice;
    	do{
	    	System.out.println("1. Register new Customer");
		   	System.out.println("2. Edit Personal Details");
		   	System.out.println("3. Purchase Ticket");
		   	System.out.println("4. View Order Record");
		   	System.out.println("5. Return");
		   	System.out.print("Pick Your Action (1-5) > ");
		   	choice = scan.nextInt();
		   	
		   	switch(choice){
		   		case 1:
		   			addCustomer();
		   			break;
		   		case 2:
		   			editCustInfo();
		   			break;
		   		case 3:
		   			buyTicket();
		    		break;
		    	case 4:
		   			displayOrder();
		    		break;
		    	case 5:
		    		break;
		   	}
    	}while (choice != 5);
    }
    public static void supplier(){
    	int choice;
    	do{
	    	System.out.println("1. Add New Suppplier");
	    	System.out.println("2. Add New Product");
		   	System.out.println("3. Edit Personal Details");
		   	System.out.println("4. Edit Product Details");
		   	System.out.println("5. Display Supplier List");
		   	System.out.println("6. Display Product List");
		   	System.out.println("7. Restock Product");
		   	System.out.println("8. Return");
		   	System.out.print("Pick Your Action (1-8) > ");
		   	choice = scan.nextInt();
		   	
		   	switch(choice){
		   		case 1:
		   			addSupplier(supplierArr);
		   			break;
		   		case 2:
		   			addProduct();
		   			break;
		   		case 3:
		   			editSupplierInfo();
		   			break;
		   		case 4:
		   			EditProductInfo();
		    		break;
                                case 5:
		   			supplierDisplay();
		   			break;
		   		case 6:
		   			productDisplay();
		    		break;
                                case 7:
                                    restock();
		    		break;
		    	case 8:
		    		break;
		   	}
    	}while (choice != 8);
    }
    public static void packages(){
    	int choice;
    	do{
	    	System.out.println("1. Add New Package");
		   	System.out.println("2. Edit Package Details");
		   	System.out.println("3. Delete Package");
		   	System.out.println("4. Display Package List");
		   	System.out.println("5. Return");
		   	System.out.print("Pick Your Action (1-5) > ");
		   	choice = scan.nextInt();
		   	
		   	switch(choice){
		   		case 1:
		   			addPackage();
		   			break;
		   		case 2:
		   			editPackage();
		   			break;
		   		case 3:
		   			deletePackage();
		    		break;
		    	case 4:
		   			packageDisplay();
		    		break;
		    	case 5:
		    		break;
		   	}
    	}while (choice != 5);
    }
 
   
    
    
    public static Supplier [] addSupplier (Supplier [] arr){
       
        char ask;
        int suppCount =2 ;
        int suppIdCount=7003;
        Supplier [] tempArr = arr;
        
        System.out.print("Do you want to add supplier (Y/N) > ");
        ask = get.nextLine().charAt(0);

        if(ask == 'Y'){

            System.out.println("-Supplier Personal info-");
            System.out.println("=========================");
            System.out.println("Supplier ID : " + suppIdCount);
            System.out.print("Enter first name : ");
            String suppfName = get.nextLine();
            System.out.print("Enter last name : ");
            String supplName = get.nextLine();
            System.out.print("Enter phone number : ");
            String suppPhNum = get.nextLine();
            System.out.print("Enter age : ");
            int suppAge = scan.nextInt();
            System.out.print("Enter gender : ");
            char suppGender = get.nextLine().charAt(0);
            System.out.print("Enter email : ");
            String suppEmail = get.nextLine();

            System.out.println("-Supplier's Company Address-");
            System.out.println("=========================");  
            System.out.print("Enter street : ");
            String suppStreet = get.nextLine();
            System.out.print("Enter city : ");
            String suppCity = get.nextLine();
            System.out.print("Enter state : ");
            String suppState = get.nextLine();
            System.out.print("Enter posCode : ");
            int suppPosCode = scan.nextInt();
            System.out.print("Enter country : ");
            String suppCountry = get.nextLine();

            System.out.print("Comfirm to add ?(Y/N) >");
            ask = get.nextLine().charAt(0);

            if(ask == 'Y'){
                tempArr[suppCount] = new Supplier(suppIdCount,suppfName,supplName,suppPhNum,suppAge,suppGender,suppEmail,suppStreet,suppCity,suppState,suppPosCode,suppCountry);
                if(tempArr[suppCount] != null){
                        System.out.println("Supplier added !");
                        suppIdCount++;
                        suppCount++;
                        return tempArr;
                }else{
                      System.out.println("Failed to add!");
                        return tempArr;
                }
            }

        } 
        return tempArr;
    }
    

}