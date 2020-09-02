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
    public Package() {
    }
    

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

    public String toString() {
        return "ID : " + id + "\n" + 
                "Title : " + title + "\n" + 
                "Normal Price : " + normalPrice + "\n" + 
                "Premium Price : " + premiumPrice + "\n" +
                "Party : " + party + "\n";
    }
    
    
}