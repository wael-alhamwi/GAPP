package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Additional_Requirements;
import springmvc.model.dao.AdditionalDao;

@Repository
public class AdditionalDaoImpl implements AdditionalDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Additional_Requirements getAdditionalReq( Integer id )
    {
        return entityManager.find( Additional_Requirements.class, id );
    }

    @Override
    public List<Additional_Requirements> getAdditionalReqs()
    {
        return entityManager.createQuery( "from Additional_Requirements order by id", Additional_Requirements.class ).getResultList();
    }

	@Override
	@Transactional
	public Additional_Requirements saveRequirement(Additional_Requirements req) {
		return entityManager.merge(req);
	}

	@Override
	@Transactional
	public void removeAdditionalReq(Additional_Requirements req) {
		entityManager.remove(req);
	}

}
