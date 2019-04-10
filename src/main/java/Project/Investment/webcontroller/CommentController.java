package Project.Investment.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Project.Investment.domain.Comment;
import Project.Investment.domain.CommentRepository;
import Project.Investment.domain.MetalRepository;



@Controller
public class CommentController {
	
	@Autowired 
	CommentRepository repository;
	
	@Autowired
	MetalRepository mrepository;
	
	
	//index controlleriin
	//muista vaihtaa nimi indek
	@RequestMapping(value="/commentlist")
	public String commentList(Model model) {
		model.addAttribute("metals",mrepository.findAll());
		model.addAttribute("comment", new Comment());
		model.addAttribute("comments",repository.findAll());
		return "commentlist";
		
	}
	
	@RequestMapping(value="/savecomment" ,method=RequestMethod.POST)
	public String save(Comment comment) {
		repository.save(comment);
		return "redirect:commentlist";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteComment(@PathVariable("id") Long commentId, Model model) {
    	repository.deleteById(commentId);
        return "redirect:../commentlist";
    }
	
	
	//operaattori näyttää yhden kommentin tiedot erillisellä sivulla
	@RequestMapping(value = "/View/{id}", method = RequestMethod.GET)
	public String Viewprofile(@PathVariable("id") Long commentId, Model model) {
		model.addAttribute("comment", repository.getCommenyById(commentId));
		return "details";
}
}
