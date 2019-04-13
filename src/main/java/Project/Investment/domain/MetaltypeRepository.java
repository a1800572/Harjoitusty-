package Project.Investment.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MetaltypeRepository extends CrudRepository<Metaltype, Long>{
	
	List<Metaltype> findByType(String type);

}
