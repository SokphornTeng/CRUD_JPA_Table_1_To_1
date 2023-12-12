package practice_crud_1_to_1.JPA_1_to_1.wooriService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice_crud_1_to_1.JPA_1_to_1.Model.Entity.wooriBank;
import practice_crud_1_to_1.JPA_1_to_1.Model.Request.wooriBankRequest;
import practice_crud_1_to_1.JPA_1_to_1.Repo.wooriRepo;

@Service
public class wooriServices {

	private final wooriRepo wbRepository;
    @Autowired
	public wooriServices(wooriRepo wbRepository) {
		super();
		this.wbRepository = wbRepository;
	}
    
//    Create data or add data into table
    public wooriBank serviceWooriBank(wooriBankRequest reqwbfm) throws Exception {
    	
//    	wooriBank wbfm = this.wbRepository.save(reqwbfm.wbRequestMethod());
    	
    	wooriBank wbfm = reqwbfm.wbRequestMethod();
    	if(this.wbRepository.existsByStaff(wbfm.getStaff())) throw new Exception("staff name already exist");
    	
    	try {
    		return this.wbRepository.save(wbfm);
		} catch (Exception e) {
			throw new Exception(e);
		}
    }
    
//    List data all from table
    public List<wooriBank> listing(){
    	List<wooriBank> dataList = this.wbRepository.findAll();
    	return dataList;
    }

//    find by id one by one
    public wooriBank findDataOne(Long id) throws Exception {
    	return	this.wbRepository.findById(id).orElseThrow(() -> new Exception());
    }
   
//    update data
    public wooriBank updateData(Long id, wooriBankRequest req) throws Exception {
    	
    	wooriBank updateInfo = this.wbRepository.findById(id).orElseThrow(() -> new Exception());
    	
//    	check validate staff already exist
    	if(!Objects.equals(updateInfo.getStaff(), req.getStaff()))
    	if(this.wbRepository.existsByStaff(req.getStaff()))
    	throw new Exception();
    	
//    	prepare data
    	updateInfo.setStaff(req.getStaff());
    	updateInfo.setDept(req.getDept());
    	if(req.getBranches() == null) updateInfo.setBranches(null);
    	else updateInfo.setBranches(req.getBranches().reqBranchMethod(updateInfo));
    	
    
    	try {
    		return this.wbRepository.save(updateInfo);
		} catch (Exception e) {
			throw new Exception(e);
		}
    }
    
    // delete data
    public void deleteData(Long id) throws Exception {
  
    	try {
    	  	 this.wbRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception(e);
		}
    }
}
