

public class Staff extends Personal_info{
    private String password;
    private int securityCode;
    private String post;
    private String jobDesc;
    private static int idCount= 5001;

	public Staff(int id,String fName, String lName, String phNum, int age, char gender, String email, String password, int securityCode, String post, String jobDesc) {
            super(id, fName, lName, phNum, age, gender, email);
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
    
}