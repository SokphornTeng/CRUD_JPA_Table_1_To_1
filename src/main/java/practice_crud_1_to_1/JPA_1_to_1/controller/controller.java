package practice_crud_1_to_1.JPA_1_to_1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practice_crud_1_to_1.JPA_1_to_1.Model.Entity.wooriBank;
import practice_crud_1_to_1.JPA_1_to_1.Model.Request.wooriBankRequest;
import practice_crud_1_to_1.JPA_1_to_1.Model.Response.wooriBankResponse;
import practice_crud_1_to_1.JPA_1_to_1.wooriService.wooriServices;

@RestController
@RequestMapping("/api/test")
public class controller {

	private final wooriServices serviceWBFM;
    @Autowired
	public controller(wooriServices serviceWBFM) {
		super();
		this.serviceWBFM = serviceWBFM;
	}
	@PostMapping
    public ResponseEntity<wooriBankResponse> addData(@RequestBody wooriBankRequest wbfmReq) throws Exception{
    	wooriBank newWBFM = this.serviceWBFM.serviceWooriBank(wbfmReq);
    	return ResponseEntity.ok(wooriBankResponse.wbfmResponse(newWBFM));
    }
    @GetMapping
    public ResponseEntity<List<wooriBankResponse>> listData(){
    	List<wooriBankResponse> myListing = this.serviceWBFM.listing().stream().map(wooriBankResponse::wbfmResponse).toList();
    	return ResponseEntity.ok(myListing);
    }
    @GetMapping("/{id}")
    public ResponseEntity<wooriBankResponse> findById(@PathVariable Long id) throws Exception{
    	wooriBank findMe = this.serviceWBFM.findDataOne(id);
    	return ResponseEntity.ok(wooriBankResponse.wbfmResponse(findMe));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<wooriBankResponse> updateList(@PathVariable Long id, wooriBankRequest req) throws Exception{
    	wooriBank updateMe = this.serviceWBFM.updateData(id, req);
    	return ResponseEntity.ok(wooriBankResponse.wbfmResponse(updateMe));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletefield(@PathVariable Long id) throws Exception{
    	Map<String, Object> removeField = new HashMap<String, Object>();
    	removeField.put("message", "Delete success");
    	 this.serviceWBFM.deleteData(id);
    	return ResponseEntity.ok(removeField);
    }
}
