package myservice;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import mymodel.Employee;
import mymodel.User;

public interface Myservice {
	
	public List<User> selectAll();
	
	public void insertUser(User user);

	public Employee login(String username);

	public boolean insertEmployee(Employee employee);

	public User selectOneUser(int uid);

	public void doUpdateUser(User updateUser);

	public void deleteCustomer(int theid);

	String encodeMd5(String str) throws NoSuchAlgorithmException;

	String gnpwd();

}
