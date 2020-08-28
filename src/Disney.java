/**
 * @(#)Disney.java
 *
 *
 * @author 
 * @version 1.00 2020/8/21
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Disney {
    
    static Scanner scan = new Scanner(System.in);
    static Scanner get = new Scanner(System.in);
    
    public static void main (String [] args) {
        //Person
        ArrayList<Person> person = new ArrayList<Person>();
        person.add(new Person(5001, "Ng", "Jing Chong", "010-282 6133", 19, 'M', "ngjingchong@gmail.com", "Jalan 14/155c", "Bukit Jalil", "Kuala Lumpur", 57000, "Malaysia"));
        person.add(new Person(7002, "Puah", "Hsien Jian", "012-345 6789", 21, 'M', "puahhj@gmail.com", "Jalan meru", "Cheras", "Kuala Lumpur", 58200, "Malaysia"));
        person.add(new Person(7001, "Low", "Jia Hie", "064-379 6769", 29, 'M', "lowjh@gmail.com", "Jalan malam", "bangi", "Selangor", 43000, "Malaysia"));
        person.add(new Person(3001, "Khor", "Wen Xin", "085-482 6547", 31, 'F', "khorwx@gmail.com", "Jalan forever", "Kepong", "Selangor", 53200, "Malaysia"));
        person.add(new Person(3002, "Tan", "Wen Ki", "017-280 2854", 27, 'F', "wen01@gmail.com", "Jalan Merdeka", "Kajang", "Selangor", 43000, "Malaysia"));
        
        //Product
        ArrayList<Product> prod = Product.getProdList();
        prod.add(new Product(1001, "Disney MagicBand", "Peripheral Product", 500, 15.00));
        prod.add(new Product(1002, "Mickey Mouse hat", "Peripheral Product", 1000, 10.0));
        prod.add(new Product(1003, "Ticket Disney World", "Ticket Material", 1500, 10.0));
        prod.add(new Product(1004, "Ticket Machine Cisco", "Ticket Mechine", 50, 5000.0));
        
        //Supplier
        ArrayList<Supplier> supplier = Supplier.getSupplier();
        //add Person[2] id=7002 to arraylist supplier
        supplier.add(new Supplier(person.get(2)));
        supplier.add(new Supplier(person.get(1)));
        
        //add product to supplier[0]&&supplier[1]
        supplier.get(0).getSuppProdList().add(prod.get(0));
        supplier.get(0).getSuppProdList().add(prod.get(1));
        supplier.get(1).getSuppProdList().add(prod.get(2));
        supplier.get(1).getSuppProdList().add(prod.get(3));
        
        //Staff
        ArrayList<Staff> staff= new ArrayList<Staff>();
	staff.add(new Staff(person.get(0), "Jc101255", 1234, "Admin", "has higher accessibility to every thing"));
        
        //Customer
        ArrayList<Customer> cust = new ArrayList<Customer>();
        cust.add(new Customer(person.get(3), "Premium", "Halloween", 83928102, 2, "07-09-2020 13:30:00" , 1, "Card", "123456789", 88.88));
        cust.add(new Customer(person.get(4), "Classic", "Christmas", 0, 4, "07-09-2020 15:40:00", 1, "Cash", "1294877789", 176.66));
        
        //Package
        ArrayList<Package> pk = new ArrayList<Package>();
        String [] arr1 = {"Scream Park","Water Park","X Park"};
        String [] arr2 = {"Scream Park","Water Park","X Park"};
        pk.add(new Package(9001, "Helloween", arr1, 130.00, 200.00, 180));
        pk.add(new Package(9002, "CNY", arr2, 150.00, 220.00, 190));
        
        
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
			    			staff = staff(staff);
			    			break;
			    		case 2:
			    			cust = customer(cust,pk);
			    			break;
			    		case 3:
			    			supplier(supplier);
			    			break;
			    		case 4:
			    			pk = packages(pk);
			    			break;
			    		case 5:
			    			quit = 0;
			    			break;
			    	}
	    		}while (choice != 5);
	    	}	
    	}while (quit != 0);
    	
    }
    
 
    
    public static ArrayList<Staff> staff(ArrayList<Staff> arr){
    	ArrayList<Staff> temp = arr;
    	int choice;
    	do{
	    System.out.println("1. Add new Staff");
            System.out.println("2. Edit Personal Details");
            System.out.println("3. Display Staff List");
            System.out.println("4. Return");
            System.out.println("5. Exit");
            System.out.print("Pick Your Action (1-4) > ");
	    choice = scan.nextInt();
            scan.nextLine();
            System.out.println();
            
	    switch(choice){
		case 1:
                    temp = Staff.addStaff(temp);
	            break;
	        case 2:
	            temp = Staff.editStaffInfo(temp);
	            break;
                case 3:
                    Staff.staffDisplay(temp);
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(1);
            }
    	}while (choice != 4);
        return temp;
    }
    public static ArrayList<Customer> customer(ArrayList<Customer> cust, ArrayList<Package> pk){
        
        ArrayList<Customer> tempCust = cust;
        ArrayList<Package> tempPk = pk;
        int choice;
        
    	do{
            System.out.println("\n1. Register new Customer");
            System.out.println("2. Edit Personal Details");
            System.out.println("3. Purchase Ticket");
            System.out.println("4. View Order Record");
            System.out.println("5. Display Customer List");
            System.out.println("6. Return");
            System.out.println("7. Exit");
            System.out.print("Pick Your Action (1-7) >  ");
            choice = scan.nextInt();

            switch(choice){
                case 1:
                    tempCust = Customer.addCustomer(tempCust);
                    break;
                case 2:
                    tempCust = Customer.editCustomer(tempCust);
                    break;
                case 3:
                    tempCust = Customer.buyTicket(tempCust, tempPk);
                    break;
                case 4:
                    System.out.print("Enter Customer ID > ");
                    int customerID = scan.nextInt();
                    Customer.displayOrder(customerID, tempCust);
                    break;
                case 5:
                    Customer.customerList(tempCust);
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(1);
            }
    	}while (choice != 6);
        return tempCust;
    }
    public static void supplier(ArrayList<Supplier> arr){
    	int choice;
        int suppID;
        boolean checkSupp =false;
        ArrayList<Supplier> supplier = arr;
        
    	do{
                System.out.println("\n-Supplier-");
                System.out.println("==============");
	    	System.out.println("1. Add New Suppplier");
	    	System.out.println("2. Add New Product");
                System.out.println("3. Edit Personal Details");
                System.out.println("4. Edit Product Details");
                System.out.println("5. Display Supplier List");
                System.out.println("6. Display Product List");
                System.out.println("7. Order note");
                System.out.println("8. Return");
                System.out.print("Pick Your Action (1-8) > ");
                choice = scan.nextInt();
		   	
		   	switch(choice){
		   		case 1://add supplier
		   			Supplier.addSupplier();
		   			break;
		   		case 2://Add product
                                        System.out.print("\nEnter your Supplier ID : ");
                                        suppID = scan.nextInt();
                                        
                                        for(int i=0; i<supplier.size(); i++){
                                            if(supplier.get(i).getID() == suppID){
                                               checkSupp = true;
                                               Supplier.addProduct(supplier.get(i));
                                               break;
                                            }else{
                                               checkSupp = false;
                                            }
                                        }
		   			if(!checkSupp){
                                            System.out.println("Invalid supplier !!!\n");
                                        }
		   			break;
		   		case 3://edit Supplier
		   			Supplier.editSupplier();
		   			break;
		   		case 4://edit Product
                                        System.out.print("\nEnter your Supplier ID : ");
                                        suppID = scan.nextInt();
                                        
                                        for(int i=0; i<supplier.size(); i++){
                                            if(supplier.get(i).getID() == suppID){
                                               checkSupp = true;
                                               Supplier.updateProduct(supplier.get(i));
                                               break;
                                            }else{
                                               checkSupp = false;
                                            }
                                            
                                        }
		   			if(!checkSupp){
                                            System.out.println("Invalid supplier !!!\n");
                                        }
                                        break;
                                case 5://display Supplier
                                        Supplier.suppList();
		   			break;
		   		case 6://display product that supply by one of the supplier
		   			Supplier.prodList();
                                        break;
                                case 7://total ordering details
                                        Supplier.summaryOrderNote();
		    		break;
		    	case 8:
		    		break;
		   	}
    	}while (choice != 8);
    }
    public static ArrayList<Package> packages(ArrayList<Package> pk){
        ArrayList<Package> temp = pk;
    	int choice;
    	do{
            System.out.println("1. Add New Package");
            System.out.println("2. Edit Package Details");
            System.out.println("3. Delete Package");
            System.out.println("4. Display Package List");
            System.out.println("5. Return");
            System.out.print("Pick Your Action (1-5) > ");
            choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    temp = Package.addPackage(temp);
                    break;
                case 2:
                    temp = Package.editPackage(temp);
                    break;
                case 3:
                    temp = Package.deletePackage(temp);
                    break;
                case 4:
                    Package.packageDisplay(temp);
                    break;
                case 5:
                    break;
            }
    	}while (choice != 5);
        return temp;
    }
 
  
   
    
}