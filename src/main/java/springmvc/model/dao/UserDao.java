package springmvc.model.dao;

import java.util.List;

import springmvc.model.User;

public interface UserDao {

    User getUser( Integer id );
    
    Integer getUserID( String username );

    List<User> getUsers();

    User saveUser (User user);
    
    void removeUser (User user);
    
    boolean ValidateUser (String username, String password);
    
    boolean existUser (String username, String password);
    
    String getUserRole (String username);
}