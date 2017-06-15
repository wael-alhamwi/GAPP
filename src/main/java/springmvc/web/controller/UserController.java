package springmvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import springmvc.model.User;
import springmvc.model.dao.UserDao;

@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/user/list.html")
    public String users( ModelMap models )
    {
        models.put( "users", userDao.getUsers() );
        return "user/list";
    }
    
    @RequestMapping("/user/remove.html")
	public String removeUser(@RequestParam Integer id ,ModelMap models )
	{
    	// Remove user by id
    	userDao.removeUser(userDao.getUser(id));
    	
    	// Update list of users
		models.put( "users", userDao.getUsers());
		return "user/list";
	}
    
    @RequestMapping("/user/details.html")
	public String userDetails(@RequestParam Integer id ,ModelMap models )
	{
		// get user by id
		models.put( "user", userDao.getUser(id));
		System.out.println("USERNAME: " + userDao.getUser(id).getUsername());
		return "user/details";
	}
    
    @RequestMapping(value = "/user/register.html", method = RequestMethod.GET)
    public String register(ModelMap models){
    	models.put("user", new User());
    	return "user/register";
    }
    
    @RequestMapping(value = "/user/register.html", method = RequestMethod.POST)
    public String register(@ModelAttribute User user){
    	
    	if (userDao.ValidateUser(user.getUsername(), user.getPassword())) {
    		//Saving user into database
        	user = userDao.saveUser(user);
        	
        	return "redirect:../home.html";
		} else {
			return "user/register";
		}
    }
    
    @RequestMapping(value = "/user/add.html", method = RequestMethod.GET)
    public String add(ModelMap models){
    	models.put("user", new User());
    	return "user/add";
    }
    
    @RequestMapping(value = "/user/add.html", method = RequestMethod.POST)
    public String add(@ModelAttribute User user){
    	
    	if (userDao.ValidateUser(user.getUsername(), user.getPassword())) {
    		//Saving user into database
        	user = userDao.saveUser(user);
        	
        	return "redirect:admin.html";
		} else {
			return "user/add";
		}
    }
    
    @RequestMapping(value = "/user/edit.html", method = RequestMethod.GET)
    public String edit(@RequestParam Integer id, ModelMap models){
    	models.put("user", userDao.getUser(id));
    	return "user/edit";
    }
    
    @RequestMapping(value = "/user/edit.html", method = RequestMethod.POST)
    public String edit(@ModelAttribute User user, SessionStatus status){
    	
    		//Saving user into database
        	user = userDao.saveUser(user);
        	
        	status.setComplete();
        	
        	return "redirect:list.html";
    }
    
}