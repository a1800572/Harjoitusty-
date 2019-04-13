package Project.Investment.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LanguageController {
	
	//Englanniksi
	@RequestMapping(value="/commentlist?language=en", method=RequestMethod.GET)
	public String English() {
	return "redirect:commentlist";	
	}
	
	@RequestMapping(value="/commentlist?language=fr", method=RequestMethod.GET)
	public String French() {
	return "redirect:commentlist";
	}
	
	@RequestMapping(value="/commentlist?language=fi", method=RequestMethod.GET)
	public String Finnish() {
	return "redirect:commentlist";
	}
	
	@RequestMapping(value="/commentlist?language=ru", method=RequestMethod.GET)
	public String Russia() {
	return "redirect:commentlist";
	}

}
