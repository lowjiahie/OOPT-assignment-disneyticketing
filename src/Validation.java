

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin-jiahie
 */
public class Validation {
 
    
    public static char validateGender(Scanner read,String prompt){
        boolean checkGender = false; 
        char gender = ' ';
        while(!checkGender){
            System.out.print(prompt);
            gender = read.nextLine().charAt(0);
            if(gender == 'F'||gender == 'f'||gender == 'M'||gender == 'm'){
                gender = Character.toUpperCase(gender);
                checkGender = true;
            }else{
                System.out.println("Please input a gender (M=Male||F=Female)!!!!");
                checkGender = false;
            }
        }
        return gender;
    }
    
    public static int read_int(Scanner read, String prompt){
        int checkInt = -1;
        while(checkInt<0){
            
            System.out.print(prompt);
            String input = read.nextLine();
            
            try{
               checkInt = Integer.valueOf(input);
                if(checkInt<0){
                    System.out.println("Invalid Input!!!");
                }
            }catch(NumberFormatException e){
                checkInt=-1;
                System.out.println("Invalid Input!!!");
            }
        }
        
        return checkInt;
    }
    public static double read_double(Scanner read, String prompt){
        double checkDouble = -1;
        while(checkDouble<0){
            
            System.out.print(prompt);
            String input = read.nextLine();
            
            try{
               checkDouble = Double.valueOf(input);
                if(checkDouble<0){
                    System.out.println("Invalid Input!!!");
                }
            }catch(NumberFormatException e){
                checkDouble=-1;
                System.out.println("Invalid Input!!!");
            }
        }
        
        return checkDouble;
    }
}
