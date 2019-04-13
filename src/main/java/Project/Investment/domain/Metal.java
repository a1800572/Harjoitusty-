package Project.Investment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Metal {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long metalid;
	private int ammount;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="metaltypeid")
	private Metaltype metaltype;
	
	public Metal() {}
	
	public Metal(int ammount, double price, Metaltype metaltype) {
		super();
		this.ammount=ammount;
		this.price=price;
		this.metaltype=metaltype;
	}

	
	
	public Metaltype getMetaltype() {
		return metaltype;
	}

	public void setMetaltype(Metaltype metaltype) {
		this.metaltype = metaltype;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
		if (this.metaltype != null)
		return "id"+metalid+"ammount"+ammount+price+this.getMetaltype();
		else
		return "id"+metalid+"ammount"+ammount+price;
		
	}
	

}
