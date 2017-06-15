package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.User;
import springmvc.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUser( Integer id )
    {
        return entityManager.find( User.class, id );
    }

    @Override
    public List<User> getUsers()
    {
        return entityManager.createQuery( "from User order by id", User.class ).getResultList();
    }

	@Override
	@Transactional
	public User saveUser(User user) {
		return entityManager.merge(user);
	}

	@Override
	public boolean ValidateUser(String username, String password) {
		if (username.isEmpty() || password.isEmpty()) {
			return false;
		} else {
			for (User user : this.getUsers()) {
				// Check if user exist Validating with case-insensitive
				if (user.getUsername().toUpperCase().equals(username.toUpperCase())) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean existUser(String username, String password) {
		if (username.isEmpty() || password.isEmpty()) {
			return false;
		} else {
			for (User user : this.getUsers()) {
				// Check if user exist Validating with case-insensitive
				if (user.getUsername().toUpperCase().equals(username.toUpperCase())) {
					if (user.getPassword().equals(password)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public String getUserRole(String username) {

		for (User user : this.getUsers()) {
			// Get user role
			if (user.getUsername().toUpperCase().equals(username.toUpperCase())) {
				return user.getRole();
			}
		}
		return null;
	}
	
	

	@Override
	@Transactional
	public void removeUser(User user) {
		entityManager.remove(user);
	}

	@Override
	public Integer getUserID(String username) {
		for (User user : this.getUsers()) {
			// Get user ID
			if (user.getUsername().toUpperCase().equals(username.toUpperCase())) {
				return user.getId();
			}
		}
		return null;
	}

}
