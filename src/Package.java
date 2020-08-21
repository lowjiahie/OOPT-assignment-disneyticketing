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
               "Title :" + title + "\n" +
               "Zone : " + zone + "\n" + 
               "Normal Price : " + normalPrice + "\n" + 
               "Premium Price : " + premiumPrice + "\n" +
               "Party : " + party + "\n";
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