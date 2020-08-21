/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin-jiahie
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Customer extends Personal_info
{   
    private Customer [] customer = new Customer [10000000];
    private String ticketID; 
    private String ticketType; //input
    private int quantity; //input
    private String date;
    private String timeIN;
    private String timeOUT;
    private String paymentType; 
    private int cardNum;
    private int custID;
    private static int idCount = 3001;
    private int custNum;
    private static int custCount = 1;

   public Customer(int id, String fName, String lName, String phNum, int age, char gender, String email,  String street, String city, String state, int posCode, String country, String ticketID, String ticketType, int quantity, String date, String timeIN, String timeOUT, String paymentType, int cardNum, int custID) 
    {
        super( id, fName, lName, phNum, age, gender, email, street, city, state, posCode, country);
        this.ticketID = ticketID;
        this.ticketType = ticketType;
        this.quantity = quantity;
        this.date = date;
        this.timeIN = timeIN;
        this.timeOUT = timeOUT;
        this.paymentType = paymentType;
        this.cardNum = cardNum;
        this.custID = custID;
        custID++;
    }

    public Customer[] getCustomer() {
        return customer;
    }
    public String getTicketID() {
        return ticketID;
    }
    public String getTicketType() {
        return ticketType;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getDate() {
        return date;
    }
    public String getTimeIN() {
        return timeIN;
    }
    public String getTimeOUT() {
        return timeOUT;
    }
    public String getPaymentType() {
        return paymentType;
    }
    public int getCardNum() {
        return cardNum;
    }
    public int getCustID() {
        return custID;
    }
    public int getCustNum() {
        return custNum;
    }
    public static int getIdCount() {
        return idCount;
    }
    public int getCustCount() {
        return custCount;
    }
    
    public void setCustomer(Customer[] customer) {
        this.customer = customer;
    }
    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setTimeIN(String timeIN) {
        this.timeIN = timeIN;
    }
    public void setTimeOUT(String timeOUT) {
        this.timeOUT = timeOUT;
    }
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }
    public void setCustID(int custID) {
        this.custID = custID;
    }
    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }
    public static void setIdCount(int idCount) {
        Customer.idCount = idCount;
    }
    public void setCustCount(int custCount) {
        this.custCount = custCount;
    }
    
 
    
    public void displayOrder(){//ask to view or add order
        Scanner scanner = new Scanner(System.in);
        System.out.print("Add order or view order 1.Add 2.View (Enter a digit): ");
        int order = scanner.nextInt();
        if(order == 1)
        {
            System.out.print("Enter customer ID");
            int login1 = scanner.nextInt();
            Ticket(login1);
        }
        else if(order == 2)
        {
            System.out.print("Enter customer ID");
            int login2 = scanner.nextInt();
            for(int i = 0; i<customer.length; i++)
            {
                if(customer[i].getID() == login2)
                {
                    System.out.println(customer[i]);
                }
            }
        }       
    }
    
    public void Registration()
    {
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = false;
        int count = 0;
        while(shouldContinue == false)
        {
            String fName,lName, email, phNum, street, city, state, country; 
            int age, posCode, custID;
            char gender;
            
            System.out.println("Customer Information");
            System.out.println("=======================");
            System.out.print("Enter first name: ");
            fName = scanner.nextLine();
            System.out.print("Enter last name: ");
            lName = scanner.nextLine();
            System.out.print("Enter ID number (12 digits): ");
            custID = scanner.nextInt();
            System.out.print("Enter age: ");
            age = scanner.nextInt();
            System.out.print("Enter gender M(ale)/F(emale): ");
            gender =  scanner.next().charAt(0);
            System.out.print("Enter email address: ");
            email = scanner.nextLine();
            System.out.print("Enter phone number: ");
            phNum = scanner.nextLine();
            System.out.print("Enter street address: ");
            street = scanner.nextLine();
            System.out.print("Enter city address: ");
            city = scanner.nextLine();
            System.out.print("Enter state address: ");
            state = scanner.nextLine();
            System.out.print("Enter poscode address: ");
            posCode = scanner.nextInt();
            System.out.print("Enter country address: ");
            country = scanner.nextLine();

            System.out.print("Confirm to Register? 1.YES 2.NO 3.QUIT REGISTRATION (Select in digit): ");
            int confirm = scanner.nextInt();
            if(confirm == 1)
            {
                boolean result = Validation.validation(fName, lName, custID, age, gender, email, phNum, street, city, state, posCode, country);
                if (result == true)
                {
                    System.out.print("Registration Success");
                    customer[custNum] = new Customer(custID, fName, lName, age, gender, email, phNum, street, city, state, posCode, country, "NULL", "NULL", 0, "NULL", "NULL","NULL","NULL",0);
                    custCount++;
                    displayOrder();
                }
                else
                {
                    System.out.print("Invalid pattern. Please try again.");
                    shouldContinue = false;
                }
            }
            else if (confirm == 2)
                shouldContinue = false;
            else
                break;
        }
    }
    
    public void Ticket(int login)
    {
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = false, shouldContinue1 = false, shouldContinue2 = false, shouldContinue3 = false;
        int quit, quantityConfirm;
        String ticketChoice;
        
        while(shouldContinue == false)
        {
            for(int i= 0; i < customer.length ; i++)
            {
                if(customer[i].getID() != login)
                {
                    System.out.println("Invalid customer ID. Have created account?");
                    System.out.print("1.YES,try again 2.NO,register now 3.Quit ordering (Enter in Digit): ");
                    int register = scanner.nextInt();
                    if(register == 1)
                    {
                        shouldContinue = false;
                    }
                    else if(register == 2)
                    {
                        Registration();
                    }
                    else
                    {
                        displayOrder(); 
                    }
                }
                else
                {
                    while(shouldContinue1 == false)
                    {
                        System.out.println("Purchase Ticket");
                        System.out.println("==================");
                        System.out.print("Enter which pacakage would you like to buy");

                        //package

                        System.out.print("Choose a number of the Ticket type 1.Classic 2.Premium: "); 
                        int type = scanner.nextInt();
                        if(type != 1 && type != 2)
                        {
                            System.out.print("Are you sure to cancel order? 1.YES 2.NO (Select in digit):");
                            quit = scanner.nextInt();
                            if(quit == 2)
                                shouldContinue1 = false;
                            else
                                displayOrder();
                        }
                        else
                        {
                            if(type==1)
                            {
                                ticketChoice = "Classic";
                                customer[custCount].setTicketType(ticketChoice);
                            }
                            else if(type==2)
                            {
                                ticketChoice = "Premium";
                                customer[custCount].setTicketType(ticketChoice);
                            }
                        }
                        while(shouldContinue2 == false)
                        {
                            System.out.print("Enter ticket quantity: ");
                            int quantity = scanner.nextInt();

                            if(quantity > 1000)
                            {
                                System.out.print("You have exceed the order ticket limit");
                                shouldContinue2 = false;
                            }
                            else if(!Character.isDigit(quantity))
                            {
                                System.out.print("Do you want to cancel order? 1.YES 2.NO (Select in digit):");
                                quit = scanner.nextInt();
                                if(quit == 2)
                                    shouldContinue2 = false;
                                else
                                    displayOrder();
                            }
                            else
                            {
                                quantityConfirm = quantity;
                                customer[custCount].setQuantity(quantityConfirm);
                            }
                        }
                        while (shouldContinue3 == false)
                        {
                            System.out.print("Ticket Day Pass: ");
                            int ticketpass = scanner.nextInt();
                            if(!Character.isDigit(quantity) || ticketpass > 31)
                            {
                                System.out.println("----- Invalid value! / TiceketPass limit to 31 days only -----");
                                System.out.print("Select a digit to (1.Enter again 2.Edit Previous 3.Quit) : ");
                                quit = scanner.nextInt();
                                if(quit == 2)
                                    shouldContinue2 = false;
                                else
                                    displayOrder();
                            }
                            LocalDate checkin = LocalDate.now();
                            LocalDateTime myDateObj = LocalDateTime.now(); 
                            System.out.println("Checked-in : " + checkin + "\t\t " + "Ticket Time-in: " + myDateObj);
                            
                            LocalDate checkout =  LocalDate.now().plusDays(ticketpass);
                            System.out.println("Check-out : " + checkout + "\t\t" + "Ticket Time-out: " + myDateObj.plus(ticketpass, ChronoUnit.HOURS)); 
                        }
                    }
                    customer[custCount]= new Customer(customer[i].getID(), customer[i].getfName(), customer[i].getlName(), 
                            customer[i].getAge(), customer[i].getGender(), customer[i].getEmail(), customer[i].getPhNum(), 
                            customer[i].getStreet(), customer[i].getCity(), customer[i].getState(), getPosCode(), customer[i].getCountry(),
                            "NULL", customer[custCount].getTicketType(), customer[custCount].getQuantity(), "NULL", "NULL","NULL","NULL",0);
                }                
            }
        }
    }
    
    public static void Payment(){
        
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = false;
        boolean validatePayment = false;
        while(shouldContinue == false)
        {
            System.out.print("Enter customer payment type 1.CASH 2.CARD (Enter either 1 digit): ");
            int paymentType = scanner.nextInt();
            if(paymentType != 1 && paymentType != 2){
                System.out.print("Invalid number. Please try again.");
                shouldContinue = false;
            }
            else if(paymentType == '2')
            {
                System.out.print("Enter customer card number: ");
                String cardNo = scanner.nextLine();
                validatePayment = Validation.cardValidation(cardNo);
                if(validatePayment == false)
                {
                    System.out.print("Card Number is invalid");
                    shouldContinue = false;
                }
            }
        }        
    }
    

    
    @Override
    public String toString() {
        return super.toString() +
                "ticketID=" + ticketID + '\n' + 
                "ticketType=" + ticketType + '\n' + 
                "quantity=" + quantity + '\n' + 
                "date=" + date + '\n' + 
                "timeIN=" + timeIN + '\n' + 
                "timeOUT=" + timeOUT + '\n' + 
                "paymentType=" + paymentType + '\n' + 
                "cardNum=" + cardNum + + '\n';
    }
}
    

