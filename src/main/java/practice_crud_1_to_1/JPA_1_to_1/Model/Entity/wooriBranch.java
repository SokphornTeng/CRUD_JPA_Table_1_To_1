package practice_crud_1_to_1.JPA_1_to_1.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Woori Branch")
public class wooriBranch {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 40, name = "branch")
	private String branches;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wooriID", nullable =  false)
	private wooriBank bankWB;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBranches() {
		return branches;
	}
	public void setBranches(String branches) {
		this.branches = branches;
	}
	public wooriBank getBankWB() {
		return bankWB;
	}
	public void setBankWB(wooriBank bankWB) {
		this.bankWB = bankWB;
	}
	
}
