package springmvc.model.dao;

import java.util.List;

import springmvc.model.Application;

public interface ApplicationDao {

	Application getApp( Integer id );
	
	List<Application> getApplications();
	
	Application saveApplication (Application app);
}
