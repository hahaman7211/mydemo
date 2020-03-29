package mymodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//import javax.persistence package!!
@Entity
@Table(name="CUSTOMER")
public class User {
	
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_generator")
	//@SequenceGenerator(name = "c_generator", sequenceName = "SEQ_CUSTOMER")
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@Column(name="EMAIL")
	private String email;
	
	//** default constructor is required for using hibernate!!!!
	public User() {
		
	}
	
	public User(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
	public User(int id, String firstname, String lastname, String email) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setUsername(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	

}
