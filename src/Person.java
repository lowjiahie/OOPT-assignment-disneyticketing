/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author J.chong
 */
import java.util.Scanner;


public class Person extends Address{
    static Scanner scan = new Scanner(System.in);
    static Scanner get = new Scanner(System.in);
    
    private int id;
    private String fName;
    private String lName;
    private String phNum;
    private int age;
    private char gender;
    private String email;

    public Person(){
        super();
    }
    public Person(int id, String fName, String lName, String phNum, int age, char gender, String email, String street, String city, String state, int posCode, String country) {
        super(street, city, state, posCode, country);
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.phNum = phNum;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }
    
   
    public void setID(int id) {
            this.id = id;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public void setlName(String lName) {
        
        this.lName = lName;
    }
    public void setPhNum(String phoneNum) {
        this.phNum = phNum;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getID() {
        return id;
    }
    public String getfName() {
        return fName;
    }
    public String getlName() {
        return lName;
    }
    public String getPhNum() {
        return phNum;
    }
    public int getAge() {
        return age;
    }
    public char getGender() {
        return gender;
    }    
    public String getEmail() {
        return email;
    }
    
   
    public String toString() {
        return "ID : " + id + "\n" +
               "First Name : " + fName + "\n" +
               "Last Name : " + lName + "\n" +
               "Phone Number : " + phNum + "\n" +
               "Age : " + age + "\n" +
               "Gender : " + gender + "\n"+
               "Email : " + email + "\n" +
                super.toString();
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
    
    
    
}