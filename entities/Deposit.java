package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "deposit")
public class Deposit {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String depositDate;
    private double depositAmount;
 
    public Deposit() {
    	
    }
    public Deposit( String depositDate, double depositAmount) {
		super();
		this.depositDate = depositDate;
		this.depositAmount = depositAmount;
	}
    
    @XmlElement
	public int getId() {
		
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(String depositDate) {
		this.depositDate = depositDate;
	}
	@XmlElement
	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	
    
    
}
