/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Forge-15
 */
import java.util.*;
public class Package {
    
    private int id;
    private String title;
    private String [] zone = new String[5];
    private double normalPrice;
    private double premiumPrice;
    private int party;
    private static int countID = 9001; 
    static Scanner scan = new Scanner(System.in);
    static Scanner get = new Scanner(System.in);
    

    public Package(int id, String title, String [] zone, double normalPrice, double premiumPrice, int party) {
        
        this.id = id;
        this.title = title;
        this.zone = zone;
        this.normalPrice = normalPrice;
        this.premiumPrice = premiumPrice;
        this.party = party;
        countID++;
    }
    
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String [] getZone() {
        return zone;
    }
    public double getNormalPrice() {
        return normalPrice;
    }
    public double getPremiumPrice() {
        return premiumPrice;
    }
    public int getParty() {
        return party;
    }
    public static int getCountID() {
        return countID;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public void setZone(String [] zone) {
        this.zone = zone;
    }
    public void setNormalPrice(double normalPrice) {
        this.normalPrice = normalPrice;
    }
    public void setPremiumPrice(double premiumPrice) {
        this.premiumPrice = premiumPrice;
    }
    public void setParty(int party) {
        this.party = party;
    }

  
    public static double [] promotion(int id, Package[]p, int rate){
        
        double [] lastest_Price = new double[2];
        int error = 0;
       
        if(id!=4 && !Character.isDigit(id)){
            error++;
        }else{
            
            for(int i=0; i<p.length; i++){
                
                if(p[i].getId() != id){
                    error++;
                }else{
                    lastest_Price[0] = p[i].getNormalPrice() * rate;
                    lastest_Price[1] = p[i].getPremiumPrice() * rate;
                    
                    error = 0;
  
                }
            }
        }
        
        if(error > 0){
            System.out.println("Invalid ID");
            return lastest_Price;
        }else{
            return lastest_Price;
        }
        
    }
    
    
    public static boolean delete(int id, Package [] p){
        
        int error = 0;
        
        if(id!=4 && !Character.isDigit(id)){
            error++;
        }else{
            
            for(int i=0; i<p.length; i++){
                
                if(p[i].getId() != id){
                    error++;
                }else{
                   for(int l=0; l<p.length-1; l++){
                       
                       if(l==i){
                           p[l] = p[++i];
                           error = 0;
                       }
                   }

                }
            }
        }
        
        if(error > 0){
            return false;
        }else{
            return true;
        }
    }
    
    public static boolean update(int id, Package [] p){
        Scanner scan = new Scanner(System.in);
        int error = 0;
        
        if(id!=4 && !Character.isDigit(id)){
            error++;
        }else{
            
            for(int i=0; i<p.length; i++){
                
                if(p[i].getId() != id){
                    error++;
                }else{
                    int l = 0;
                    String [] zone = new String[5];
                    char ask;
                    
                    System.out.println(p[i].toString());
                    
                    do{
                        System.out.print("Enter Package Title > ");
                        String title = scan.nextLine();
                        do{
                            System.out.print("Enter zone > ");
                            zone [l] = scan.nextLine();

                            System.out.print("Add more zone? (Yes=Y,No=N) > ");
                            ask = scan.nextLine().charAt(0);

                            l++;
                        }while(Character.toUpperCase(ask) == 'Y');
                        System.out.print("Enter normal price > ");
                        double normalPrice = scan.nextDouble();
                        System.out.print("Enter premium price > ");
                        double premiumPrice = scan.nextDouble();
                        System.out.print("Enter party > ");
                        int party = scan.nextInt();

                        System.out.print("Package Title : " + title);
                        for(int j=0; j<zone.length; j++){
                            System.out.print("Package Title : " + zone[j]);
                        }
                        System.out.print("Normal Price : " + normalPrice);
                        System.out.print("Normal Price : " + premiumPrice);
                        System.out.print("Party : " + party); 

                        System.out.print("Do you want to update (Yes='Y',editAgain='N') > ");
                        ask = scan.nextLine().charAt(0);
                        if(ask == 'Y'){
                            p[i].setTitle(title);
                            p[i].setZone(zone);
                            p[i].setNormalPrice(normalPrice);
                            p[i].setPremiumPrice(premiumPrice);
                            p[i].setParty(party);
                        }
                        
                    }while(ask == 'N');
                    error=0;
                }
            }
        }
 
        if(error > 0){
            return false;
        }else{
            return true;
        }
    }

   
    public String toString() {
        return "ID : " + id + "\n" + 
                "Title : " + title + "\n" + 
                "Normal Price : " + normalPrice + "\n" + 
                "Premium Price : " + premiumPrice + "\n" +
                "Party : " + party + "\n";
    }
    
    public static ArrayList<Package> addPackage(ArrayList<Package> pk){
        ArrayList<Package> temp = pk;
        char confirm;
        
        int exist = 0;
        int id;
        String title;
        String []zone = new String[5];
        double normalPrice;
        double premiumPrice;
        int party;
        
        //ArrayList<Package> pk = new ArrayList<Package>();

//        System.out.println("Enter the title to check: ");
//        title=scan.nextLine();
        
        do{
            if (exist != 0){
                System.out.println("ID entered already Exist !");
                System.out.println();
            }
            System.out.println("Please add the Pacakge ID: ");
            id = get.nextInt();
            
            for(Package pp : temp){
                if(pp.getId() == id){
                    exist ++;
                    break;
                    
                }else {
                    exist=0;
                    
                    
                }
            }
        }while (exist != 0);
            
            System.out.println("Please add the title: ");
            title = scan.nextLine();
            
            for(int i=0; i<zone.length;i++)
            {
                System.out.println("Please add the zone: ");
                zone[i] = scan.nextLine();
            }
            
            
            
            System.out.println("Please add the normalPrice: ");
            normalPrice = scan.nextDouble();
            
            
            System.out.println("Please add the premiumPrice: ");
            premiumPrice = scan.nextDouble();
            
            
            System.out.println("Please add the party price: ");
            party = scan.nextInt();
            scan.nextLine();
            
            System.out.println("Are you confrim to add? (Y/N) : ");
            confirm = scan.nextLine().toUpperCase().charAt(0);
            
            for (Package p:pk){
                if(p.getId() == id){
                    System.out.println("Package exist");
                }else {
                    if(confirm == 'Y'){
                        temp.add(new Package(id,title,zone,normalPrice,premiumPrice,party));
                        System.out.println("Successful");
                        break;
                    }else{
                        System.out.println("No Package added");
                        break;
                    }
                }
            }
            

//            }else{
//                System.out.println("Package exist");
//            }  
//        }
        return temp;
    }
    
    public static ArrayList<Package> editPackage(ArrayList<Package> pk){
        ArrayList<Package> temp = pk;
        char confirm;
        String title;
        String []zone = new String[5];
        double normalPrice;
        double premiumPrice;
        int party;
        
        int error=0;
        
        System.out.println("Enter Package ID to modify : ");
        int id = get.nextInt();
        
        for(Package p : temp){ 
            
            if (id == p.getId()){
                error=0;
                System.out.println("Package ID : " + p.getId());
                System.out.println("Please add the title: " + p.getTitle());
                for(int i=0; i<p.zone.length; i++){
                    if(!p.zone[i].equals("0") && !p.zone[i].equals(0))
                        System.out.println("Zone : " + p.zone[i] ); 
                    else 
                        break;
                }
                System.out.println("Please add the normalPrice: " + p.getNormalPrice());
                System.out.println("Please add the premiumPrice: " + p.getPremiumPrice());
                System.out.println("Please add the party price: " + p.getParty());


                System.out.println("T = Title" + "\n" + "Z = Zone" + "\n"
                                    + "N = Normal Price" + "\n" + 
                                    "P = Premium Price" + "\n" + "A = Party");
                System.out.println("Which information you want to edit? (T/Z/N/P/A)");
                confirm = scan.nextLine().toUpperCase().charAt(0);
                scan.nextLine();
                if (confirm == 'T'){
                    System.out.println("Current title is : " + p.getTitle());
                    System.out.println("Please enter the new title : ");
                    title = scan.nextLine();
                    p.setTitle(title);

                }else if (confirm == 'Z'){
                    String [] tempZone = p.getZone();
                    for(int i=0; i<tempZone.length; i++){
                        System.out.println("Current zone is " + tempZone[i]);
                        System.out.println("Please enter the new zone:");
                        zone[i] = scan.nextLine();
                    }
                    p.setZone(zone);
             
                }else if(confirm == 'N'){
                    System.out.println("Current normal price is : " + p.getNormalPrice());
                    System.out.println("Please enter the new normal price :");
                    normalPrice = get.nextDouble();
                    p.setNormalPrice(normalPrice);

                }else if (confirm == 'P'){
                    System.out.println("Current premium price is : " + p.getPremiumPrice());
                    System.out.println("Please enter the new normal price :");
                    premiumPrice = get.nextDouble();
                    p.setPremiumPrice(premiumPrice);

                }else if (confirm == 'A'){
                    System.out.println("Current party price is : " + p.getParty());
                    System.out.println("Please enter the new normal price :");
                    party = get.nextInt();
                    p.setParty(party);

                }else{
                    System.out.println("Invalid character");
                    System.out.println("");
                    System.out.println("Please key in T/Z/N/P/A");
                }
                break;
            } else {
                error++;
            }

            
        }
        
        if(error > 0){
            System.out.println("Package ID entered invalid");
        }else{
            System.out.println("Successfully modified !");
        }
        return temp;
    }
    
    public static ArrayList<Package> deletePackage(ArrayList<Package> pk){
        ArrayList<Package> temp = pk;
        int confirm;
        boolean check = false;
        System.out.println("Please enter the package id to delete: " );
        confirm = get.nextInt();
            
        for(Package p : pk){
            if(confirm == p.getId()){
                temp.remove(p);
                check = true;
                break;
            }else{
                check = false;
            }
            
        }
        
        if(!check){
            System.out.println("Please enter the valid package id to delete: ");
        }else{
            System.out.println("Successfully delete!!!!");
        }
        
        return temp;
    }
    
    public static void packageDisplay(ArrayList<Package> pk){
        for(Package temp : pk){
           
                String[] tempZone = temp.getZone();
                for(int i=0; i<tempZone.length; i++){
                    if(tempZone[i] != null && !tempZone[i].equals("0"))
                        System.out.println("Zone : " + tempZone[i] ); 
                    else 
                        break;
                }
          
            System.out.println(temp.toString());
        }
    }
    
    
}


/*
3.Package
//-zone included 
//-prices 
//*accessing area
//*special function
//promotion
//date & time 

Zone 
-amusement park
-water park 
-scream park 
-x park 
-wildlife park

price
-annual pass  rm 310/person
-2days fun pass 220 include hotel 
-group pass 450(4 peopple )
-individual 120

accessing area
-annual pass allow to access all area exclude X park 
-2 days fun pass able to access all park exclude X park and scream park

group pass 
-all park exclude X park 

individual 
-access all area , exlcude X park 

promotion 
-birthday special 
-express lane

----------------------------------------------------------------------

Package A  rm 310
-annual pass 
-can access all park exclude X park 

Package B rm 220
-2days 1 night , fun pass 
-free night dinning in hotel 
-

Package C  RM450 (4people )
- group pass
-all park exclude X park 

Package D  individual 120
--access all area , exlcude X park 

accessing X park , + rm 60 / person






*/