
public class Staff extends Person{
    
    private String password;
    private int securityCode; //code cannot be starting with 0
    private String post;
    private String jobDesc;

    public Staff(){
        super();
    }
    
    public Staff(Person p, String password, int securityCode, String post, String jobDesc) {
        super(p.getID(), p.getfName(), p.getlName(), p.getPhNum(), p.getAge(), p.getGender(), p.getEmail(), p.getState(), p.getCity(), p.getState(), p.getPosCode(), p.getCountry());
        this.password = password;
        this.securityCode = securityCode;
        this.post = post;
        this.jobDesc = jobDesc;
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
    
    public String toString() {
    	return super.toString() + 
    			"Password : " +  this.password + "\n" +
    			"Security Code : " +  this.securityCode + "\n" +
    			"Position : " +  this.post + "\n" +
    			"Job Description : " +  this.jobDesc + "\n";
    }
    public static boolean resetSecurityCode(Staff s, int securityCode, int newCode) {
    	int error = 0;
    	
        if (s.getSecurityCode() != securityCode) {
            error++;
        } else {
            s.setSecurityCode(newCode);
            error=0;
        }
            
    	if (error > 0){
    		return false;
    	}else {
    		return true;
    	}
    	
    }
    public static boolean resetPassword(Staff s, int securityCode, String password, String newPassword) {
    	int error = 0;

        if (s.getSecurityCode() != securityCode) {
            error++;
        } else {
            if (!s.getPassword().equals(password) ) {
                    error++;
            } else {
                    s.setPassword(newPassword);
                    error = 0;
            }
        }

    	if (error != 0){
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
    public static boolean validateSecurityCode(int securityCode){ //securityCode cannot start from 0
    	int error = 0;
    	int code = securityCode;
    	int countDigit = 0;
    	
    	while (securityCode > 0){
    		securityCode /= 10;
    		countDigit++;
    	}
    	
    	if(countDigit <= 8){
    		return false;
    	}else {
    		return true;
    	}
    }
}