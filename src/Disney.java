/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin-jiahie
 */
import java.util.Scanner;
public class Disney {

    public static void main (String [] args) {
    	int staffId;
    	String password;
    	Staff [] staffArr = {new Staff(5001, "Ng", "Jing Chong", "010-282 6133", 19, "M", "ngjingchong@gmail.com", "Jalan 14/155c", "Bukit Jalil", "Kuala Lumpur", 57000, "Malaysia", "Jc101255", 010207, "Admin", "has higher accessibility to every thing"),
    			     new Staff(5002, "Puah", "Hsien Jian", "012-345 6789", 21, "M", "puahhj@gmail.com", "Jalan meru", "Cheras", "Kuala Lumpur", 58200, "Malaysia", "Hj123456", 123456, "Cashier", "Collect money from customer")};
    	Customer [] custArr = {new Customer(), new Customer()};
    	Supplier [] supplierArr = {new Supplier(7001, "Khor", "Wen Xin", "987-456 1230", 19, "F", "khorwx@gmail.com", String joinDate, String street, String city, String state, int posCode, String country), 
    				   new Supplier(7002)};
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.printf("Enter Staff ID > ");
    	staffId = scan.nextInt();
    	
    	System.out.printf("Enter Password > ");
    	password = scan.nextLine();
    }
    
    
}