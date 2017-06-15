package springmvc.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Integer id;
    
    @OneToOne
    private User stdUser;

    @Embedded
    private StudentPrvtInfo studentPersonalInfo;

	public User getStdUser() {
		return stdUser;
	}

	public void setStdUser(User stdUser) {
		this.stdUser = stdUser;
	}

    public Student()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

	public StudentPrvtInfo getStudentPersonalInfo() {
		return studentPersonalInfo;
	}

	public void setStudentPersonalInfo(StudentPrvtInfo studentPersonalInfo) {
		this.studentPersonalInfo = studentPersonalInfo;
	}

}