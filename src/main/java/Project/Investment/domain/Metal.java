package Project.Investment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Metal {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long metalid;
	private int ammount;
	
	public Metal() {}
	
	public Metal(int ammount) {
		super();
		this.ammount=ammount;
	}

	
	
	public Long getMetalid() {
		return metalid;
	}

	public void setMetalid(Long metalid) {
		this.metalid = metalid;
	}

	public int getAmmount() {
		return ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	
	
	@Override
	public String toString() {
		return "id"+metalid+"ammount"+ammount;
		
	}
	

}
