package springmvc.model.dao;

import java.util.List;

import springmvc.model.Department;

public interface DepartmentDao {
	
	 Department getDep( Integer id );

	 List<Department> getDepartments();
	 
	 Department saveDepartment (Department dept);
	    
	 void removeDepartment (Department dept);
	 
}
