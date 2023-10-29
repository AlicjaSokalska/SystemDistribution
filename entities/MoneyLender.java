package entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity



public class MoneyLender {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    //one to many with user
    
    @OneToMany(fetch = FetchType.EAGER)
	private List<User> users = new ArrayList<User>();
	
    
    
	
	public MoneyLender() {
		
		
	}

	public MoneyLender( List<User> users) {
		this.users = users;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}


   
}
