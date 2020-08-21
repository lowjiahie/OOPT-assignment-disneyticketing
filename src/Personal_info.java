/**
 * @(#)Personal_info.java
 *
 *
 * @author 
 * @version 1.00 2020/8/8
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
    
   
    public void setID(int id) {
            this.id = id;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public void setlName(String lName) {
        
        this.lName = lName;
    }
    public void setPhNum(String phoneNum) {
        this.phNum = phNum;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getID() {
        return id;
    }
    public String getfName() {
        return fName;
    }
    public String getlName() {
        return lName;
    }
    public String getPhNum() {
        return phNum;
    }
    public int getAge() {
        return age;
    }
    public char getGender() {
        return gender;
    }    
    public String getEmail() {
        return email;
    }
    
   
    public String toString() {
        return "ID : " + id + "\n" +
               "First Name : " + fName + "\n" +
               "Last Name : " + lName + "\n" +
               "Phone Number : " + phNum + "\n" +
               "Age : " + age + "\n" +
               "Gender : " + gender + "\n"+
               "Email : " + email + "\n";
    }

}