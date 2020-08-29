import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

public class Customer extends Person
{  
    private int ticketID;
    private String ticketType;
    private String packet;
    private int quantity; 
    private int pass;
    private String orderDate;
    private String paymentType; 
    private String cardNum;
    private double total;
 
    public Customer (){
        super();
    }
    public Customer(Person p, String ticketType, String packet, int ticketID, int quantity, String orderDate, int pass, String paymentType, String cardNum, double total) {
        super(p.getID(), p.getfName(), p.getlName(), p.getPhNum(), p.getAge(), p.getGender(), p.getEmail(), p.getStreet(), p.getCity(), p.getState(), p.getPosCode(), p.getCountry());
        this.ticketType = ticketType;
        this.packet = packet;
        this.ticketID = ticketID;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.pass = pass;
        this.paymentType = paymentType;
        this.cardNum = cardNum;
        this.total = total;
    }

    public int getTicketID() {
        return ticketID;
    }
    public String getTicketType() {
        return ticketType;
    }
    public String getPacket() {
        return packet;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public int getPass() {
        return pass;
    }
    public String getPaymentType() {
        return paymentType;
    }
    public String getCardNum() {
        return cardNum;
    }
    public double getTotal() {
        return total;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    public void setPacket(String packet) {
        this.packet = packet;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public void setPass(int pass) {
        this.pass = pass;
    }
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    
    public static boolean expireValidation(int month, int year){ //ERROR
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
       Scanner scan = new Scanner(System.in);

       int count = cust.size() + 1;
       int id = 3000 + count;
       boolean success = false;
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
            success = true;
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
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Customer ID > ");
        customerID = scan.nextInt();     
        
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
        
        Scanner scan = new Scanner(System.in);
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
                    for(Package p : tempPk){
                        System.out.println("Package : " +  p.getTitle());
                        System.out.println("Normal Price : RM " +  p.getNormalPrice());
                        System.out.println("Premium Price : RM " +  p.getPremiumPrice() + "\n");
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
                                    System.out.print("Choose a number of the Ticket type 1.Classic 2.Premium > "); 
                                    int type = scan.nextInt();
                                    switch(type)
                                    {
                                        case 1:
                                            while(shouldContinue2 == false)
                                            {
                                                System.out.print("Enter ticket quantity > ");
                                                quantityOrder = scan.nextInt();
                                                if(quantityOrder > 1000 && !Character.isDigit(quantityOrder))
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
                                                            DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");  
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
                                                            DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");  
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
           System.out.print("\n***** NO RECORDS *****\n");
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
        
        Scanner scan = new Scanner(System.in);
        boolean again = false;
        boolean editresult1 = false, editresult2 = false, editresult3 = false, editresult4 = false;
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
                    char edit = scan.next().charAt(0);
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
                                        System.out.println("Premium Price : RM " +  p.getPremiumPrice() + "\n");
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
                                                confirmation = scan.next().charAt(0);
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
                                    System.out.print("\nEdit Ticket Type ( 1.Classic | 2.Premium ) > ");
                                    int type = scan.nextInt();
                                    switch(type)
                                    {
                                        case 1 :

                                            System.out.printf("Confirm Changes (Y=yes | N=no) > ");
                                            confirmation = scan.next().charAt(0);
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
                                            confirmation = scan.next().charAt(0);
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
                                        default:
                                            System.out.println("\n ------- Invalid Input Value either 1 or 2 -------");
                                            break;
                                    }
                                    break;
                                case 3:
                                    System.out.print("\nEdit Quantity > ");
                                    int quantity = scan.nextInt();
                                    if(quantity > 1000 && !Character.isDigit(quantity))
                                    {
                                        System.out.println("\n You have exceed the limit quantity / Invalid input");
                                        //break;
                                    }
                                    else
                                    {
                                        System.out.println("From " + c.getQuantity() + " Change to " + quantity);
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

                                    if(!Character.isDigit(editpass) && editpass > 31)
                                    {
                                        System.out.println("\n----- Invalid value! / TiceketPass limit to 31 days only -----");
                                        //break;
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
                        quit = scan.next().charAt(0);
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
                           // again = true;
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
    
    public static ArrayList<Customer> Payment(int custID2, ArrayList<Customer> cust)
    {
        ArrayList<Customer> tempCust = cust;
        
        Customer remember = new Customer();
        int error = 0, paymentType;
        Scanner scan = new Scanner(System.in);
        boolean shouldContinue = false;
        boolean validatePayment = false;
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
                                validateCard = Customer.expireValidation(month, year);
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
    
    public static void customerList(ArrayList<Customer> cust)
    {
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
    
    public String toString() {
        return super.toString() +
            "Ticket ID: " + ticketID + '\n' +
            "Ticket Type: " + ticketType + '\n' +
            "Package: " + packet + '\n' +
            "Ticket Quantity: " + quantity + '\n' +
            "Check In: " + orderDate + '\n' +
            "Ticket Pass: " + pass + '\n' +
            "Payment Type: " + paymentType + '\n' +
            "CardNum: " + cardNum + '\n' +
            "Total Price: " + total + '\n';
    }
}
    
