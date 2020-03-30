package mycontroller;


import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import mymodel.Employee;
import mymodel.User;
import myservice.Myservice;

@Controller
@RequestMapping("/homepage")
@SessionAttributes("loginEmlp") //this loginEmlp has an unencoded password
public class MyController {

	@Autowired
	Myservice service;
	
	// call service to check the username and password
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) throws NoSuchAlgorithmException {
		
		String encodepwd = service.encodeMd5(password);
		Employee employee = service.login(username);
		if (employee != null && encodepwd.equals(employee.getPassword())) {
			Employee loginEmlp = new Employee(username, password, employee.getEmail());
			model.addAttribute("loginEmlp", loginEmlp);
			return "redirect:/homepage/gohomepage";
		} 
		else
			return "errorpage";
	}

	// dispatcher to homepage.jsp and get the Employee from database
	@RequestMapping("/gohomepage")
	public String tohomepage() {
		
		return "homepage";	
	}

	// dispatcher to employeeform.jsp
	@RequestMapping("/signupform")
	public String signUpForm() {
		return "employeeform";
	}
	
	@ResponseBody
	@RequestMapping("/checkUsername")
	public String checkUsername(String theusername) {
		Employee employee = service.login(theusername);
		if(employee!=null) {
			return "y";
		}
		else {		
			return "n";
		}		
	}

	// call service to insert a new employee, and then redirect to /homepage/gohomepage
	@RequestMapping("/addemployee")
	public String addemployee(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("email") String email, Model model) throws NoSuchAlgorithmException {
		
		String encodepwd = service.encodeMd5(password);
		Employee loginEmlp = new Employee(username, password, email);
		Employee employee = new Employee(username, encodepwd, email);
		boolean result = service.insertEmployee(employee);
		
		if (result == true) {
			model.addAttribute("loginEmlp", loginEmlp);
			return "redirect:/homepage/gohomepage";
		} 
		else
			return "errorpage";
	}

	// dispatcher to addCustomerform.jsp
	@RequestMapping("/showform")
	public String showForm() {
		return "addCustomerform";
	}

	// call service to insert a new customer, and then redirect to dolist controller
	@RequestMapping("/addcustomer")
	public String addUser(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			@RequestParam("email") String email) {

		User user = new User(firstname, lastname, email);
		service.insertUser(user);
		
		// *return a redirect to the browser for preventing resubmit
		return "redirect:/homepage/dolist";
	}

	// call service to select all customer before dispatcher to list.jsp
	@RequestMapping("/dolist")
	public String doList(Model model) {
		List<User> mylist = service.selectAll();
		model.addAttribute("alluser", mylist);
		return "list";	
	}

	@RequestMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("uid") int uid, Model model) {
		User user = service.selectOneUser(uid);
		model.addAttribute("theUser", user);
		return "updateform";
	}
	
	@RequestMapping("/doUpdateUser")
	public String doUpdateUser(@RequestParam("theid") int theid, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("email") String email) {
		
		User updateUser = new User(theid, firstname, lastname, email);
		service.doUpdateUser(updateUser);
		return "redirect:/homepage/dolist";
	}
	
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("uid") int theid) {
		service.deleteCustomer(theid);
		return "redirect:/homepage/dolist";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, SessionStatus status) {
		if(session.getAttribute("loginEmlp")!=null) {
			
			//SessionStatus has to set Complete before removeAttribute
			status.setComplete();
			//session.invalidate();
			session.removeAttribute("loginEmlp");	
		}
		
		return "redirect:/homepage/gohomepage";
	}

}
