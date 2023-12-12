package practice_crud_1_to_1.JPA_1_to_1.Model.Request;

import java.io.Serializable;

import practice_crud_1_to_1.JPA_1_to_1.Model.Entity.wooriBank;

public class wooriBankRequest implements Serializable {

	private String staff;
	private String dept;
	private wooriBranchRequest branches;
	
	public wooriBankRequest(String staff, String dept, wooriBranchRequest branches) {
		super();
		this.staff = staff;
		this.dept = dept;
		this.branches = branches;
	}

	public wooriBank wbRequestMethod() {
		wooriBank wbReq = new wooriBank();
		wbReq.setStaff(this.staff);
		wbReq.setDept(this.dept);
		wbReq.setBranches(this.branches.reqBranchMethod(wbReq));
		return wbReq;
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
	public wooriBranchRequest getBranches() {
		return branches;
	}
	public void setBranches(wooriBranchRequest branches) {
		this.branches = branches;
	}
	
}
