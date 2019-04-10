package Project.Investment.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Project.Investment.domain.Metal;
import Project.Investment.domain.MetalRepository;


@Controller
public class MetalController {
	
	@Autowired
	MetalRepository mrepository;
	
		@RequestMapping(value="/newmetal", method=RequestMethod.GET)
		public String lisääuusimetalli(Model model) {
		model.addAttribute("metal", new Metal());
		return "newmetal";
		
	}
		
		@RequestMapping(value="savemetal", method=RequestMethod.POST)
		public String savemetal(Metal metal) {
			mrepository.save(metal);
			return "redirect:commentlist";
		}
}
