package com.training.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.dao.CustomerDao;
import com.training.model.Authorities;
import com.training.model.Cart;
import com.training.model.Customer;
import com.training.model.User;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional	
	public void addCustomer(Customer customer) {
		
		System.out.println("Adding customer in dao");
		customer.getUsers().setEnabled(true);
		Authorities authorities = new Authorities();
		authorities.setAuthorities("ROLE_USER");
		authorities.setEmailId(customer.getUsers().getEmailId());

		Cart cart = new Cart();
		// it is to set CartId for customer table
		customer.setCart(cart);// set the cart to the customer
		// if we omit this statement, hen it will insert null for customerid in cart
		// to set the customerid in cart table
		cart.setCustomer(customer);
		
		 Session currentSession = sessionFactory.getCurrentSession();
	     currentSession.saveOrUpdate(customer);
		 
	}
	@Transactional	
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.openSession();
		List<Customer> customerList = session.createQuery("from Customer").list();

		return customerList;
	}
	@Transactional	
	public Customer getCustomerByemailId(String emailId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where emailId=?");
		query.setString(0, emailId);
		User users = (User) query.uniqueResult();
		//Customer customer = users.getCustomer();
		return null;
	}

}
