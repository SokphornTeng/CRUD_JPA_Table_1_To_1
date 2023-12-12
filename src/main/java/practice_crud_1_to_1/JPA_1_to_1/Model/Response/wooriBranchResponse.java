package practice_crud_1_to_1.JPA_1_to_1.Model.Response;

import java.io.Serializable;

public class wooriBranchResponse implements Serializable {

	private Long id;
	private String branches;
	
	public wooriBranchResponse(Long id, String branches) {
		super();
		this.id = id;
		this.branches = branches;
	}
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
	
	
	
}
