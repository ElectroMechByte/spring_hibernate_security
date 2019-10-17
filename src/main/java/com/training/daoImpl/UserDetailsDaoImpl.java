package com.training.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.training.dao.UserDetailsDao;
import com.training.model.User;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		// List<Product> products = session.createQuery("from Product").list();
		List<User> users = session.createCriteria(User.class).list();
		System.out.println(users);
		session.close();
		return users;
	}

	public void deleteUser(String userId) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, userId);
		session.saveOrUpdate(user);
		session.flush();
		session.close();// close the session
	}

	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();
	}

	public User getUserById(String userId) {
		return sessionFactory.getCurrentSession().get(User.class, userId);
	}

	@Override
	public User findUserByUsername(String username) {

		Session currentSession = sessionFactory.getCurrentSession();
		String hql = "from User u where u.emailId = '" + username + "'";
		List result = currentSession.createQuery(hql).list();
		User user = new User();
		if (result.size() > 0) {
			user = (User) result.get(0);
		}

		return user;

	}

}
