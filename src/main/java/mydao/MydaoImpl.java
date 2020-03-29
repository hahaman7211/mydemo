package mydao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mymodel.Employee;
import mymodel.User;

@Repository
public class MydaoImpl implements Mydao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<User> selectAll() {
		
		List<User> mylist = new ArrayList<User>();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			//import import org.hibernate.query.Query package for Query class
			//query: from your entity name not the database table name!!!
			Query<User> query = session.createQuery("from User order by id", User.class);
			mylist = query.getResultList();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return mylist;
	}
	
	
	@Override
	public User selectOneUser(int uid) {
		User user = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			user = session.get(User.class, uid);		
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}

	@Override
	public void insertUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}
	
	@Override
	public void deleteCustomer(int theid) {
		try {
			Session session = sessionFactory.getCurrentSession();
			User user = new User();
			user.setId(theid);
			session.delete(user);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void doUpdateUser(User updateUser) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(updateUser);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//select one employee from databse. Then return that to service
	@Override
	public Employee login(String username) {
		Employee employee = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			employee = session.get(Employee.class, username);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return employee;
	}
	
	//insert a new employee
	@Override
	public boolean insertEmployee(Employee employee) {
		boolean result = false;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(employee);
			result = true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	




	

	

	

	

	

}
