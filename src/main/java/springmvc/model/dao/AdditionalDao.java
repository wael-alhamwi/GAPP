package springmvc.model.dao;

import java.util.List;

import springmvc.model.Additional_Requirements;

public interface AdditionalDao {

	 Additional_Requirements getAdditionalReq( Integer id );

	    List<Additional_Requirements> getAdditionalReqs();

	    Additional_Requirements saveRequirement (Additional_Requirements req);
	    
	    void removeAdditionalReq (Additional_Requirements req);
}