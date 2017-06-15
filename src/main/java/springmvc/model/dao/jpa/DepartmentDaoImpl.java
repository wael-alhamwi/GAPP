package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Department;
import springmvc.model.dao.DepartmentDao;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Department getDep( Integer id )
    {
        return entityManager.find( Department.class, id );
    }

    @Override
    public List<Department> getDepartments()
    {
        return entityManager.createQuery( "from Department order by id", Department.class ).getResultList();
    }

	@Override
	@Transactional
	public Department saveDepartment(Department dept) {
		return entityManager.merge(dept);
	}

	@Override
	@Transactional
	public void removeDepartment(Department dept) {
		entityManager.remove(dept);		
	}	
}
