package Project.Investment.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Project.Investment.domain.Comment;
import Project.Investment.domain.CommentRepository;
import Project.Investment.domain.Metal;
import Project.Investment.domain.MetalRepository;
import Project.Investment.domain.Metaltransaction;
import Project.Investment.domain.MetaltransactionRepository;
import Project.Investment.domain.Metaltype;
import Project.Investment.domain.MetaltypeRepository;
import Project.Investment.domain.Reply;
import Project.Investment.domain.ReplyRepository;



@Controller
public class RestController {
	
	@Autowired
	private CommentRepository crepository;
	
	@Autowired
	private ReplyRepository rrepository;
	
	@Autowired
	private MetalRepository mrepository;
	
	@Autowired
	private MetaltypeRepository mtrepository;
	
	@Autowired
	private MetaltransactionRepository trepository;
	
	
	//REST comment
	@RequestMapping(value="/comments", method=RequestMethod.GET)
	public @ResponseBody List<Comment> commentListRest(){
		return(List<Comment>) crepository.findAll();
	}
	
	//REST comment
	@RequestMapping(value="/comment/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional <Comment> findCommentRest(@PathVariable("id") Long commentId){
		return crepository.findById(commentId);
	}
	
	//REST reply
	@RequestMapping(value="/replys", method=RequestMethod.GET)
	public @ResponseBody List<Reply> replyListRest(){
		return(List<Reply>) rrepository.findAll();
	}
	
	//REST reply
	@RequestMapping(value="/reply/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional <Reply> findReplyRest(@PathVariable("id") Long replyId){
		return rrepository.findById(replyId);
	}
	
	//REST metal
	@RequestMapping(value="/metals", method=RequestMethod.GET)
	public @ResponseBody List<Metal> metalListRest(){
		return(List<Metal>) mrepository.findAll();
	}
	
	//REST metal
	@RequestMapping(value="/metal/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional <Metal> findMetalRest(@PathVariable("id") Long metalId){
		return mrepository.findById(metalId);
	}
	
	//REST metaltype
	@RequestMapping(value="/metaltypes", method=RequestMethod.GET)
	public @ResponseBody List<Metaltype> metaltypeListRest(){
		return(List<Metaltype>) mtrepository.findAll();
	}
	
	//REST metaltype
	@RequestMapping(value="/metaltype/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional <Metaltype> findMetaltypeRest(@PathVariable("id") Long metaltypeId){
		return mtrepository.findById(metaltypeId);
	}
	//transactiontype
	@RequestMapping(value="/metaltransactions", method=RequestMethod.GET)
	public @ResponseBody List<Metaltransaction> metaltransactionListRest(){
		return(List<Metaltransaction>) trepository.findAll();
	}
	
	//REST metaltransaction
	@RequestMapping(value="/metaltransaction/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional <Metaltransaction> findMetaltransactionRest(@PathVariable("id") Long metaltransactionId){
		return trepository.findById(metaltransactionId);
	}

}
