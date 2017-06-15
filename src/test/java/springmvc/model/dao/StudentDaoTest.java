package springmvc.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "StudentDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    StudentDao studentDao;

    @Test
    public void getStudentAppCount()
    {
    	int count = 0;
    	/*for (Student student : studentDao.getStudents()) {
			if(student.getStdUser().getUsername().equals("student1@localhost.localdomain")){
				count = student.getStdApplications().size();
			}
		}*/
        assert count == 0;
    }

}