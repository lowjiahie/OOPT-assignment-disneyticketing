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
import java.util.Calendar;
import java.util.Date;
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
       cust.add(new Customer(person.get(4), "Classic", "Christmas", 45263662, 4, "07-09-2020 15:40:00", 1, "Cash", "NULL", 176.66));
        //Package
        ArrayList<Package> pk = new ArrayList<Package>();
        String [] arr1 = {"Scream Park","Water Park","X Park"};
        String [] arr2 = {"Scream Park","Water Park"};
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
			    	scan.nextLine();
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
    
 
    
    public static Person addPerson(int ID){
        int id = ID;
        String fName;
    	String lName;
    	String phNum;
    	int age = -1;
    	char gender;
    	String email;
    	String street;
    	String city;
    	String state;
    	int posCode;
    	String country;
        
        System.out.println("Personal Info");
    	System.out.println("=============");
    	System.out.printf("Enter first name > ");
    	fName = scan.nextLine();
    	System.out.printf("Enter last name > ");
    	lName = scan.nextLine();
    	System.out.printf("Enter Contact Number > ");
    	phNum = scan.nextLine();
        //pass age to validation
        age = Validation.read_int(get,"Enter Age > ");
        //pass gender to do validation
    	gender = Validation.validateGender(scan,"Enter Gender > ");
    	System.out.printf("Enter Your Email > ");
    	email = scan.nextLine();
    	
    	System.out.printf("\nAddress\n");
    	System.out.println("=======");
    	System.out.printf("Enter Street > ");
    	street = scan.nextLine();
    	System.out.printf("Enter City > ");
    	city = scan.nextLine();
    	System.out.printf("Enter State > ");
    	state = scan.nextLine();
    	posCode = Validation.read_int(get,"Enter Poscode > ");
    	System.out.printf("Enter Country > ");
    	country = scan.nextLine();
        
        Person temp = new Person(id, fName, lName, phNum, age, gender, email, street, city, state, posCode, country);
        
        return temp;
    }
    public static Person editPersonalInfo(Person p){
        Person temp = p;
        int choice;
        
        do{
            System.out.println("1. First Name");
            System.out.println("2. Last Name");
            System.out.println("3. Phone Number");
            System.out.println("4. Age");
            System.out.println("5. Gender");
            System.out.println("6. Email");
            System.out.println("7. Return");
            System.out.print("Select Field to Edit (1-7) > ");
            choice = get.nextInt();
            get.nextLine();
            System.out.println();
            
            String ans1;
            int ans2;
            char ans3;
            char confirmation;
            
            switch(choice){
                case 1:
                    System.out.printf("Enter first name > ");
                    ans1 = scan.nextLine();
                    
                    System.out.println("From " + temp.getfName() + " Change to " + ans1);
                    System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                    confirmation = scan.next().charAt(0);
                    scan.nextLine();
                    System.out.println();
                    
                    if(Character.toUpperCase(confirmation) == 'Y' ){
                        temp.setfName(ans1);
                    }
                    break;
                case 2:
                    System.out.printf("Enter last name > ");
                    ans1 = scan.nextLine();
                    
                    System.out.println("From " + temp.getlName() + " Change to " + ans1);
                    System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                    confirmation = scan.next().charAt(0);
                    scan.nextLine();
                    System.out.println();
                    
                    if(Character.toUpperCase(confirmation) == 'Y' ){
                        temp.setlName(ans1);
                    }
                    break;
                case 3:
                    System.out.printf("Enter Contact Number > ");
                    ans1 = scan.nextLine();
                    
                    System.out.println("From " + temp.getPhNum() + " Change to " + ans1);
                    System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                    confirmation = scan.next().charAt(0);
                    scan.nextLine();
                    System.out.println();
                    
                    if(Character.toUpperCase(confirmation) == 'Y' ){
                        temp.setPhNum(ans1);
                    }
                    break;
                case 4:
                    ans2 = Validation.read_int(get,"Enter Age > ");
                    
                    System.out.println("From " + temp.getAge() + " Change to " + ans2);
                    System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                    confirmation = scan.next().charAt(0);
                    scan.nextLine();
                    System.out.println();
                    
                    if(Character.toUpperCase(confirmation) == 'Y' ){
                        temp.setAge(ans2);
                    }
                    break;
                case 5:
                    ans3 = Validation.validateGender(scan,"Enter Gender > ");
                    
                    System.out.println("From " + temp.getGender() + " Change to " + ans3);
                    System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                    confirmation = scan.next().charAt(0);
                    scan.nextLine();
                    System.out.println();
                    
                    if(Character.toUpperCase(confirmation) == 'Y' ){
                        temp.setGender(ans3);
                    }
                    break;
                case 6:
                    System.out.printf("Enter Your Email > ");
                    ans1 = scan.nextLine();
                    
                    System.out.println("From " + temp.getEmail() + " Change to " + ans1);
                    System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                    confirmation = scan.next().charAt(0);
                    scan.nextLine();
                    System.out.println();
                    
                    if(Character.toUpperCase(confirmation) == 'Y' ){
                        temp.setEmail(ans1);
                    }
                    break;
                case 7:
                    break;
            }
	}while (choice != 7);
        return temp;
    }
    public static Person editAddress(Person p){
        Person temp = p;
        int choice;
        
        do{
            System.out.println("1. Street");
            System.out.println("2. City");
            System.out.println("3. State");
            System.out.println("4. Poscode");
            System.out.println("5. Country");
            System.out.println("6. Return");
            System.out.print("Select Field to Edit (1-6) > ");
            choice = get.nextInt();
            get.nextLine();
            System.out.println();
            
            String ans1;
            int ans2;
            char confirmation;
            
            switch(choice){
                case 1:
                    System.out.printf("Enter Street > ");
                    ans1 = scan.nextLine();
                    
                    System.out.println("From " + temp.getStreet() + " Change to " + ans1);
                    System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                    confirmation = scan.next().charAt(0);
                    scan.nextLine();
                    System.out.println();
                    
                    if(Character.toUpperCase(confirmation) == 'Y' ){
                        temp.setStreet(ans1);
                    }
                    break;
                case 2:
                    System.out.printf("Enter City > ");
                    ans1 = scan.nextLine();
                    
                    System.out.println("From " + temp.getCity() + " Change to " + ans1);
                    System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                    confirmation = scan.next().charAt(0);
                    scan.nextLine();
                    System.out.println();
                    
                    if(Character.toUpperCase(confirmation) == 'Y' ){
                        temp.setCity(ans1);
                    }
                    break;
                case 3:
                    System.out.printf("Enter State > ");
                    ans1 = scan.nextLine();
                    
                    System.out.println("From " + temp.getState() + " Change to " + ans1);
                    System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                    confirmation = scan.next().charAt(0);
                    scan.nextLine();
                    System.out.println();
                    
                    if(Character.toUpperCase(confirmation) == 'Y' ){
                        temp.setState(ans1);
                    }
                    break;
                case 4:
                    ans2 = Validation.read_int(get,"Enter Poscode > ");
                    
                    System.out.println("From " + temp.getPosCode() + " Change to " + ans2);
                    System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                    confirmation = scan.next().charAt(0);
                    scan.nextLine();
                    System.out.println();
                    
                    if(Character.toUpperCase(confirmation) == 'Y' ){
                        temp.setPosCode(ans2);
                    }
                    break;
                case 5:
                    System.out.printf("Enter Country > ");
                    ans1 = scan.nextLine();
                    
                    System.out.println("From " + temp.getCountry() + " Change to " + ans1);
                    System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                    confirmation = scan.next().charAt(0);
                    scan.nextLine();
                    System.out.println();
                    
                    if(Character.toUpperCase(confirmation) == 'Y' ){
                        temp.setCountry(ans1);
                    }
                    break;
                case 6:
                    break;
            }
	}while (choice != 6);
        return temp;
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
                    temp = addStaff(temp);
	            break;
	        case 2:
	            temp = editStaffInfo(temp);
	            break;
                case 3:
                    staffDisplay(temp);
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(1);
            }
    	}while (choice != 4);
        return temp;
    }
    public static ArrayList<Staff> editStaffInfo(ArrayList<Staff> arr){
        ArrayList<Staff> temp = arr;
        int staffId;
    	String password;
    	boolean grant = false;
        int choice = 0;
        Person remember1 = new Staff();
        Staff remember2 = new Staff();
        
        System.out.printf("Enter Staff ID > ");
        staffId = get.nextInt();
        
        System.out.printf("Enter Password > ");
	password = scan.nextLine();
	    		
	for(Staff s : temp){
            if(s.getID() == staffId && s.getPassword().equals(password)){
                grant = true;
                remember1 = s;
                remember2 = s;
                break;
            }else {
                grant = false;
	    }
	}
        
        if(!grant){
	    System.out.println("Staff not exist !");
	}else{
            do{
		System.out.println("1. Personal Info");
                System.out.println("2. Address");
                System.out.println("3. Account Specification");
                System.out.println("4. Return");
                System.out.println("5. Exit");
                System.out.print("Select Field to Edit (1-4) > ");
                choice = scan.nextInt();
		System.out.println();
                
                switch(choice){
                    case 1:
			remember1 = editPersonalInfo(remember1);
			break;
                    case 2:
			remember1 = editAddress(remember1);
                        break;
                    case 3:
			remember2 = editAccSpecification(remember2);
			break;
                    case 4:
			break;
                    case 5:
                        System.exit(1);
                }
	    }while (choice != 4);
        }
        return temp;
    }
    public static Staff editAccSpecification(Staff s){
        Staff temp = s;
        int choice;
        
        do{
            System.out.println("1. Reset Password");
            System.out.println("2. Reset Security Code");
            System.out.println("3. Job Position");
            System.out.println("4. Job Description");
            System.out.println("5. Return");
            System.out.print("Select Field to Edit (1-5) > ");
            choice = get.nextInt();
            System.out.println();
            
            String ans1;
            String ans1_1;
            int ans2;
            int ans2_2;
            char confirmation;
            
            switch(choice){
                case 1:
                    System.out.printf("Enter Password (old) > ");
                    ans1 = scan.nextLine();
                    
                    if (temp.getPassword().equals(ans1)){
                        System.out.printf("Enter Security Code > ");
                        ans2 = get.nextInt();
                        
                        if(temp.getSecurityCode() == ans2){
                            do{
                                System.out.printf("Enter Password (new) > ");
                                ans1_1 = scan.nextLine();
                                
                                if(!Staff.validatePassword(ans1_1)){
                                    System.out.println("Password must contain at least 1 letter & 1 digit & more than 6 digit !");
                                }
                            }while (!Staff.validatePassword(ans1_1));
                    
                            System.out.println("From " + ans1 + " Change to " + ans1_1);
                            System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                            confirmation = scan.next().charAt(0);
                            scan.nextLine();
                            
                            if(Character.toUpperCase(confirmation) == 'Y' ){
                                System.out.println();
                                System.out.println(Staff.resetPassword(temp,ans2,ans1,ans1_1));
                            } else {
                                System.out.println("Cancel Reset Password !");
                                System.out.println();
                            }
                        }
                        else {
                            System.out.println("Security Code Entered not Match !");
                            System.out.println();
                        }
                    } else {
                        System.out.println("Password Entered not Match !");
                        System.out.println();
                    }
                    break;
                case 2:
                        System.out.printf("Enter Security Code (old) > ");
                        ans2 = get.nextInt();
                        
                        if(temp.getSecurityCode() == ans2){
                            do{
                                System.out.printf("Enter Security Code (new) > ");
                                ans2_2 = get.nextInt();
                                
                                if(!Staff.validateSecurityCode(ans2_2)){
                                    System.out.println("Security Code must only contain digit & not begin with 0 & more than 8 digit !");
                                }
                            }while (!Staff.validateSecurityCode(ans2_2));
                    
                            System.out.println("From " + ans2_2 + " Change to " + ans2_2);
                            System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                            confirmation = scan.next().charAt(0);
                            scan.nextLine();
                            
                            if(Character.toUpperCase(confirmation) == 'Y' ){
                                System.out.println();
                                Staff.resetSecurityCode(temp,ans2,ans2_2);
                            } else {
                                System.out.println("Cancel Reset Security Code !");
                                System.out.println();
                            }
                        }
                        else {
                            System.out.println("Security Code Entered not Match !");
                            System.out.println();
                        }
                    
                    break;
                case 3:
                    System.out.printf("Enter Job Position > ");
                    ans1 = scan.nextLine();
                    
                    System.out.println("From " + temp.getPost() + " Change to " + ans1);
                    System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                    confirmation = scan.next().charAt(0);
                    scan.nextLine();
                    
                    if(Character.toUpperCase(confirmation) == 'Y' ){
                        temp.setPost(ans1);
                    }
                    break;
                case 4:
                    System.out.printf("Enter Job Description > ");
                    ans1 = scan.nextLine();
                    
                    System.out.println("From " + temp.getJobDesc() + " Change to " + ans1);
                    System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                    confirmation = scan.next().charAt(0);
                    scan.nextLine();
                    System.out.println();
                    
                    if(Character.toUpperCase(confirmation) == 'Y' ){
                        temp.setJobDesc(ans1);
                    }
                    break;
                case 5:
                    break;
            }
	}while (choice != 5);
        return temp;
    }
    public static ArrayList<Staff> addStaff(ArrayList<Staff> arr){
    	ArrayList<Staff> temp = arr;
    	int count = arr.size() + 1;
    	int id = 5000+count;
        
    	String password;
    	int securityCode;
    	String post;
    	String jobDesc;
    	
        Person newStaff = addPerson(id);
        
    	System.out.printf("\nAccount Specification\n");
    	System.out.println("=====================");
    	do{
            System.out.printf("Enter password > ");
            password = scan.nextLine();
            System.out.printf("Enter Security Code > ");
	    securityCode = get.nextInt();
	    if(!Staff.validatePassword(password)){
	    	System.out.println("Password must contain at least 1 letter & 1 digit & more than 6 digit !");
	    }
	    if(!Staff.validateSecurityCode(securityCode)){
	    	System.out.println("Security Code must only contain digit & not begin with 0 & more than 8 digit !");
	    }
    	}while(!Staff.validatePassword(password) || !Staff.validateSecurityCode(securityCode));
    	System.out.printf("Enter Position > ");
    	post = scan.nextLine();
    	System.out.printf("Enter Job Description > ");
    	jobDesc = scan.nextLine();
    	
    	System.out.printf("\nRecord Entered\n");
    	System.out.println("**************");
    	System.out.println("Personal Info");
    	System.out.println("=============");
    	System.out.println("Enter first name : " + newStaff.getfName());
    	System.out.println("Enter last name : " + newStaff.getlName());
    	System.out.println("Enter Contact Number : " + newStaff.getPhNum());
    	System.out.println("Enter Age : " + newStaff.getAge());
    	System.out.println("Enter Gender : " + newStaff.getGender());
    	System.out.println("Enter Your Email : " + newStaff.getEmail());
    	
    	System.out.printf("\nAddress\n");
    	System.out.println("=======");
    	System.out.println("Enter Street : " + newStaff.getStreet());
    	System.out.println("Enter City : " + newStaff.getCity());
    	System.out.println("Enter State : " + newStaff.getState());
    	System.out.println("Enter Poscode : " + newStaff.getPosCode());
    	System.out.println("Enter Country : " + newStaff.getCountry());
    	
    	System.out.printf("\nAccount Specification\n");
    	System.out.println("=====================");
    	System.out.println("Enter password : " + password);
	System.out.println("Enter Security Code : " + securityCode);
    	System.out.println("Enter Position : " + post);
    	System.out.println("Enter Job Description : " + jobDesc);
    	
    	System.out.printf("Confirm Add in New Staff ? (Y=yes | N=no) > ");
    	char confirmation = scan.next().charAt(0);
    	System.out.println();
        
    	if(Character.toUpperCase(confirmation) == 'Y'){
    		temp.add(new Staff(newStaff, password, securityCode, post, jobDesc));
    	}else {
    		System.out.println("No Record Added !");
    	}
    	
    	return temp;
    }
    public static void staffDisplay(ArrayList<Staff> arr){
    	int choice;
    	
    	do{
	    System.out.println("1. Display specify staff record");
            System.out.println("2. Display all staff record");
            System.out.println("3. Return");
            System.out.println("4. Exit");
            System.out.print("Pick Your Action (1-3) > ");
            choice = get.nextInt();
            System.out.println();
            
	    switch(choice){
		case 1:
                    System.out.printf("Enter Staff ID > ");
                    int id = scan.nextInt();
                    Staff remember = new Staff();
                    boolean found = false;

                    for (Staff s : arr){
                        if(s.getID() == id){
                            found = true;
                            remember = s;
                            break;
                        }else {
                            found = false;
                        }
                    }
                    if (found = true){
                        System.out.println(remember.toString());
                    }else {
                        System.out.println("ID Enterd invalid !");
                    }
                    break;
		case 2:
                    int count = 1;
                    for (Staff s : arr){
                        System.out.printf("Staff %d\n", count);
                        System.out.println(s.toString());
                        count++;
                    }
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(1);
	    }
    	}while(choice != 3);
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
            System.out.println("5. History");
            System.out.println("6. Return");
            System.out.println("7. Exit");
            System.out.print("Pick Your Action (1-7) >  ");
            choice = scan.nextInt();
            scan.nextLine();
            
            switch(choice){
                case 1:
                    tempCust = addCustomer(tempCust);
                    break;
                case 2:
                    tempCust = editCustomer(tempCust);
                    break;
                case 3:
                    tempCust = buyTicket(tempCust, tempPk);
                    break;
                case 4:
                    System.out.print("Enter Customer ID > ");
                    int customerID = scan.nextInt();
                    displayOrder(customerID, tempCust);
                    break;
                case 5:
                    customerList(tempCust);
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(1);
            }
    	}while (choice != 6);
        return tempCust;
    }
    public static boolean expireValidation(int month, int year){ 
        Calendar calendar = Calendar.getInstance();
        
        if(calendar.get(Calendar.MONTH) > month && calendar.get(Calendar.YEAR) == year)
        {
            return false;
        }
        else if (calendar.get(Calendar.YEAR) > year)
        {
            return false;
        }
        
        return true;
    }
    public static ArrayList<Customer> addCustomer(ArrayList<Customer> cust){
       ArrayList<Customer> tempCust = cust;
       
       int count = cust.size() + 1;
       int id = 3000 + count;
       Person p = new Person();
        
        System.out.println("\nCustomer Information");
        System.out.println("************************");
        p = addPerson(id);
        System.out.printf("\nRecord Entered\n");
        System.out.println("**************");
        System.out.println("Personal Info");
        System.out.println("=============");
        System.out.println("Enter first name : " + p.getfName());
        System.out.println("Enter last name : " + p.getlName());
        System.out.println("Enter Contact Number : " + p.getPhNum());
        System.out.println("Enter Age : " + p.getAge());
        System.out.println("Enter Gender : " + p.getGender());
        System.out.println("Enter Your Email : " + p.getEmail());
        System.out.printf("\nAddress\n");
        System.out.println("============");
        System.out.println("Enter Street : " + p.getStreet());
        System.out.println("Enter City : " + p.getCity());
        System.out.println("Enter State : " + p.getState());
        System.out.println("Enter Poscode : " + p.getPosCode());
        System.out.println("Enter Country : " + p.getCountry());
        System.out.printf("Confirm Customer Record? (Y=yes | N=no) > ");
        char confirmation = scan.next().charAt(0);

        if(Character.toUpperCase(confirmation) == 'Y'){
            System.out.println("\n Success !!!");
            System.out.println(p.getfName() + " Customer ID > " + p.getID() + "\n");
            cust.add(new Customer(p, "NULL", "NULL", 0, 0 , "NULL" , 0, "NULL", "NULL" , 0.00));
        }else {
            System.out.println("Registration Failed !");
        }
      return tempCust;
   }    
    public static ArrayList<Customer> editCustomer(ArrayList<Customer> cust){
        ArrayList <Customer> tempCust = cust;
        int customerID, selection;
        boolean success = false;
        Person store = new Person();
        System.out.print("Enter Customer ID > ");
        customerID = scan.nextInt();     
        scan.nextLine();
        for(Customer c : cust)
        {
            if (c.getID() != customerID )
            {
                success = false;
            }else{
                success = true;
                store = c;
                break;
            }
        }
        if(!success)
        {
            System.out.printf("\n Customer does not exist ! \n");
        }
        else{
            
            do{
                System.out.println("1. Personal Info");
                System.out.println("2. Address");
                System.out.println("3. Return");
                System.out.print("Select Field to Edit (1-3) > ");
                selection = scan.nextInt();

                switch(selection){
                    case 1:
                        store = editPersonalInfo(store);
                        break;
                    case 2:
                        store = editAddress(store);
                        break;
                    case 3:
                        break;
                }
            }while (selection != 3);
        }
        return tempCust;
    }
    public static ArrayList<Customer> buyTicket(ArrayList<Customer> cust, ArrayList<Package> pk){
        ArrayList<Customer> tempCust = cust;
        ArrayList<Package> tempPk = pk;
        Customer remember = new Customer();
        boolean shouldContinue = false, shouldContinue2 = false, shouldContinue3 = false, again = false;
        int quit, quantityOrder, error=0;
        String ticketChoice, packageChoice;
        char cancel, cancelAgain;
        
        System.out.print("Enter Customer ID > ");
        int login = scan.nextInt();
        scan.nextLine();
        for(Customer c : tempCust)
        {
            if(c.getID() != login)
            {
                error ++;
            }
            else
            {
                while(again== false)
                {
                    System.out.println("\nPurchase Ticket");
                    System.out.println("==================");
                    System.out.println("PACKAGES CHOICES");
                    System.out.println("***********************");
                    for(Package p : tempPk)
                    {
                        System.out.println("Package : " +  p.getTitle());
                        System.out.println("Normal Price : RM " +  p.getNormalPrice());
                        System.out.println("Premium Price : RM " +  p.getPremiumPrice());
                        System.out.println("Party Price : RM " + p.getParty()+ "\n");
                    }
                    System.out.print("Enter which pacakage to purchase > ");
                    packageChoice = scan.nextLine();
                    for(Package p : tempPk)
                    {
                        if (!p.getTitle().equals(packageChoice))
                        {
                            error ++;
                        }
                        else
                        {
                            if (p.getTitle().equals(packageChoice))
                            {
                                while(shouldContinue3 == false)
                                {
                                    System.out.print("Choose a number of the Ticket type 1.Classic 2.Premium 3.Party > "); 
                                    int type = scan.nextInt();
                                    scan.nextLine();
                                    switch(type)
                                    {
                                        case 1:
                                            while(shouldContinue2 == false)
                                            {
                                                System.out.print("Enter ticket quantity > ");
                                                quantityOrder = scan.nextInt();
                                                if(quantityOrder > 10 && !Character.isDigit(quantityOrder))
                                                {
                                                    System.out.println("\n----- Invalid Value || You have exceed the order ticket limit -----\n\n");
                                                    System.out.print("Would you like to try again (Y=yes | N=no) > ");
                                                    char back = scan.next().charAt(0);
                                                    if(Character.toUpperCase(back) == 'Y')
                                                    {
                                                       scan.nextLine();
                                                       System.out.println("");
                                                       shouldContinue2 = false;
                                                    }
                                                    else
                                                    {
                                                       error++;
                                                       again = true;
                                                       shouldContinue2 = true;
                                                       shouldContinue3 = true;
                                                       break;
                                                    }
                                                }
                                                else
                                                {
                                                    while(shouldContinue == false)
                                                    {
                                                        System.out.print("Ticket Day Pass > ");
                                                        int ticketpass = scan.nextInt();
                                                        if(!Character.isDigit(ticketpass) && ticketpass > 31)
                                                        {
                                                            System.out.println("\n----- Invalid value! / TiceketPass limit to 31 days only -----\n");
                                                            System.out.print("Would you like to try again (Y=yes | N=no) > ");
                                                            char back = scan.next().charAt(0);
                                                            if(Character.toUpperCase(back) == 'Y')
                                                            {
                                                               scan.nextLine();
                                                               System.out.println("");
                                                               shouldContinue = false;
                                                            }
                                                            else
                                                            {
                                                               error++;
                                                               again = true;
                                                               shouldContinue = true;
                                                               shouldContinue2 = true;
                                                               shouldContinue3 = true;
                                                               break;
                                                            }
                                                        }
                                                        else
                                                        {
                                                            System.out.printf("\n!!! DONE !!! \n");
                                                            Date date1 = Calendar.getInstance().getTime();  
                                                            DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
                                                            String orderDate = dateFormat1.format(date1); 
                                                            c.setOrderDate(orderDate);
                                                            c.setPacket(packageChoice);
                                                            ticketChoice = "Classic";
                                                            int tickID = (int)(Math.random() * 10000000);
                                                            c.setTicketID(tickID );
                                                            c.setTicketType(ticketChoice);
                                                            c.setQuantity(quantityOrder);
                                                            c.setPass(ticketpass);
                                                            double totalPay = p.getNormalPrice() * quantityOrder * ticketpass;
                                                            c.setTotal(totalPay);
                                                            c.setPaymentType("NOT PAID");
                                                            c.setCardNum("NOT PAID");
                                                            remember = c;
                                                            error = 0;
                                                            again = true;
                                                            shouldContinue = true;
                                                            shouldContinue2 = true;
                                                            shouldContinue3 = true;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        case 2:
                                            while(shouldContinue2 == false)
                                            {
                                                System.out.print("Enter ticket quantity > ");
                                                quantityOrder = scan.nextInt();
                                                if(quantityOrder > 1000 & !Character.isDigit(quantityOrder))
                                                {
                                                    System.out.println("\n----- Invalid Value || You have exceed the order ticket limit -----");
                                                    System.out.print("Would you like to try again (Y=yes | N=no) > ");
                                                    char back = scan.next().charAt(0);
                                                    if(Character.toUpperCase(back) == 'Y')
                                                    {
                                                       scan.nextLine();
                                                       System.out.println("");
                                                       shouldContinue2 = false;
                                                    }
                                                    else
                                                    {
                                                       error++;
                                                       again = true;
                                                       shouldContinue2 = true;
                                                       shouldContinue3 = true;
                                                       break;
                                                    } 
                                                }
                                                else
                                                {
                                                     while(shouldContinue == false)
                                                     {
                                                        System.out.print("Ticket Day Pass > ");
                                                        int ticketpass = scan.nextInt();
                                                        if(!Character.isDigit(ticketpass) && ticketpass > 31)
                                                        {
                                                            System.out.println("\n----- Invalid value! / TiceketPass limit to 31 days only -----");
                                                            System.out.print("Would you like to try again (Y=yes | N=no) > ");
                                                            char back = scan.next().charAt(0);
                                                            if(Character.toUpperCase(back) == 'Y')
                                                            {
                                                               scan.nextLine();
                                                               System.out.println("");
                                                               shouldContinue = false;
                                                            }
                                                            else
                                                            {
                                                               error++;
                                                               again = true;
                                                               shouldContinue = true;
                                                               shouldContinue2 = true;
                                                               shouldContinue3 = true;
                                                               break;
                                                            }
                                                        }
                                                        else
                                                        {
                                                            System.out.printf("\n!!! DONE !!! \n");
                                                            Date date1 = Calendar.getInstance().getTime();  
                                                            DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
                                                            String orderDate = dateFormat1.format(date1); 
                                                            c.setOrderDate(orderDate);
                                                            c.setPacket(packageChoice);
                                                            ticketChoice = "Premium";
                                                            int tickID = (int)(Math.random() * 10000000);
                                                            c.setTicketID(tickID );
                                                            c.setTicketType(ticketChoice);
                                                            c.setQuantity(quantityOrder);
                                                            c.setPass(ticketpass);
                                                            double totalPay = p.getPremiumPrice() * quantityOrder * ticketpass;
                                                            c.setTotal(totalPay);
                                                            c.setPaymentType("NOT PAID");
                                                            c.setCardNum("NOT PAID");
                                                            remember = c;
                                                            error = 0;
                                                            again = true;
                                                            shouldContinue = true;
                                                            shouldContinue2 = true;
                                                            shouldContinue3 = true;
                                                            break;
                                                        }
                                                     }
                                                    
                                                }
                                            }
                                            break;
                                        case 3:
                                            while(shouldContinue2 == false)
                                            {
                                                System.out.print("Enter ticket quantity > ");
                                                quantityOrder = scan.nextInt();
                                                if(quantityOrder > 1000 & !Character.isDigit(quantityOrder))
                                                {
                                                    System.out.println("\n----- Invalid Value || You have exceed the order ticket limit -----");
                                                    System.out.print("Would you like to try again (Y=yes | N=no) > ");
                                                    char back = scan.next().charAt(0);
                                                    if(Character.toUpperCase(back) == 'Y')
                                                    {
                                                       scan.nextLine();
                                                       System.out.println("");
                                                       shouldContinue2 = false;
                                                    }
                                                    else
                                                    {
                                                       error++;
                                                       again = true;
                                                       shouldContinue2 = true;
                                                       shouldContinue3 = true;
                                                       break;
                                                    } 
                                                }
                                                else
                                                {
                                                     while(shouldContinue == false)
                                                     {
                                                        System.out.print("Ticket Day Pass > ");
                                                        int ticketpass = scan.nextInt();
                                                        if(!Character.isDigit(ticketpass) && ticketpass > 31)
                                                        {
                                                            System.out.println("\n----- Invalid value! / TiceketPass limit to 31 days only -----");
                                                            System.out.print("Would you like to try again (Y=yes | N=no) > ");
                                                            char back = scan.next().charAt(0);
                                                            if(Character.toUpperCase(back) == 'Y')
                                                            {
                                                               scan.nextLine();
                                                               System.out.println("");
                                                               shouldContinue = false;
                                                            }
                                                            else
                                                            {
                                                               error++;
                                                               again = true;
                                                               shouldContinue = true;
                                                               shouldContinue2 = true;
                                                               shouldContinue3 = true;
                                                               break;
                                                            }
                                                        }
                                                        else
                                                        {
                                                            System.out.printf("\n!!! DONE !!! \n");
                                                            Date date1 = Calendar.getInstance().getTime();  
                                                            DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
                                                            String orderDate = dateFormat1.format(date1); 
                                                            c.setOrderDate(orderDate);
                                                            c.setPacket(packageChoice);
                                                            ticketChoice = "Party";
                                                            int tickID = (int)(Math.random() * 10000000);
                                                            c.setTicketID(tickID );
                                                            c.setTicketType(ticketChoice);
                                                            c.setQuantity(quantityOrder);
                                                            c.setPass(ticketpass);
                                                            double totalPay = p.getParty() * quantityOrder * ticketpass;
                                                            c.setTotal(totalPay);
                                                            c.setPaymentType("NOT PAID");
                                                            c.setCardNum("NOT PAID");
                                                            remember = c;
                                                            error = 0;
                                                            again = true;
                                                            shouldContinue = true;
                                                            shouldContinue2 = true;
                                                            shouldContinue3 = true;
                                                            break;
                                                        }
                                                     }

                                                }
                                            }
                                            break;
                                        default:
                                            System.out.printf("\n ------- Invalid Ticket Type -------\n");
                                            System.out.print("Would you like to try again (Y=yes | N=no) > ");
                                            char back = scan.next().charAt(0);
                                            if(Character.toUpperCase(back) == 'Y')
                                            {
                                                scan.nextLine();
                                                System.out.println("");
                                                shouldContinue3 = false;
                                            }
                                            else
                                            {
                                                error++;
                                                shouldContinue3 = true;
                                                again = true;
                                                break;
                                            }
                                    }
                                }
                            }
                            break;
                        }
                    } 
                    if(error != 0 )
                    {
                        again = true;
                        error++;
                        break;
                    }
                }
                break;
            }
        }   
        if(error != 0)
        {
           System.out.print("\n***** NOT RECORDED *****\n");
        }
        else
        {
           confirmation(remember.getID(), tempCust, tempPk);
        }
        
        return tempCust;
    }
    public static ArrayList<Customer> confirmation(int custID1, ArrayList<Customer> cust, ArrayList<Package> pk){
        ArrayList<Customer> tempCust = cust;
        ArrayList<Package> tempPk = pk;
        Customer remember = new Customer();
        
        boolean again = false;
        int error=0;
        double editTotal= 0;
        char quit;
        
        for(Customer c : tempCust)
        {
            if(c.getID() == custID1)
            {
                do
                {
                    System.out.println("\n\t\t Confirmation Order \t\t\t");
                    System.out.println("**********************************************************");
                    System.out.println("< Customer Information >");
                    System.out.println("First Name: " + c.getfName() + "\t" + "Last Name: " + c.getlName());
                    System.out.println("Age: " + c.getAge() + "\t" + "Gender: " + c.getGender());
                    System.out.println("Phone Num: " + c.getPhNum() + "\t" + "Email: " + c.getEmail());
                    System.out.println("Address: " + c.getStreet() + ", " + c.getCity());
                    System.out.println("\t" + c.getPosCode()+ ", " + c.getState() + ", " + c.getCountry());
                    System.out.println("----------------------------------------------------------");
                    System.out.println("< Ticket Information >");
                    System.out.println("Customer ID: " + c.getID());
                    System.out.println("Check-in: "+ c.getOrderDate() + "\t" + "Ticket Pass: " + c.getPass() + "day(s)");
                    System.out.println("Ticket Quantity: " + c.getQuantity() + "\t\t" + "Ticket Type: " + c.getTicketType());
                    System.out.println("Ticket ID: " + c.getTicketID() + "\t" + "Package Purchased: " + c.getPacket());
                    System.out.println("**********************************************************");
                    System.out.println("|  TOTAL PRICE (RM): " + c.getTotal() + "\t\t\t       |");
                    System.out.println("**********************************************************");
                    System.out.print("\nWould you like to edit your order? (Y=yes | N=no) > ");
                    char edit = scan.nextLine().charAt(0);
                    System.out.println();
                    if(Character.toUpperCase(edit) == 'Y')
                    {
                        int choice = 0; char confirmation;
                        do
                        {
                            System.out.println("\n1. Edit Package ");
                            System.out.println("2. Edit Ticket Type ");
                            System.out.println("3. Edit Quantity ");
                            System.out.println("4. Edit Ticket daypass ");
                            System.out.println("5. Back to Order Confirmation ");
                            System.out.print("Choose which to Edit > ");
                            choice = scan.nextInt();
                            scan.nextLine();
                            
                            switch(choice){
                                case 1:
                                    System.out.println("\nPurchase Ticket");
                                    System.out.println("==================");
                                    System.out.println("PACKAGES CHOICES");
                                    System.out.println("***********************");
                                    for(Package p : tempPk){
                                        System.out.println("Package : " +  p.getTitle());
                                        System.out.println("Normal Price : RM " +  p.getNormalPrice());
                                        System.out.println("Premium Price : RM " +  p.getPremiumPrice());
                                        System.out.println("Party Price : RM " +  p.getParty() + "\n");
                                    }
                                    System.out.print("Enter which pacakage to purchase > ");
                                    String editpackage = scan.nextLine();
                                    for(Package p : tempPk)
                                    {
                                        if (!p.getTitle().equals(editpackage))
                                        {
                                            error ++;
                                        }
                                        else
                                        {
                                            if (p.getTitle().equals(editpackage))
                                            {
                                                System.out.println("From " + c.getPacket() + " Change to " + editpackage);
                                                System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                                                confirmation = scan.nextLine().charAt(0);
                                                if(Character.toUpperCase(confirmation) == 'Y' )
                                                {
                                                    if(c.getTicketType().equals("Classic"))
                                                    {
                                                        c.setPacket(editpackage);
                                                        System.out.println("\n!!! DONE !!! ");
                                                        editTotal =(p.getNormalPrice() * c.getQuantity() * c.getPass()) ;
                                                        c.setTotal(editTotal);
                                                        remember = c;
                                                        error = 0;
                                                        again = true;
                                                        break;
                                                    }
                                                    else if(c.getTicketType().equals("Premium"))
                                                    {
                                                        c.setPacket(editpackage);
                                                        System.out.println("\n!!! DONE !!! ");
                                                        editTotal = (p.getPremiumPrice() * c.getQuantity() * c.getPass());
                                                        c.setTotal(editTotal);
                                                        remember = c;
                                                        error = 0;
                                                        again = true;
                                                        break;
                                                    }
                                                    else if(c.getTicketType().equals("Party"))
                                                    {
                                                        c.setPacket(editpackage);
                                                        System.out.println("\n!!! DONE !!! ");
                                                        editTotal = (p.getParty() * c.getQuantity() * c.getPass());
                                                        c.setTotal(editTotal);
                                                        remember = c;
                                                        error = 0;
                                                        again = true;
                                                        break;
                                                    }
                                                    else
                                                    {
                                                        System.out.print("Error");
                                                        break;
                                                    }
                                                }
                                            }
                                            break; 
                                        }
                                    }
                                    if(error != 0)
                                    {
                                        System.out.println("\n !!! Record No Changes / Invalid !!! ");
                                        again = true;
                                        break;
                                    }
                                    break;
                                case 2:                                    
                                    String typeChoice;
                                    System.out.print("\nEdit Ticket Type ( 1.Classic | 2.Premium | 3.Party ) > ");
                                    int type = scan.nextInt();
                                    scan.nextLine();
                                    switch(type)
                                    {
                                        case 1 :

                                            System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                                            confirmation = scan.nextLine().charAt(0);
                                            if(Character.toUpperCase(confirmation) == 'Y' )
                                            {
                                                for(Package p : tempPk)
                                                {
                                                    if(p.getTitle().equals(c.getPacket()))
                                                    {
                                                        typeChoice = "Classic";
                                                        c.setTicketType(typeChoice);
                                                        System.out.println("\n!!! DONE !!! ");
                                                        editTotal = (p.getNormalPrice() * c.getQuantity() * c.getPass());
                                                        c.setTotal(editTotal);
                                                        remember = c;
                                                        error = 0;
                                                        again = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            else
                                            {
                                                System.out.println("\nNo record changed");
                                                break;
                                            }
                                            break;
                                        case 2 :
                                            System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                                            confirmation = scan.nextLine().charAt(0);
                                            if(Character.toUpperCase(confirmation) == 'Y' )
                                            {
                                                for(Package p : tempPk)
                                                {
                                                    if(p.getTitle().equals(c.getPacket()))
                                                    {
                                                        typeChoice = "Premium";
                                                        c.setTicketType(typeChoice);
                                                        System.out.println("\n!!! DONE !!! ");
                                                        editTotal = (p.getPremiumPrice() * c.getQuantity() * c.getPass());
                                                        c.setTotal(editTotal);
                                                        remember = c;
                                                        error = 0;
                                                        again = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            else
                                            {
                                                System.out.println("\nNo record changed");
                                                break;
                                            }
                                            break;
                                        case 3 :
                                            System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                                            confirmation = scan.nextLine().charAt(0);
                                            if(Character.toUpperCase(confirmation) == 'Y' )
                                            {
                                                for(Package p : tempPk)
                                                {
                                                    if(p.getTitle().equals(c.getPacket()))
                                                    {
                                                        typeChoice = "Party";
                                                        c.setTicketType(typeChoice);
                                                        System.out.println("\n!!! DONE !!! ");
                                                        editTotal = (p.getParty() * c.getQuantity() * c.getPass());
                                                        c.setTotal(editTotal);
                                                        remember = c;
                                                        error = 0;
                                                        again = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            else
                                            {
                                                System.out.println("\nNo record changed");
                                                break;
                                            }
                                            break;
                                        default:
                                            System.out.println("\n ------- Invalid Input Value either 1 or 2 -------");
                                            break;
                                    }
                                    break;
                                case 3:
                                    System.out.print("\nEdit Quantity > ");
                                    int quantity = scan.nextInt();
                                    scan.nextLine();
                                    if(quantity > 10 && !Character.isDigit(quantity))
                                    {
                                        System.out.println("\n You have exceed the limit quantity / Invalid input");
                                    }
                                    else
                                    {
                                        System.out.println("From " + c.getQuantity() + " Change to " + quantity);
                                        System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                                        confirmation = scan.nextLine().charAt(0);
                                        if(Character.toUpperCase(confirmation) == 'Y' )
                                        {
                                            for(Package p : tempPk)
                                            {
                                                if(p.getTitle().equals(c.getPacket()))
                                                {
                                                    if(c.getTicketType().equals("Classic"))
                                                    {
                                                        c.setQuantity(quantity);
                                                        System.out.println("\n!!! DONE !!! ");
                                                        editTotal =(p.getNormalPrice() * quantity * c.getPass()) ;
                                                        c.setTotal(editTotal);
                                                        remember = c;
                                                        error = 0;
                                                        again = true;
                                                        break;
                                                    }
                                                    else if(c.getTicketType().equals("Premium"))
                                                    {
                                                        c.setQuantity(quantity);
                                                        System.out.println("\n!!! DONE !!! ");
                                                        editTotal = (p.getPremiumPrice() * quantity * c.getPass());
                                                        c.setTotal(editTotal);
                                                        remember = c;
                                                        error = 0;
                                                        again = true;
                                                        break;
                                                    }
                                                    else if(c.getTicketType().equals("Party"))
                                                    {
                                                        c.setQuantity(quantity);
                                                        System.out.println("\n!!! DONE !!! ");
                                                        editTotal = (p.getParty() * quantity * c.getPass());
                                                        c.setTotal(editTotal);
                                                        remember = c;
                                                        error = 0;
                                                        again = true;
                                                        break;
                                                    }
                                                    else
                                                    {
                                                        System.out.print("Error");
                                                    }
                                                }
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("\nNo record changed");
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                case 4:
                                    
                                    System.out.print("\nEdit Ticket daypass > ");
                                    int editpass = scan.nextInt();
                                    scan.nextLine();
                                    if(!Character.isDigit(editpass) && editpass > 31)
                                    {
                                        System.out.println("\n----- Invalid value! / TiceketPass limit to 31 days only -----");
                                    }
                                    else
                                    {
                                        System.out.println("From " + c.getPass() + " Change to " + editpass);
                                        System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                                        confirmation = scan.next().charAt(0);
                                        if(Character.toUpperCase(confirmation) == 'Y' )
                                        {                                                
                                            for(Package p : tempPk)
                                            {
                                                if(p.getTitle().equals(c.getPacket()))
                                                {
                                                    if(c.getTicketType().equals("Classic"))
                                                    {
                                                        c.setPass(editpass);
                                                        System.out.println("\n!!! DONE !!! ");
                                                        editTotal= (p.getNormalPrice() * c.getQuantity() * editpass);
                                                        c.setTotal(editTotal);
                                                        remember = c;
                                                        error = 0;
                                                        again = true;
                                                        break;
                                                    }
                                                    else if(c.getTicketType().equals("Premium"))
                                                    {
                                                        c.setPass(editpass);
                                                        System.out.println("\n!!! DONE !!! ");
                                                        editTotal = (p.getPremiumPrice() * c.getQuantity() * editpass);
                                                        c.setTotal(editTotal);
                                                        remember = c;
                                                        error = 0;
                                                        again = true;
                                                        break;
                                                    }
                                                     else if(c.getTicketType().equals("Party"))
                                                    {
                                                        c.setPass(editpass);
                                                        System.out.println("\n!!! DONE !!! ");
                                                        editTotal = (p.getParty() * c.getQuantity() * editpass);
                                                        c.setTotal(editTotal);
                                                        remember = c;
                                                        error = 0;
                                                        again = true;
                                                        break;
                                                    }
                                                    else
                                                    {
                                                        System.out.print("Error");
                                                    }
                                                }
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("\nNo record changed");
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                case 5:
                                    again = false;
                                    break;
                            }
                        }while(choice != 5);                           
                    }
                    else if(Character.toUpperCase(edit) == 'N')
                    {
                        System.out.println("\n !! DONE !!! \n");
                        remember = c;
                        error = 0;
                        again = true;
                        break;
                    }
                    else
                    {
                        System.out.print("Do you want to cancel order? (Y=yes | N=no) > ");
                        quit = scan.nextLine().charAt(0);
                        if(Character.toUpperCase(quit) == 'N')
                        {
                            again = false;
                        }
                        else
                        {
                            error++;
                            c.setOrderDate(" --- ");
                            c.setPacket(" ORDER CANCELLED ");
                            c.setTicketID(000);
                            c.setTicketType(" ORDER CANCELLED ");
                            c.setQuantity(000);
                            c.setPass(000);
                            c.setPaymentType("NOT PAID");
                            c.setCardNum("NOT PAID");
                            c.setTotal(0.00);
                            break;
                        }
                    }   
                }while(again == false);
                break;
            }
            else
            {
               error++;
            }
        }
        if(error != 0)
        {
            System.out.println("\n !!! ORDER CANCELLED !!!");
        }
        else
        {
            Payment(remember.getID(), tempCust);
        }
        return tempCust;
    }
    public static ArrayList<Customer> Payment(int custID2, ArrayList<Customer> cust){
        ArrayList<Customer> tempCust = cust;
        
        Customer remember = new Customer();
        int error = 0, paymentType;
        Scanner scan = new Scanner(System.in);
        boolean shouldContinue = false;
        boolean validateCard = false;
        for(Customer c : tempCust)
        {
            if(c.getID() != custID2)
            {
               error++;
            }
            else
            { 
                while(shouldContinue == false)
                {
                    System.out.print("Enter customer payment type 1.CASH 2.CARD (Enter either 1 digit) > ");
                    paymentType = scan.nextInt();
                    switch (paymentType)
                    {
                        case 1:
                            error = 0;
                            String payment1 = "Cash";
                            c.setCardNum("NULL");
                            c.setPaymentType(payment1);
                            remember = c;
                            shouldContinue = true;
                            break;
                            
                        case 2 :
                            System.out.print("Enter customer card number > ");
                            scan.nextLine();
                            String cardNo = scan.nextLine();
                            if(cardNo.length() != 16)
                            {
                                System.out.println("Card Number is Invalid");
                                System.out.print("1.Change Selection 2.Quit Ordering (Select a digit) > ");
                                int out = scan.nextInt();
                                if(out == 1)
                                {
                                   shouldContinue = false;
                                }
                                else
                                {
                                    c.setPaymentType("NOT PAID");
                                    c.setCardNum("NOT PAID");
                                    c.setTotal(0.00);
                                    error++;
                                    shouldContinue = true;
                                    break;
                                }
                                break;
                            }
                            else
                            {
                                c.setCardNum(cardNo);
                                System.out.println("Enter the GOOD THRU card (MONTH/YEAR)");
                                System.out.print("Month > ");
                                int month = scan.nextInt();
                                System.out.print("Year > ");
                                int year = scan.nextInt();
                                validateCard = expireValidation(month, year);
                                if(validateCard == true)
                                {
                                    String payment2 = "Card";
                                    c.setPaymentType(payment2);
                                    remember = c;
                                    shouldContinue = true;
                                    error=0;
                                    break;
                                }
                                else
                                {
                                    scan.nextLine();
                                    System.out.println("Your Card has expired");
                                    System.out.print("1.Retype again 2.Quit Ordering (Select a digit) > ");
                                    int out = scan.nextInt();
                                    if(out == 1)
                                    {
                                       shouldContinue = false;
                                    }
                                    else
                                    {
                                        c.setPaymentType("NOT PAID");
                                        c.setCardNum("NOT PAID");
                                        c.setTotal(0.00);
                                        error++;
                                        shouldContinue = true;
                                        break;
                                    }
                                }
                            }
                            break;
                            
                        default:
                            System.out.println("-------- Selection is invalid --------");
                            System.out.print("1.Retype again 2.Quit Ordering (Select a digit) > ");
                            int out3 = scan.nextInt();
                            if(out3 == 1)
                            {
                               shouldContinue = false;
                            }
                            else
                            {
                                c.setPaymentType("NOT PAID");
                                c.setCardNum("NOT PAID");
                                c.setTotal(0.00);
                                error++;
                                shouldContinue = true;
                                break;
                            }
                            break;
                    }
                }
                break;
            }
        }
        if(error!=0)
        {
            System.out.print("\n !!! Your Orders has been Cancelled !!! \n");
        }
        else
        {
            displayOrder(remember.getID(), tempCust);
        }
        return tempCust;
    }    
    public static void displayOrder(int customerID , ArrayList<Customer> cust){
        int error = 0;
        for(Customer c : cust)
        {
            if(c.getID() != customerID)
            {
                error ++;
            }
            else
            {
                error = 0;
                System.out.println("\n\t\t Receipt \t\t\t");
                System.out.println("**********************************************************");
                System.out.println("< Customer Information >");
                System.out.println("First Name: " + c.getfName() + "\t" + "Last Name: " + c.getlName());
                System.out.println("Age: " + c.getAge() + "\t" + "Gender: " + c.getGender());
                System.out.println("Phone Num: " + c.getPhNum() + "\t" + "Email: " + c.getEmail());
                System.out.println("Address: " + c.getStreet() + ", " + c.getCity());
                System.out.println("\t" + c.getPosCode()+ ", " + c.getState() + ", " + c.getCountry());
                System.out.println("----------------------------------------------------------");
                System.out.println("< Ticket Information >");
                System.out.println("Customer ID: " + c.getID());
                System.out.println("Check-in: "+ c.getOrderDate() + "\t" + "Ticket Pass: " + c.getPass() + "day(s)");
                System.out.println("Ticket Quantity: " + c.getQuantity() + "\t\t" + "Ticket Type: " + c.getTicketType());
                System.out.println("Ticket ID: " + c.getTicketID() + "\t" + "Package Purchased: " + c.getPacket());
                System.out.println("----------------------------------------------------------");
                System.out.println("< Payment Information >");
                System.out.println("Payment Type: " + c.getPaymentType() + "\t" + "Card Number: " + c.getCardNum());
                System.out.println("**********************************************************");
                System.out.println("|  TOTAL PRICE (RM): " + c.getTotal() + "\t\t\t       |");
                System.out.println("**********************************************************");
                break;
            }
        }
        if(error!=0)
        {
            System.out.print("\n !!! Customer ID not found !!! \n\n");
        }
        else
        {
            
        }
    }
    public static void customerList(ArrayList<Customer> cust){
        double sales = 0.00;
        System.out.println("\n   Customer List   ");
        System.out.println("*******************");
        for(Customer c : cust)
        {
            System.out.println(c.toString());
            sales += c.getTotal();
        }
        System.out.printf("Total Sales : %.2f \n", sales);
        
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
		scan.nextLine();
		   	switch(choice){
		   		case 1://add supplier
		   			addSupplier();
		   			break;
		   		case 2://Add product
                                        System.out.print("\nEnter your Supplier ID : ");
                                        suppID = scan.nextInt();
                                        scan.nextLine();
                                        for(int i=0; i<supplier.size(); i++){
                                            if(supplier.get(i).getID() == suppID){
                                               checkSupp = true;
                                               addProduct(supplier.get(i));
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
		   			editSupplier();
		   			break;
		   		case 4://edit Product
                                        System.out.print("\nEnter your Supplier ID : ");
                                        suppID = scan.nextInt();
                                        scan.nextLine();
                                        for(int i=0; i<supplier.size(); i++){
                                            if(supplier.get(i).getID() == suppID){
                                               checkSupp = true;
                                               updateProduct(supplier.get(i));
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
                                        suppList();
		   			break;
		   		case 6://display product that supply by one of the supplier
		   			prodList();
                                        break;
                                case 7://total ordering details
                                        summaryOrderNote();
		    		break;
		    	case 8:
		    		break;
		   	}
    	}while (choice != 8);
    }
    public static void addSupplier (){
      
        char ask;
        int id = Supplier.getSuppIdCount();
        
        System.out.print("\nDo you want to add supplier (Y/N) > ");
        ask = get.nextLine().charAt(0);
        System.out.println();
        if(Character.toUpperCase(ask) == 'Y'){
           
            Person p = addPerson(id);
            System.out.print("\nComfirm to add ?(Y/N) >");
            ask = get.nextLine().charAt(0);

            if(Character.toUpperCase(ask) == 'Y'){
                Supplier.getSupplier().add(new Supplier(p));
                id++;
                System.out.println("Supplier added !\n");
            }else{
                System.out.println("Failed added !\n");
            }

        } 
        
    }
    public static void editSupplier(){
        boolean isSupp = false;
        int sel=3;
        
        Supplier selectedSupp = new Supplier();
        ArrayList <Supplier> supp = Supplier.getSupplier();
        do{
            int id = Validation.read_int(scan, "\nEnter Supplier ID > ");

            for(int i = 0; i<supp.size(); i++){
                if (supp.get(i).getID() == id){
                    isSupp = true;
                    selectedSupp = supp.get(i);
                    break;
                }else{
                    isSupp = false;
                }
            }

            if(isSupp == true){
                do{
                System.out.println("\n-Edit Supplier-");
                System.out.println("================");
                System.out.println("1.Personal Info");
                System.out.println("2.Address");
                System.out.println("3. Return");
                System.out.print("Select which detail you want to edit (1-3) > ");
                sel = scan.nextInt();
                scan.nextLine();
                System.out.print("\n");
                switch(sel){
                    case 1:
                        editPersonalInfo(selectedSupp);
                        break;
                    case 2:
                        editAddress(selectedSupp);
                        break;
                    case 3:
                        break;
                }
                }while(sel!=3);
            }else{
                System.out.println("Invalid Supplier ID\n");
            }
            
        }while(!isSupp || sel!=3);
    }
    public static void suppList(){
        boolean checkID=false;
        int sel=3;
        ArrayList <Supplier> supp = Supplier.getSupplier();
        do{
            System.out.println("\n-Supplier List-");
            System.out.println("=========================");
            System.out.println("1.Display All Supplier");
            System.out.println("2.Display Particular Supplier");
            System.out.println("3.Return");
            System.out.print("Select which detail you want to edit (1-3) > ");
            sel = scan.nextInt();
            scan.nextLine();
            switch(sel){
                case 1:
                    System.out.print("\n");
                    for(int i =0; i<supp.size();i++){
                        System.out.println(supp.get(i));
                    }
                    break;
                case 2:
                        int suppID = Validation.read_int(scan, "Enter your Supplier ID > ");
                        
                        for(int i=0; i<supp.size();i++){
                            if(supp.get(i).getID()==suppID){
                                Supplier selectedSupp = supp.get(i);
                                checkID = true;
                                System.out.print("\n");
                                System.out.println(selectedSupp);
                                break;
                            }else{
                                checkID = false;
                            }
                        }
                        
                        if(!checkID){
                            System.out.println("Invalid  ID!!!!\n");
                        }
                    break;
                case 3:
                    break;
            }
            
        }while(sel!=3);
    }
    public static void summaryOrderNote(){
        boolean arrEmpty = Product.getProdList().isEmpty(); 
        boolean checkP=false;
        int sel=3;
        do{
            System.out.println("\n-Order Product History-");
            System.out.println("=========================");
            System.out.println("1.Overall Order Note");
            System.out.println("2.Particular Product Order Note");
            System.out.println("3.Return");
            System.out.print("Select which detail you want to edit (1-3) > ");
            sel = scan.nextInt();
            scan.nextLine();
            switch(sel){
                case 1:// overall order note
                    double total = 0;
                    if(arrEmpty == true){
                        System.out.println("Product List is empty!!!");
                    }else{
                        for(int i=0; i<Product.getProdList().size(); i++){
                            Product prod = Product.getProdList().get(i);
                            System.out.println("\n"+(i+1)+". Product :" + prod.getId());
                            System.out.println("Total Purchased Product :" + prod.getTotalQtyPurchased() + "\nPrice : RM " + prod.getPrice());
                            System.out.println("Subtotal : RM " + prod.subtotal() + "\n");
                            total += prod.subtotal();
                        }
                        System.out.println("Total (RM) : " + total + "\n");
                    }
                    break;
                case 2://Particular product order note
                    if(arrEmpty == true){
                        System.out.println("Product List is empty!!!");
                    }else{
                        int id = Validation.read_int(scan,"\nEnter product ID > ");
                        for(int i=0; i<Product.getProdList().size(); i++){
                            if(Product.getProdList().get(i).getId() == id){
                                Product prod = Product.getProdList().get(i);
                                System.out.println("\nProduct :" + prod.getId());
                                System.out.println("Total Purchased Product :" + prod.getTotalQtyPurchased() + "\nPrice : RM " + prod.getPrice());
                                System.out.println("Subtotal : RM " + prod.subtotal() + "\n");
                                checkP = true;
                                break;
                            }else{
                                checkP = false;
                            }
                        }
                        if(!checkP){
                            System.out.println("Invalid ID!!!!\n");
                        }
                    }
                    break;
                case 3:
                    break;
            }
        }while(sel !=3);
        
    }
    public static void addProduct(Supplier supp){
        int id =Product.getProductCount();
        //prompt and read
        System.out.println("\nproduct ID > " + id );  
        System.out.print("Enter product name > ");
        String name = get.nextLine();
        System.out.print("Enter product description > ");
        String description = get.nextLine();
        int qty = Validation.read_int(scan, "Enter product quantity > ");
        double price = Validation.read_double(scan, "Enter product price > ");
        
        System.out.print("Are you sure to add this product (Y/N) >");
        char ask = get.nextLine().charAt(0);
        
        if(Character.toUpperCase(ask) == 'Y'){
            Product newProduct = new Product(id,name,description,qty,price);
            Product.getProdList().add(newProduct);
            supp.getSuppProdList().add(newProduct);
            System.out.println("Product Success added!!!\n");
        }else{
            System.out.println("Product Failed added!!!\n");
        }
        
    } 
    public static void updateProduct(Supplier supp){
    	boolean isProd = false;
        boolean arrEmpty = supp.getSuppProdList().isEmpty(); 
        int sel =5;
        String oldP;
        int oldProd;
        double oldProdPrice;

            
            if(arrEmpty == true){
               System.out.println("This Supplier does not supply any product!!!");
            }else{
                System.out.println("\nSupplier supplied Product : ");
                for(int i = 0; i<supp.getSuppProdList().size(); i++){
                    System.out.println((i+1) + ". " + supp.getSuppProdList().get(i).getId());
                }
            }
          
           
            if(arrEmpty == false){ 
                do{
                int id = Validation.read_int(scan, "Enter product id > ");
                for(int i = 0; i<supp.getSuppProdList().size(); i++){
                    if (supp.getSuppProdList().get(i).getId() == id){
                        isProd = true; 
                        Product selectedProd = supp.getSuppProdList().get(i);
                        do{
                            System.out.println("\n-Product Detail-");
                            System.out.println("==================");
                            System.out.println("Selected Product <" + selectedProd.getId() +">");
                            System.out.println("1.Product Name : " + selectedProd.getName());
                            System.out.println("2.Product Description : " + selectedProd.getDescription());
                            System.out.println("3.Restock : (Last Restock history) >" + selectedProd.getQuantity());
                            System.out.println("4.Price : " + selectedProd.getPrice());
                            System.out.println("5. Return");
                            System.out.print("Select which detail you want to edit (1-5) > ");
                            sel = scan.nextInt();
                            scan.nextLine();
                            switch(sel){
                                case 1://modify prod name
                                    oldP = selectedProd.getName();
                                    System.out.print("\nEnter new Product Name : ");
                                    String prodDetails = get.nextLine();
                                    selectedProd.setName(prodDetails);
                                    System.out.printf("Successfully Modified Name (%s => %s)\n", oldP, selectedProd.getName());
                                    break;
                                case 2://modify prod des
                                    oldP = selectedProd.getDescription();
                                    System.out.print("\nEnter new Product Description : ");
                                    prodDetails = get.nextLine();
                                    selectedProd.setDescription(prodDetails);
                                    System.out.printf("Successfully Modified Description (%s => %s)\n", oldP, selectedProd.getDescription());
                                    break;
                                case 3://restock
                                    oldProd = selectedProd.getQuantity();
                                    int prodQty = Validation.read_int(scan, "\nEnter restock quantity : ");
                                    selectedProd.restock(prodQty);
                                    System.out.printf("Successfully Restock quantity (%d => %d)\n", oldProd, selectedProd.getQuantity());
                                    break;
                                case 4://modify prod price
                                    oldProdPrice = selectedProd.getPrice();
                                    double prodPrice = Validation.read_double(scan, "\nEnter new price : ");
                                    selectedProd.setPrice(prodPrice);
                                    System.out.printf("Successfully Modified Price (%.2f => %.2f)\n", oldProdPrice, selectedProd.getPrice());
                                    break;
                                case 5://exit
                                    break;
                            }
                        }while(sel != 5);
                        break;
                    }else{
                        isProd = false;
                    }
                }

                if(!isProd){
                    System.out.println("Invalid Product ID\n");
                }
                }while(isProd == false || sel!=5);
            }
    }
    public static void prodList(){
        boolean checkID=false;
        int sel=4;
        ArrayList <Supplier> supp = Supplier.getSupplier();
        do{
            System.out.println("\n-Product List-");
            System.out.println("=========================");
            System.out.println("1.Display All Product");
            System.out.println("2.Display Particular Product");
            System.out.println("3.Display Particular Supplier's product");
            System.out.println("4.Return");
            System.out.print("Select which detail you want to edit (1-4) > ");
            sel = scan.nextInt();
            scan.nextLine();
            switch(sel){
                case 1:
                    System.out.print("\n");
                    for(int i =0; i<Product.getProdList().size();i++){
                        System.out.println(Product.getProdList().get(i));
                    }
                    break;
                case 2:
                        int id = Validation.read_int(scan,"\nEnter product Id > ");
                        System.out.print("\n");
                        checkID = Product.prodList(id);

                        if(!checkID){
                            System.out.println("Invalid Product ID!!!!\n");
                        }
                    break;
                case 3:
                        int suppID = Validation.read_int(scan,"\nEnter your Supplier ID > ");
                        
                
                        for(int i=0; i<supp.size();i++){
                            if(supp.get(i).getID()==suppID){
                                Supplier selectedSupp = supp.get(i);
                                checkID = true;
                                System.out.print("\n");
                                
                                    if(selectedSupp.getSuppProdList().isEmpty() == true ){
                                         System.out.println("This Supplier does not supply any product!!!");
                                    }else{
                                        for(int l =0; l<selectedSupp.getSuppProdList().size();l++){
                                            System.out.println(selectedSupp.getSuppProdList().get(l));
                                        }
                                    }
                                
                                break;
                            }else{
                                checkID = false;
                            }
                        }
                        
                        if(!checkID){
                            System.out.println("Invalid  ID!!!!\n");
                        }
                        
                    break;
                case 4:
                    break;
            }
            
        }while(sel!=4);
     
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
                    temp = addPackage(temp);
                    break;
                case 2:
                    temp = editPackage(temp);
                    break;
                case 3:
                    temp = deletePackage(temp);
                    break;
                case 4:
                    packageDisplay(temp);
                    break;
                case 5:
                    break;
            }
    	}while (choice != 5);
        return temp;
    }
    public static ArrayList<Package> addPackage(ArrayList<Package> pk){
        ArrayList<Package> temp = pk;
        char confirm;
        
        int exist = 0;
        int id;
        String title;
        String []zone = new String[5];
        double normalPrice;
        double premiumPrice;
        int party;
        

        
        do{
            if (exist != 0){
                System.out.println("ID entered already Exist !");
                System.out.println();
            }
            System.out.println("Please add the Pacakge ID: ");
            id = get.nextInt();
            
            for(Package pp : temp){
                if(pp.getId() == id){
                    exist ++;
                    break;
                    
                }else {
                    exist=0;
                    
                    
                }
            }
        }while (exist != 0);
            
            System.out.println("Please add the title: ");
            title = scan.nextLine();
            
            for(int i=0; i<zone.length;i++)
            {
                System.out.println("Please add the zone: ");
                zone[i] = scan.nextLine();
            }
            
            
            
            System.out.println("Please add the normalPrice: ");
            normalPrice = scan.nextDouble();
            
            
            System.out.println("Please add the premiumPrice: ");
            premiumPrice = scan.nextDouble();
            
            
            System.out.println("Please add the party price: ");
            party = scan.nextInt();
            scan.nextLine();
            
            System.out.println("Are you confrim to add? (Y/N) : ");
            confirm = scan.nextLine().toUpperCase().charAt(0);
            
            for (Package p:pk){
                if(p.getId() == id){
                    System.out.println("Package exist");
                }else {
                    if(confirm == 'Y'){
                        temp.add(new Package(id,title,zone,normalPrice,premiumPrice,party));
                        System.out.println("Successful");
                        break;
                    }else{
                        System.out.println("No Package added");
                        break;
                    }
                }
            }
            


        return temp;
    }
    public static ArrayList<Package> editPackage(ArrayList<Package> pk){
        ArrayList<Package> temp = pk;
        char confirm;
        String title;
        String []zone = new String[5];
        double normalPrice;
        double premiumPrice;
        int party;
        
        int error=0;
        
        System.out.println("Enter Package ID to modify : ");
        int id = get.nextInt();
        
        for(Package p : temp){ 
            
            if (id == p.getId()){
                error=0;
                System.out.println("Package ID : " + p.getId());
                System.out.println("Please add the title: " + p.getTitle());
                for(int i=0; i<p.getZone().length; i++){
                    if(!p.getZone()[i].equals("0") && !p.getZone().equals(0))
                        System.out.println("Zone : " + p.getZone()[i] ); 
                    else 
                        break;
                }
                System.out.println("Normal Price: " + p.getNormalPrice());
                System.out.println("Premium Price: " + p.getPremiumPrice());
                System.out.println("Party Price: " + p.getParty());


                System.out.println("T = Title" + "\n" + "Z = Zone" + "\n"
                                    + "N = Normal Price" + "\n" + 
                                    "P = Premium Price" + "\n" + "A = Party");
                System.out.println("Which information you want to edit? (T/Z/N/P/A)");
                confirm = scan.nextLine().toUpperCase().charAt(0);
                scan.nextLine();
                if (confirm == 'T'){
                    System.out.println("Current title is : " + p.getTitle());
                    System.out.println("Please enter the new title : ");
                    title = scan.nextLine();
                    
                    p.setTitle(title);

                }else if (confirm == 'Z'){
                    String [] tempZone = p.getZone();
                    for(int i=0; i<tempZone.length; i++){
                        System.out.println("Current zone is " + tempZone[i]);
                        System.out.println("Please enter the new zone:");
                        zone[i] = scan.nextLine();
                    }
                    p.setZone(zone);
             
                }else if(confirm == 'N'){
                    System.out.println("Current normal price is : " + p.getNormalPrice());
                    System.out.println("Please enter the new normal price :");
                    normalPrice = get.nextDouble();
                    p.setNormalPrice(normalPrice);

                }else if (confirm == 'P'){
                    System.out.println("Current premium price is : " + p.getPremiumPrice());
                    System.out.println("Please enter the new premium price :");
                    premiumPrice = get.nextDouble();
                    p.setPremiumPrice(premiumPrice);

                }else if (confirm == 'A'){
                    System.out.println("Current party price is : " + p.getParty());
                    System.out.println("Please enter the new party price :");
                    party = get.nextInt();
                    p.setParty(party);

                }else{
                    System.out.println("Invalid character");
                    System.out.println("");
                    System.out.println("Please key in T/Z/N/P/A");
                    System.out.println(" ");
                }
                break;
            } else {
                error++;
            }

            
        }
        
        if(error > 0){
            System.out.println("Package ID entered invalid");
        }else{
            System.out.println("Successfully modified !");
        }
        return temp;
    }
    public static ArrayList<Package> deletePackage(ArrayList<Package> pk){
        ArrayList<Package> temp = pk;
        int confirm;
        boolean check = false;
        System.out.println("Please enter the package id to delete: " );
        confirm = get.nextInt();
            
        for(Package p : pk){
            if(confirm == p.getId()){
                temp.remove(p);
                check = true;
                break;
            }else{
                check = false;
            }
            
        }
        
        if(!check){
            System.out.println("Please enter the valid package id to delete: ");
        }else{
            System.out.println("Successfully delete!!!!");
        }
        
        return temp;
    }
    public static void packageDisplay(ArrayList<Package> pk){
        for(Package temp : pk){
           
                String[] tempZone = temp.getZone();
                for(int i=0; i<tempZone.length; i++){
                    if(tempZone[i] != null && !tempZone[i].equals("0"))
                        System.out.println("Zone : " + tempZone[i] ); 
                    else 
                        break;
                }
          
            System.out.println(temp.toString());
        }
    }
    
 
   
    
}