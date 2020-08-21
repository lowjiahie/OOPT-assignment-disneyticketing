


public class Staff extends Personal_info{
    private String password;
    private int securityCode;
    private String post;
    private String jobDesc;
    private static int idCount= 5001;

    public Staff(int id,String fName, String lName, String phNum, int age, char gender, String email,String street, String city, String state, int posCode, String country, String password, int securityCode, String post, String jobDesc) {
            super(id, fName, lName, phNum, age, gender, email, street, city, state, posCode, country);
            this.password = password;
            this.securityCode = securityCode;
            this.post = post;
            this.jobDesc = jobDesc;
            idCount++;
    }

    public String getPassword() {
        return password;
    }
    public int getSecurityCode() {
    	return securityCode;
    }
    public String getPost() {
    	return post;
    }
    public String getJobDesc() {
    	return jobDesc;
    }
    public static int getIdCount() {
    	return idCount;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    public void setSecurityCode(int securityCode) {
    	this.securityCode = securityCode;
    }
    public void setPost(String post) {
    	this.post = post;
    }
    public void setJobDesc(String jobDesc) {
    	this.jobDesc = jobDesc;
    }
    
    public static boolean resetSecurityCode(int id, Staff[] s, int securityCode, int newCode) {
    	int error = 0;
    	
    	for(int i=0;i<s.length;i++){
    		if (s[i].getID()!= id){
    			error++;
    		} else {
    			if (s[i].securityCode != securityCode) {
    				error++;
    			} else {
    				s[i].setSecurityCode(newCode);
    				error=0;
    				break;
    			}
    		}
    	}
    	if (error > 0){
    		return false;
    	}else {
    		return true;
    	}
    	
    }
    
    public static boolean validateSecurityCode(int securityCode){ //securityCode cannot start from 0
    	int error = 0;
    	int code = securityCode;
    	int countDigit = 0;
    	
    	while (countDigit > 0){
    		securityCode /= 10;
    		countDigit++;
    	}
    	
    	if(countDigit <= 8){
    		return false;
    	}else {
    		return true;
    	}
    }
    
    public static boolean validatePassword(String password){
    	int error = 0;
    	int countDigit = 0;
    	int countLetter = 0;
    	
    	if(password.length() <= 6){
    		error++;
    	} else {
    		for (int i=0; i<password.length(); i++){
    			if(Character.isLetter(password.charAt(i))){
    				countLetter++;
    			}
    			if(Character.isDigit(password.charAt(i))){
    				countDigit++;
    			}
    		}
    		
    		if (countLetter < 1 || countDigit < 1){
    			error++;
    		}else {
    			for(int i=0; i<password.length(); i++){
			    	if (!Character.isLetter(password.charAt(i)) && !Character.isDigit(password.charAt(i))){
			    		error++;
			    	}else {
			    		error=0;
			    	}
		   		}
    		}
    	}
    	
    	if(error != 0){
    		return false;
    	}else {
    		return true;
    	}
    }
    
    public static boolean resetPassword(int id, Staff[] s, int securityCode, String password, String newPassword) {
    	int error = 0;
    	for(int i=0;i<s.length;i++){
    		if (s[i].getID() != id){
    			error++;
    		} else {
    			if (s[i].securityCode != securityCode) {
    				error++;
    			} else {
    				if (s[i].password != password ) {
    					error++;
    				} else {
    					s[i].setPassword(newPassword);
    					error = 0;
    					break;
    				}
    			}
    		}
    	}
    	if (error > 0){
    		return false;
    	}else {
    		return true;
    	}
    }
    public void staffDetails() {
    	System.out.printf("%8d %20s %10d %2d %c %25s %15s %30s", getID(), getfName()+getlName(), getPhNum(), getAge(), getGender(), getEmail(), post, jobDesc);
    }
    
    
}