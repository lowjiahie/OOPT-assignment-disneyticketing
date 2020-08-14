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

    public Personal_info(int id, String fName, String lName, String phNum, int age, char gender, String email) {
        super();
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
    
    // either make separate all validation or make it as "personal_info_validation()"
    public static boolean validateID(int id, String fName, String lName, String phNum, int age, char gender, String email)
    {
        String pattern2 = "\\\\d{12}|(?:\\\\d{6}-){2}\\\\d{4}";
        String pattern3 = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        String pattern4 = "^[\\w-\\.+]*[\\w-\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        char genderV= Character.toUpperCase(gender);
        if(fName.length() > 1 && lName.length() > 1)
        {
            return true;
        }
        else if(id.matches(pattern2)) //id, this statement should be improve
        {
            return true;
        }
        else if(Character.isDigit(age) && age < 130 && age >= 0) //age
        {
            return true;
        }
        else if(genderV == 'F'||genderV == 'f'||genderV == 'M'||genderV == 'm') //gender
        {
            return true;
        }
        else if (email.matches(pattern4)) //email
        {
            return true;
        }
        else if(phNum.matches(pattern3)) //phone
        {
            return true;
        }
        
        return false;
    }

}