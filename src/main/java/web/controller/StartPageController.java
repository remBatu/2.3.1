package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartPageController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		return "index";
	}
	
}