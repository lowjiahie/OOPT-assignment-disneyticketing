
public class Product {
 private int id;
    private String name;
    private String description;
    private int quantity;
    private int totalQtyPurchased;  //added to track how much item has been purchased from this supplier
    private double price;
    private static int productCount= 1001;

    public Product(int id, String name, String description, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.totalQtyPurchased =quantity;
        this.price = price;
        productCount++;
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
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalQtyPurchased += this.quantity;
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
    public void displayDetails(){ 
    	System.out.printf("%8d %20s %30s %3d %6d %6.2lf %4d",id,name,description,quantity,totalQtyPurchased,price,productCount-1000);
    }
}
