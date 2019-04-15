package Project.Investment.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface CommentRepository extends CrudRepository<Comment, Long>{
	
	List<Comment> findByusername(String username);
	
	Comment getCommenyById(Long commentId);
	
	
	//rest
	List<Comment>findByText(@Param("text") String text);

}
