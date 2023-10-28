package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;




@Entity


@NamedQueries({
	@NamedQuery(name="User.findAll", query="select o from User o"), 
	@NamedQuery(name = "User.findByName", query = "select o from User o where o.name=:name")
})

public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String phoneNumber;
	private String address;
	private double annualSalary;
	
	//one to one : user to loan
	@OneToOne
	private Loan loan;
	
	

	public User() {

	}

	public User(String name, String phoneNumber, String address, double annualSalary, Loan loan) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.annualSalary = annualSalary;
		this.loan = loan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}


}