package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.FileClass;
import springmvc.model.dao.FileDao;

@Repository
public class FileDaoImpl implements FileDao{
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	@Transactional
	public FileClass saveFile(FileClass file) {
		return entityManager.merge( file );
	}

	@Override
	public List<FileClass> getFiles(Long id) {
		return entityManager.createQuery("from FileClass WHERE fileOwner.id = :id ", FileClass.class).setParameter("id", id).getResultList();
	}

	@Override
	public List<String> getFileNames(Integer id) {
		return entityManager.createQuery("SELECT fileName from File WHERE fileOwner.id = :id", String.class).setParameter("id", id).getResultList();
	}

	@Override
	public FileClass getFile(Integer id) {
		return entityManager.createQuery("from FileClass where id = :id", FileClass.class).setParameter("id", id).getSingleResult();
	}

	@Override
	@Transactional
	public void removeFile(FileClass file) {
		entityManager.remove(file);
	}

}
