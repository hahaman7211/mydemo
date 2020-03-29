package mymodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	
	
	@Column(name="EMPLOYEE_ID")
	private String employee_id;
	
	@Id
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	//default constructor
	public Employee() {	
		}
	
	//constructor
	public Employee(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
}
