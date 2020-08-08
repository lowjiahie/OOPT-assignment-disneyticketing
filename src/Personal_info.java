/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin-jiahie
 */

public class Personal_info extends Address{
    private int id;
    private String fName;
    private String lName;
    private String phNum;
    private int age;
    private char gender;
    private String email;

    public Personal_info(int id, String fName, String lName, String phNum, int age, char gender, String email, String street, String city, String state, int posCode, String country) {
        super(street, city, state, posCode, country);
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.phNum = phNum;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }
    
   

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }
    
    public String getlName() {
        return lName;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public int getID() {
        return id;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }    
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setPhNum(String phoneNum) {
        this.phNum = phNum;
    }
    
    public String getPhNum() {
        return phNum;
    }

    
    public static boolean validateID(Personal_info cust)
    {
        String pattern2 = "\\\\d{12}|(?:\\\\d{6}-){2}\\\\d{4}";
        String pattern3 = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        String pattern4 = "^[\\w-\\.+]*[\\w-\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        char genderV = cust.gender.toUpperCase();
        if(cust.fName.length() > 1 && cust.lName.length() > 1)
        {
            return true;
        }
        else if(cust.custID.matches(pattern2)) //id
        {
            return true;
        }
        else if(Character.isDigit(cust.age) && cust.age < 130 && cust.age >= 0) //age
        {
            return true;
        }
        else if(genderV == "F"||genderV == "FEMALE"||genderV == "M"||genderV == "MALE") //gender
        {
            return true;
        }
        else if (cust.email.matches(pattern4)) //email
        {
            return true;
        }
        else if(cust.phoneNum.matches(pattern3)) //phone
        {
            return true;
        }
        
        return false;
    }

    
    
}
