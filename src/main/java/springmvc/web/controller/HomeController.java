package springmvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.dao.UserDao;

@Controller
public class HomeController {

	@Autowired
    private UserDao userDao;
	
    @RequestMapping("/home.html")
    public String index()
    {
        return "home";
    }
    
    @RequestMapping("/user/staff.html")
    public String staffPage()
    {
        return "user/staff";
    }
    
    @RequestMapping("/user/student.html")
    public String studentPage(@RequestParam Integer id, ModelMap models)
    {
    	models.put("student", userDao.getUser(id));
        return "user/student";
    }
    
    @RequestMapping("/user/application.html")
    public String appPage()
    {
        return "user/application";
    }
    
    @RequestMapping(value = "home.html", method = RequestMethod.POST)
    public String signin(@RequestParam String username, @RequestParam String password){
    	if (userDao.existUser(username, password)) {
    		
    		if (userDao.getUserRole(username).equals("student")) {
    			return "redirect:user/student.html?id="+userDao.getUserID(username);
			}
    		if (userDao.getUserRole(username).equals("administrator")) {
    			return "redirect:user/admin.html";
			}
    		if (userDao.getUserRole(username).equals("staff")) {
    			return "redirect:user/staff.html";
			}
    		return "home";
		} else {
			return "home";
		}
    }
    
    
}
