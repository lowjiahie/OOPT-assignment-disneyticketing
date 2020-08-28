
import java.util.ArrayList;


public class Product {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private int totalQtyPurchased;  //added to track how much item has been purchased from this supplier
    private double price;
    private static int productCount= 1005;
    private static ArrayList<Product> prodList = new ArrayList<Product>();
    
    public Product(int id, String name, String description, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.totalQtyPurchased =quantity;
        this.price = price;

    }

    public static void setProdList(ArrayList<Product> prodList) {
        Product.prodList = prodList;
    }

    public static ArrayList<Product> getProdList() {
        return prodList;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getTotalQtyPurchased() {
            return totalQtyPurchased;
    }
    public double getPrice() {
        return price;
    }
    public static int getProductCount() {
        return productCount;
    }
    
    public double subtotal () {
    	double subtotal = 0;
    	
    	subtotal = this.price*this.totalQtyPurchased;
    	
    	return subtotal;
    }
    
    public void restock(int quantity){

        this.quantity = quantity;
        
    	this.totalQtyPurchased += this.quantity;
    }
    
    public static boolean prodList(int id){
        boolean checkID=false;
        for(int i = 0; i<prodList.size(); i++){
            if(prodList.get(i).getId() == id){
                System.out.println(prodList.get(i));
                checkID=true;
                break;
            }else{
                checkID=false;
            }
        }
        
       return checkID;
    } 
    public String toString() {
        return  "Product ID : " + id + "\n" + 
                "Name : " + name + "\n" + 
                "Description : " + description + "\n" + 
                "Quantity : " + quantity + "\n" + 
                "Total Qty Purchased :" + totalQtyPurchased + "\n" + 
                "Price : " + price + "\n";
    }
    
}
