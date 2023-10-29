package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Deposit;
import entities.Loan;
import entities.User;


public class DepositDAO {
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Alicja");

	public DepositDAO() {

	}

	public void persist(Deposit deposit) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist( deposit);
		em.getTransaction().commit();
		em.close();
	}

	public void remove(Deposit deposit) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(deposit));
		em.getTransaction().commit();
		em.close();
	}

	public Deposit merge(Deposit deposit) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Deposit  updatedDeposit = em.merge(deposit);
		em.getTransaction().commit();
		em.close();
		return updatedDeposit;
	}

	public Deposit getDepositByID(int id){
		 EntityManager em = emf.createEntityManager();
	        Deposit deposit = em.find(Deposit.class, id);
	        em.close();
	        return deposit;
	}

	

	public List<Deposit> getAllDeposits() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Deposit> depositsFromDB  = em.createQuery("SELECT u FROM Deposit  u", Deposit.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return depositsFromDB;
	}
	
	
}