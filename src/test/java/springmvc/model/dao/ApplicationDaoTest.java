package springmvc.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;


@Test(groups = "ApplicationDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ApplicationDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    ApplicationDao appDao;

    @Test
    public void getApplicationsCount()
    {
    	int count = 0;
    	/*for (Application app : appDao.getApplications()) {
    		System.out.println("Department owner is:" + app.getProgAppOwner().getProgramOwner().getName());
			if (app.getProgAppOwner().getProgramOwner().getName().equals("Accounting Department") && app.getTerm().equals("Fall 2016")){
				count++;
			}
		}*/
    	
    	System.out.println("Count is: " + count);
        assert count == 0;
    }
}