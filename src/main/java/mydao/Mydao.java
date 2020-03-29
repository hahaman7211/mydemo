package mydao;

import java.util.List;

import mymodel.Employee;
import mymodel.User;

public interface Mydao {
	
	public List<User> selectAll();
	
	public void insertUser(User user);
	
	public Employee login(String username);

	public boolean insertEmployee(Employee employee);

	public User selectOneUser(int uid);

	public void doUpdateUser(User updateUser);

	public void deleteCustomer(int theid);

}
