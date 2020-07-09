package com.hardik.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;



@Entity
@Table
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@NotNull
	@Size(min = 3, max = 20)
    @Column(nullable = false)
    private String username;

    @NotNull(message="Password is compulsory")
	@Length(min=3, message="Password should be at least 3 characters")
    @Column(nullable = false)
    private String password;
    
    @NotBlank
	@Email(message = "Please enter a valid e-mail address")
    private String email;

    private Boolean active;

    private String roles = "";
    
    private Date dateOfJoining;
    
    @ManyToOne
    private Department department;
    
    @OneToMany(targetEntity=Leave.class)
	private List<Leave> leave;
    
    @NotNull
    @Min(value = 18)
	@Max(value = 55)
    private int age;    
 
    @Min(value = 20_000)
	@Max(value = 300_000)
    private double salary;
    
    private double workingDaysOfThisMonth;
    
    @OneToMany(targetEntity=UserQuery.class)
	private List<UserQuery> userQuery;

//    private String permissions = "";
    
    
    public int getId() {
    	return id;
    }

    public void setId(int id) {
    	this.id = id;
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

    public Boolean getActive() {
    	return active;
    }

    public void setActive(Boolean active) {
    	this.active = active;
    }

    public String getRoles() {
    	return roles;
    }

    public void setRoles(String roles) {
    	this.roles = roles;
    }

    public int getAge() {
    	return age;
    }

    public void setAge(int age) {
    	this.age = age;
    }

    public double getSalary() {
    	return salary;
    }

    public void setSalary(double salary) {
    	this.salary = salary;
    }
	
//		public String getPermissions() {
//		return permissions;
//	}
//	
//	public void setPermissions(String permissions) {
//		this.permissions = permissions;
//	}

	public double getWorkingDaysOfThisMonth() {
		return workingDaysOfThisMonth;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


	public List<Leave> getLeave() {
		return leave;
	}

	public void setLeave(List<Leave> leave) {
		this.leave = leave;
	}

	public void setWorkingDaysOfThisMonth(double workingDaysOfThisMonth) {
		this.workingDaysOfThisMonth = workingDaysOfThisMonth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	public List<UserQuery> getUserQuery() {
		return userQuery;
	}

	public void setUserQuery(List<UserQuery> userQuery) {
		this.userQuery = userQuery;
	}

	public List<String> getRoleList(){
	//	separate roles ,if more than one
	    if(this.roles.length() > 0){
	        return Arrays.asList(this.roles.split(","));
	    }
	    return new ArrayList<>();
	}

	
//    public List<String> getPermissionList(){
//        if(this.permissions.length() > 0){
//            return Arrays.asList(this.permissions.split(","));
//        }
//        return new ArrayList<>();
//    }	
	
	 	@PrePersist
	    public void prePersist() throws ParseException {
	 		
	        this.dateOfJoining = new Date();
	        
	    }

		@Override
		public String toString() {
			return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
					+ ", active=" + active + ", roles=" + roles + ", dateOfJoining=" + dateOfJoining + ", age=" + age
					+ ", salary=" + salary + ", department=" + department + "]";
		}
	 	
	 	

	
}
