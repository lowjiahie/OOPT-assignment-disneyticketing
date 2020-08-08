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

public class Supplier extends Personal_info{
    private Product [] p;
    static int count = 0;
    private String joinDate;

    public Supplier(int id, String fName, String lName, int age, char gender, String phNum, String email,Product p, String joinDate, String street, String city, String state, int posCode, String country) {
        super( id, fName, lName, phNum, age, gender, email, street, city, state, posCode, country);
        this.p [count]= p;
        this.joinDate = joinDate;
        count++;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getJoinDate() {
        return joinDate;
    }
    
    public static void addProduct(){
        Scanner scan = new Scanner(System.in);
        
        //prompt and read
        System.out.println("Enter product id > ");
        int id = scan.nextInt();  
        System.out.println("Enter product name > ");
        String name = scan.nextLine();
        System.out.println("Enter product description > ");
        String description = scan.nextLine();
        System.out.println("Enter product quantity > ");
        int qty = scan.nextInt();
        System.out.println("Enter product price > ");
        double price = scan.nextDouble();
        
        p[count] = new Product(id,name,description,qty,price);
        
        
    } 
   
    
}
