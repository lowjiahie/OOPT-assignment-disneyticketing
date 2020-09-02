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
    
