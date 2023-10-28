package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.MoneyLender;

public class MoneyLenderDAO {

	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("Alicja"); 
	
	public MoneyLenderDAO(){
		
	}

	
	
	public void persist(MoneyLender moneylender) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(moneylender);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(MoneyLender moneylender) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(moneylender));
		em.getTransaction().commit();
		em.close();
	}
	
	public MoneyLender merge(MoneyLender moneylender) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		MoneyLender updatedMoneyLender = em.merge(moneylender);
		em.getTransaction().commit();
		em.close();
		return updatedMoneyLender;
	}
	
	
	/*   public MoneyLender findMoneyLenderById(int moneylenderId) {
	        EntityManager em = emf.createEntityManager();
	        MoneyLender moneylender = em.find(MoneyLender.class, moneylenderId);
	        em.close();
	        return moneylender;
	    }*/
}
