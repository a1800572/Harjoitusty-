package Project.Investment.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Metaltransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long transactionid;
	private String operation;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="metaltransaction")
	@JsonIgnore
	private List<Metal> metals;
	
	
	public Metaltransaction() {}
	
	
	public Metaltransaction(String operation) {
		super();
		this.operation=operation;
	}


	public Long getTransactionid() {
		return transactionid;
	}


	public void setTransactionid(Long transactionid) {
		this.transactionid = transactionid;
	}


	public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public List<Metal> getMetals() {
		return metals;
	}


	public void setMetals(List<Metal> metals) {
		this.metals = metals;
	}


	@Override
	public String toString() {
		return operation+transactionid;
	}
	
	
	
	

}
