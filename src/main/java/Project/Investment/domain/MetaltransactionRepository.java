package Project.Investment.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MetaltransactionRepository extends CrudRepository<Metaltransaction, Long> {
	
	List<Metaltransaction> findByOperation(String operation);

}
