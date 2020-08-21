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
     public static boolean validation(String fName, String lName, int custID, int age, char gender, String email, String phNum, String street, String city, String state, int posCode, String country)
    {
        String pattern3 = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        String pattern4 = "^[\\w-\\.+]*[\\w-\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        char genderV= Character.toUpperCase(gender);
        
        if(fName.length() <= 1 && lName.length() <= 1)
        {
            return false;
        }
        else if(!Character.isDigit(custID))
        {
            return false;
        }
        else if(!Character.isDigit(age) && age > 130 && age < 0) //age
        {
            return false;
        }
        else if(genderV != 'F'||genderV != 'f'||genderV != 'M'||genderV != 'm') //gender
        {
            return false;
        }
        else if (!email.matches(pattern4) && !phNum.matches(pattern3)) //email
        {
            return false;
        }
        else if(!Character.isDigit(posCode) && posCode != 5) //phone
        {
            return false;
        }
        else if(street.length() > 85 && city.length() > 85 && state.length() > 85 && country.length() > 56) //phone
        {
            return false;
        }
        
        return true;
    }
    
    public static boolean cardValidation(String cardNo)
    {
        int[] ints = new int[cardNo.length()];
        for (int i = 0; i < cardNo.length(); i++) {
            ints[i] = Integer.parseInt(cardNo.substring(i, i + 1));
        }
        for (int i = ints.length - 2; i >= 0; i = i - 2) {
            int j = ints[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            ints[i] = j;
        }
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        if (sum % 10 != 0) {
            return false;
        }
        return true;
    }
}
