package myservice;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mydao.Mydao;
import mymodel.Employee;
import mymodel.User;

@Service
@Transactional
public class MyserviceImpl implements Myservice {
	
	@Autowired
	Mydao dao;
	
	@Override
	public Employee login(String username) {
		return dao.login(username);
	}
	
	@Override
	public boolean insertEmployee(Employee employee) {
		 return dao.insertEmployee(employee);
	}
	
	public List<User> selectAll() {
		return dao.selectAll();
	}

	@Override
	public void insertUser(User user) {
		dao.insertUser(user);
	}
	
	@Override
	public void doUpdateUser(User updateUser) {
		dao.doUpdateUser(updateUser);
	}
	
	@Override
	public void deleteCustomer(int theid) {
		dao.deleteCustomer(theid);
	}

	@Override
	public User selectOneUser(int uid) {
		return dao.selectOneUser(uid);
	}
	
	//encode the password in MD5 format
	@Override
	public String encodeMd5(String str) throws NoSuchAlgorithmException {
		
		StringBuffer sb = new StringBuffer();
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] bytes = md.digest(str.getBytes());
		for(byte b:bytes) {
			sb.append(String.format("%x", b>>4 & 0x0f));
			sb.append(String.format("%x", b & 0x0f));
		}
		String encodepwd = sb.toString(); 		
		return encodepwd;
	}
	
	@Override
	public String gnpwd() {
		Random rd = new Random();
		String newpwd = "";
		for(int i=0; i<10; i++) {
			newpwd = newpwd + (char)(rd.nextInt(26)+97);
		}
		return newpwd;
	}
	
	
	
	
	
	
	
	
}	
