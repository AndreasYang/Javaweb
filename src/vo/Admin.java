package vo;

import java.io.Serializable;

public class Admin implements Serializable{
	private String name;
	private String password;
	public Admin() {
		super();
	}
		
	public Admin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
