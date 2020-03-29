package mycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecController {
	
	@RequestMapping("/secController")
	public String newPage() {
		System.out.println("page4");
		return "page4";
	}

}
