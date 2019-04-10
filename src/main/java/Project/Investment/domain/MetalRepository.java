package Project.Investment.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface MetalRepository extends CrudRepository<Metal, Long> {

	List<Metal> findByAmmount(Long metalid);
}
