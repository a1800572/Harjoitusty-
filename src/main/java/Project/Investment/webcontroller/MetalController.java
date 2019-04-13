package Project.Investment.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Project.Investment.domain.Metal;
import Project.Investment.domain.MetalRepository;
import Project.Investment.domain.MetaltypeRepository;


@Controller
public class MetalController {
	
	@Autowired
	MetalRepository mrepository;
	
	@Autowired
	MetaltypeRepository mtrepository;
	
	
		@RequestMapping(value="/newmetal", method=RequestMethod.GET)
		public String lisääuusimetalli(Model model) {
		model.addAttribute("metal", new Metal());
		model.addAttribute("metaltypes", mtrepository.findAll());
		return "newmetal";
		
	}
		
		@RequestMapping(value="savemetal", method=RequestMethod.POST)
		public String savemetal(Metal metal) {
			mrepository.save(metal);
			return "redirect:commentlist";
		}
}
