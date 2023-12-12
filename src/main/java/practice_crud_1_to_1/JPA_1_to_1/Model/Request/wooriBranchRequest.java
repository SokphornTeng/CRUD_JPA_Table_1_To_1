package practice_crud_1_to_1.JPA_1_to_1.Model.Request;


import java.io.Serializable;

import practice_crud_1_to_1.JPA_1_to_1.Model.Entity.wooriBank;
import practice_crud_1_to_1.JPA_1_to_1.Model.Entity.wooriBranch;

public class wooriBranchRequest implements Serializable {

	private String branches;
	
	public wooriBranch reqBranchMethod(wooriBank wb) {
		wooriBranch reqB = new wooriBranch();
		reqB.setBranches(this.branches);
		reqB.setBankWB(wb);
		return reqB;
	}
	
	public String getBranches() {
		return branches;
	}
	public void setBranches(String branches) {
		this.branches = branches;
	}
	
	
}
