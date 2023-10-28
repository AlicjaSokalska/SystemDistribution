package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.MoneyLender;

import entities.User;

public class UserDAO {

	
	protected static EntityManagerFactory emf = 
	 		Persistence.createEntityManagerFactory("Alicja"); 	
	
	public UserDAO() {
		
	}
	
	public void persist(User user) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(User user) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(user));
		em.getTransaction().commit();
		em.close();
	}
	
	public User merge(User user) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User updatedUser = em.merge(user);
		em.getTransaction().commit();
		em.close();
		return updatedUser;
	}
	
	public List<User> getAllUsers() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<User> usersFromDB = new ArrayList<User>();
		usersFromDB = em.createNamedQuery("User.findAll").getResultList();
		em.getTransaction().commit();
		em.close();
		return usersFromDB;
	}
	
	public User getSubscriberByUsername(String name){
		EntityManager em = emf.createEntityManager();
		List<User> users = (List<User>) 
				em.createNamedQuery("User.findByName").
				setParameter("name", name).getResultList();
		em.close();
		//Do whatever you want with the subscriber(s) with that username
		//Here we just return the first one
		User use = new User();
		for(User u:users) {
			use = u;
		}
		return use;
	}
	}






