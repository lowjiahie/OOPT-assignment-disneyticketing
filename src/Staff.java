import java.util.ArrayList;
import java.util.Scanner;
public class Staff extends Person{
    static Scanner scan = new Scanner(System.in);
    static Scanner get = new Scanner(System.in);
    
    private String password;
    private int securityCode; //code cannot be starting with 0
    private String post;
    private String jobDesc;

    public Staff(){
        super();
    }
    
    public Staff(Person p, String password, int securityCode, String post, String jobDesc) {
        super(p.getID(), p.getfName(), p.getlName(), p.getPhNum(), p.getAge(), p.getGender(), p.getEmail(), p.getState(), p.getCity(), p.getState(), p.getPosCode(), p.getCountry());
        this.password = password;
        this.securityCode = securityCode;
        this.post = post;
        this.jobDesc = jobDesc;
    }

    public String getPassword() {
        return password;
    }
    public int getSecurityCode() {
    	return securityCode;
    }
    public String getPost() {
    	return post;
    }
    public String getJobDesc() {
    	return jobDesc;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    public void setSecurityCode(int securityCode) {
    	this.securityCode = securityCode;
    }
    public void setPost(String post) {
    	this.post = post;
    }
    public void setJobDesc(String jobDesc) {
    	this.jobDesc = jobDesc;
    }
    
    public String toString() {
    	return super.toString() + 
    			"Password : " +  this.password + "\n" +
    			"Security Code : " +  this.securityCode + "\n" +
    			"Position : " +  this.post + "\n" +
    			"Job Description : " +  this.jobDesc + "\n";
    }
    public static boolean resetSecurityCode(Staff s, int securityCode, int newCode) {
    	int error = 0;
    	
        if (s.getSecurityCode() != securityCode) {
            error++;
        } else {
            s.setSecurityCode(newCode);
            error=0;
        }
            
    	if (error > 0){
    		return false;
    	}else {
    		return true;
    	}
    	
    }
    public static boolean resetPassword(Staff s, int securityCode, String password, String newPassword) {
    	int error = 0;

        if (s.getSecurityCode() != securityCode) {
            error++;
        } else {
            if (!s.getPassword().equals(password) ) {
                    error++;
            } else {
                    s.setPassword(newPassword);
                    error = 0;
            }
        }

    	if (error != 0){
    		return false;
    	}else {
    		return true;
    	}
    }
    public static boolean validatePassword(String password){
    	int error = 0;
    	int countDigit = 0;
    	int countLetter = 0;
    	
    	if(password.length() <= 6){
    		error++;
    	} else {
    		for (int i=0; i<password.length(); i++){
    			if(Character.isLetter(password.charAt(i))){
    				countLetter++;
    			}
    			if(Character.isDigit(password.charAt(i))){
    				countDigit++;
    			}
    		}
    		
    		if (countLetter < 1 || countDigit < 1){
    			error++;
    		}else {
    			for(int i=0; i<password.length(); i++){
			    	if (!Character.isLetter(password.charAt(i)) && !Character.isDigit(password.charAt(i))){
			    		error++;
			    	}else {
			    		error=0;
			    	}
		   		}
    		}
    	}
    	
    	if(error != 0){
    		return false;
    	}else {
    		return true;
    	}
    }
    public static boolean validateSecurityCode(int securityCode){ //securityCode cannot start from 0
    	int error = 0;
    	int code = securityCode;
    	int countDigit = 0;
    	
    	while (securityCode > 0){
    		securityCode /= 10;
    		countDigit++;
    	}
    	
    	if(countDigit <= 8){
    		return false;
    	}else {
    		return true;
    	}
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
    	
        Person newStaff = Person.addPerson(id);
        
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
}