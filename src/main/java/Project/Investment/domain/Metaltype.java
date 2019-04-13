package Project.Investment.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Metaltype {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long metaltypeid;
	private String type;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="metaltype")
	private List<Metal> metals;
	
	
	
	public Metaltype() {}
	
	public Metaltype(String type) {
		super();
		this.type=type;
	}

	public Long getMetaltypeid() {
		return metaltypeid;
	}

	public void setMetaltypeid(Long metaltypeid) {
		this.metaltypeid = metaltypeid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	public List<Metal> getMetals() {
		return metals;
	}

	public void setMetals(List<Metal> metals) {
		this.metals = metals;
	}

	@Override
	public String toString() {
		return type+metaltypeid;
		
	}

}
