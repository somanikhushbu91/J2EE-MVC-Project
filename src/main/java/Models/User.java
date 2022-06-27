package Models;

public class User {
	private String username;
	private String password;
	private String cellphoneno;
	private String email;
	private String name;
	private int isadmin;
	
	public int getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String address;
	
	public User() {		
		}

	public User(String username, String password) {
		// TODO Auto-generated constructor stub
	}

	public User(String username2) {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCellPhoneno() {
		return cellphoneno;
	}
	public void setCellPhoneno(String cellphoneno) {
		this.cellphoneno = cellphoneno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", cellphoneno=" + cellphoneno + ", email=" + email
				+ ", name=" + name + ", isadmin=" + isadmin + ", address=" + address + "]";
	}

	
	public String User() {
		return "User [username=" + username + ", password=" + "]";
	}

}
