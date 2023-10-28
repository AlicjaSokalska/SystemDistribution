package main;

import java.util.ArrayList;
import java.util.List;

import DAO.DepositDAO;
import DAO.LoanDAO;
import DAO.MoneyLenderDAO;
import DAO.UserDAO;
import entities.Deposit;
import entities.Loan;
import entities.MoneyLender;

import entities.User;

public class Test {

	public Test() {
		UserDAO uDAO = new UserDAO();
		LoanDAO lDAO = new LoanDAO();
		MoneyLenderDAO mDAO = new MoneyLenderDAO();
		DepositDAO dDAO = new DepositDAO();

		

		
		// add deposit

		Deposit d1 = new Deposit("03/June/2023", 300.00);
		Deposit d2 = new Deposit("03/July/2023", 400.00);
		Deposit d3 = new Deposit("04/September/2023", 90.00);
		dDAO.persist(d1);
		dDAO.persist(d2);
		dDAO.persist(d3);
		
	
		// add to list
		List<Deposit> deposits = new ArrayList<Deposit>();
		deposits.add(d1);
		deposits.add(d2);
		deposits.add(d3);
		

		// add loan
		Loan loan = new Loan("House Loan", 70000, deposits);
		lDAO.persist(loan);
		
		
		// add user
		User user = new User("Tom", "009230232", "Dublin3", 6000, loan);
		uDAO.persist(user);
		
		
		// add users to moneylender
	//	List<User> users = new ArrayList<User>();
	//	users.add(user);
		

		// add moneylender

	//	MoneyLender moneylender = new MoneyLender(users);
	//	mDAO.persist(moneylender);
		
		//View all user (here I've accessed all objects through the subscriber)
				ArrayList<User> users = (ArrayList<User>) uDAO.getAllUsers();
				for(User u : users) {
					System.out.println("User object name is "+u.getName());
					System.out.println("User's loan amount is "+ u.getLoan().getLoanAmount());
					//Note I've made an Eagar Fetch on the Comments List in Profile to enable this
					System.out.println("User's loan's first deposit Amount is  "+u.getLoan().getDeposits().get(0).getDepositAmount());
					System.out.println("User's loan's first deposit Date "+u.getLoan().getDeposits().get(0).getDepositDate());
	 
				}
	

	
		//Update username using merge
		user.setName("Tommy");
		uDAO.merge(user);	
		
		//remove the last comment
		dDAO.remove(d3);
		
		
		
		
		

	}
	

	public static void main(String[] args) {
		new Test();
	}

}
