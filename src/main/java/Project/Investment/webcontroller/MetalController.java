package Project.Investment.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Project.Investment.domain.Metal;
import Project.Investment.domain.MetalRepository;
import Project.Investment.domain.Metaltransaction;
import Project.Investment.domain.MetaltransactionRepository;
import Project.Investment.domain.MetaltypeRepository;


@Controller
public class MetalController {
	
	@Autowired
	MetalRepository mrepository;
	
	@Autowired
	MetaltypeRepository mtrepository;
	
	@Autowired
	MetaltransactionRepository trepository;
	
	
		@RequestMapping(value="/newmetal", method=RequestMethod.GET)
		public String lisääuusimetalli(Model model) {
		model.addAttribute("metal", new Metal());
		model.addAttribute("metaltypes", mtrepository.findAll());
		model.addAttribute("metaltransactions",trepository.findAll());
		return "newmetal";
		
	}
		
		@RequestMapping(value="/savemetal", method=RequestMethod.POST)
		public String savemetal(Metal metal) {
			mrepository.save(metal);
			return "redirect:commentlist";
		}
		
		@RequestMapping(value="/removemetal/{id}", method=RequestMethod.GET)
		public String deletemetal(@PathVariable("id") Long metalId, Model model) {
			mrepository.deleteById(metalId);
			return "redirect:../commentlist";
			
		}
		
		@RequestMapping(value="/editmetal/{id}")
		public String editmetal(@PathVariable("id") Long metalId, Model model) {
			model.addAttribute("metal", mrepository.findById(metalId));
			model.addAttribute("metaltypes", mtrepository.findAll());
			model.addAttribute("metaltransactions", trepository.findAll());
			return "editmetal";
		}
}
