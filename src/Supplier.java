/**
 * @(#)Supplier.java
 *
 *
 * @author 
 * @version 1.00 2020/8/8
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Supplier extends Person{
    private static Scanner scan = new Scanner(System.in);
    private static Scanner get = new Scanner(System.in);
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
    
    
    public static void addSupplier (){
        
        char ask;
        
        System.out.print("\nDo you want to add supplier (Y/N) > ");
        ask = get.nextLine().charAt(0);
        System.out.println();
        if(Character.toUpperCase(ask) == 'Y'){

            Person p = addPerson(suppIdCount);
            System.out.print("\nComfirm to add ?(Y/N) >");
            ask = get.nextLine().charAt(0);

            if(Character.toUpperCase(ask) == 'Y'){
                supplier.add(new Supplier(p));
                suppIdCount++;
                System.out.println("Supplier added !\n");
            }else{
                System.out.println("Failed added !\n");
            }

        } 
        
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
    
    public static void editSupplier(){
        boolean isSupp = false;
        int sel=3;
        Supplier selectedSupp = new Supplier();
        
        do{
            int id = Validation.read_int(scan, "\nEnter Supplier ID > ");

            for(int i = 0; i<supplier.size(); i++){
                if (supplier.get(i).getID() == id){
                    isSupp = true;
                    selectedSupp = supplier.get(i);
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
    
    public static void suppList(){
        boolean checkID=false;
        int sel=3;
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
                    for(int i =0; i<supplier.size();i++){
                        System.out.println(supplier.get(i));
                    }
                    break;
                case 2:
                        int suppID = Validation.read_int(scan, "Enter your Supplier ID > ");
                        
                        for(int i=0; i<supplier.size();i++){
                            if(supplier.get(i).getID()==suppID){
                                Supplier selectedSupp = supplier.get(i);
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
    
    public static void prodList(){
        boolean checkID=false;
        int sel=4;
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
                        
                
                        for(int i=0; i<supplier.size();i++){
                            if(supplier.get(i).getID()==suppID){
                                Supplier selectedSupp = supplier.get(i);
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

   
    public String toString() {
        
        return  super.toString() +   
                "Join Date : " + joinDate + "\n\n";
    }

   
}