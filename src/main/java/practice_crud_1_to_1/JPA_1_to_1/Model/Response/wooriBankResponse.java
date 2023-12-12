package practice_crud_1_to_1.JPA_1_to_1.Model.Response;

import java.io.Serializable;

import practice_crud_1_to_1.JPA_1_to_1.Model.Entity.wooriBank;

public class wooriBankResponse implements Serializable {

	private Long id;
	private String staff;
	private String dept;
	private wooriBranchResponse branches;
	
	public wooriBankResponse(Long id, String staff, String dept, wooriBranchResponse branches) {
		super();
		this.id = id;
		this.staff = staff;
		this.dept = dept;
		this.branches = branches;
	}
	
	public static wooriBankResponse wbfmResponse(wooriBank wbfmBank) {
		wooriBranchResponse branchWB;
		if(wbfmBank.getBranches() == null)
			branchWB = null;
		else branchWB = new wooriBranchResponse(wbfmBank.getBranches().getId(), wbfmBank.getBranches().getBranches());
		return new wooriBankResponse(
				wbfmBank.getId(),
				wbfmBank.getStaff(), 
				wbfmBank.getDept(), 
				branchWB);
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
	public wooriBranchResponse getBranches() {
		return branches;
	}
	public void setBranches(wooriBranchResponse branches) {
		this.branches = branches;
	}
	
	
}
