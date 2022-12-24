package users.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table (name = "users")

public class User {
	@Id 
	@GeneratedValue
	@Column(name = "userid")
	private long userId;
	
	@Size(max = 128, message = "Maximum Length Allowed is 128")
	@NotBlank @NotNull
	private String firstname;
	
	@Size(max = 128, message = "Maximum Length Allowed is 128")
	private String lastname;
	
	
	@Email (message = "Enter a valid Email", regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
	@Column(unique = true)
	@NotBlank @NotNull
	private String email;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	@Past(message="Date cannot be after today")
	private Calendar dateofbirth;
	
	@Transient
	private int age;

	public User() {}
	
	public User(String firstname, String lastname, String email, Calendar dateofbirth) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dateofbirth = dateofbirth;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
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
	public Calendar getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Calendar dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
		
}
