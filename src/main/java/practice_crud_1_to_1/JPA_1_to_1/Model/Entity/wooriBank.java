package practice_crud_1_to_1.JPA_1_to_1.Model.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Woori Bank")
public class wooriBank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 30, unique = true)
	private String staff;
	private String dept;
	
//	cascade = CascadeType.ALL, orphanRemoval = true use for delete data from child first
	@OneToOne(mappedBy = "bankWB", cascade = CascadeType.ALL, orphanRemoval = true)
	private wooriBranch branches;
	
	
	
	public wooriBranch getBranches() {
		return branches;
	}
	public void setBranches(wooriBranch branches) {
		this.branches = branches;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
}
