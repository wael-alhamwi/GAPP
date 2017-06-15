package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Program;
import springmvc.model.dao.ProgramDao;

@Repository
public class ProgramDaoImpl implements ProgramDao {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public Program getProgram(Integer id) {
		return entityManager.find( Program.class, id );
	}

	@Override
	public List<Program> getPrograms() {
		return entityManager.createQuery( "from Program order by id", Program.class ).getResultList();
		
	}

	@Override
	@Transactional
	public Program saveProgram(Program prog) {
		return entityManager.merge(prog);
	}

	@Override
	@Transactional
	public void removeProgram(Program prog) {
		entityManager.remove(prog);
	}
   
}
