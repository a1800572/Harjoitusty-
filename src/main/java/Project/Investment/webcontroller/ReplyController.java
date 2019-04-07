package Project.Investment.webcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Project.Investment.domain.Comment;
import Project.Investment.domain.CommentRepository;
import Project.Investment.domain.Reply;
import Project.Investment.domain.ReplyRepository;



@Controller
public class ReplyController {
	@Autowired
	private CommentRepository crepository;
	
	@Autowired
	private ReplyRepository rrepository;
	
	
	
	@RequestMapping(value="/addcommentreply/{id}", method = RequestMethod.GET)
    public String addReply(@PathVariable("id") Long commentId, Model model){
    		model.addAttribute("reply", new Reply());
    		model.addAttribute("replies", rrepository.findAll());
    		model.addAttribute("comment", crepository.findById(commentId).get());
    		return "addReply";
    }
	
	
	@RequestMapping(value="/comment/{id}/replies", method=RequestMethod.GET)
	public String commentreply(@PathVariable("id") Long id, @PathVariable("id") Long replyId, Model model, Reply reply) {
    	
		Optional<Comment> comment = crepository.findById(id);

		
			if (!comment.get().hasReply(reply)) {
				comment.get().getReplies().add(reply);
			}
			crepository.save(comment.get());
			
			
			model.addAttribute("comment", crepository.findById(id));
			model.addAttribute("replies", rrepository.findAll());
			

		
		return "redirect:/commentlist";
		
	}    
	
	

}
