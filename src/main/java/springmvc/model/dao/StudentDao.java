package springmvc.model.dao;
import java.util.List;

import springmvc.model.Student;
public interface StudentDao {

	Student getStudent( Integer id );

    List<Student> getStudents();
    
    Student getStudentUsingUID( Integer id );
    
}