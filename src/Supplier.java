/**
 * @(#)Supplier.java
 *
 *
 * @author 
 * @version 1.00 2020/8/8
 */

import java.util.ArrayList;
import java.util.Date;

public class Supplier extends Person{
    private static ArrayList<Supplier> supplier = new ArrayList<Supplier>();
    private ArrayList <Product> suppProdList = new ArrayList <Product>(); 
    private static int suppIdCount=7003;
    private Date joinDate;
    
    public Supplier(){
        super();
    }
    
    public Supplier(Person p) {
        super(p.getID(), p.getfName(), p.getlName(),p.getPhNum(),p.getAge(),p.getGender(),p.getEmail(),p.getStreet(), p.getCity(), p.getState(), 
                p.getPosCode(), p.getCountry());
        this.joinDate = new Date();
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public ArrayList<Product> getSuppProdList() {
        return suppProdList;
    }

    public static void setSupplier(ArrayList<Supplier> supplier) {
        Supplier.supplier = supplier;
    }
    
    public static ArrayList<Supplier> getSupplier() {
        return supplier;
    }

    public static int getSuppIdCount() {
        return suppIdCount;
    }
    
    public String toString() {
        
        return  super.toString() +   
                "Join Date : " + joinDate + "\n\n";
    }

   
}