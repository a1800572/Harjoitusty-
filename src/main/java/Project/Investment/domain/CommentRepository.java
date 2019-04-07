package Project.Investment.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface CommentRepository extends CrudRepository<Comment, Long>{
	
	List<Comment> findByusername(String username);
	
	Comment getCommenyById(Long commentId);

}
