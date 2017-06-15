package springmvc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "application")
public class Application implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String term;

	private String status;

	private Date submitDate;

	@OneToOne
	private Program progAppOwner;

	@OneToOne
	private Department deptAppOwner;

	@OneToOne
	private Student stdAppOwner;

	@OneToMany(mappedBy = "infoOwner")
	private List<StudentEduInfo> studentEducationInfo;

	@OneToMany(mappedBy = "fileAppOwner")
	private List<FileClass> files;

	public Application() {
		this.studentEducationInfo = new ArrayList<StudentEduInfo>();
		this.files = new ArrayList<FileClass>();
	}

	public List<StudentEduInfo> getStudentEducationInfo() {
		return studentEducationInfo;
	}

	public void setStudentEducationInfo(StudentEduInfo studentEducationInfo) {
		this.studentEducationInfo.add(studentEducationInfo);
	}

	public Program getProgAppOwner() {
		return progAppOwner;
	}

	public void setProgAppOwner(Program progAppOwner) {
		this.progAppOwner = progAppOwner;
	}

	public Department getDeptAppOwner() {
		return deptAppOwner;
	}

	public void setDeptAppOwner(Department deptAppOwner) {
		this.deptAppOwner = deptAppOwner;
	}

	public Student getStdAppOwner() {
		return stdAppOwner;
	}

	public void setStdAppOwner(Student stdAppOwner) {
		this.stdAppOwner = stdAppOwner;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public boolean isSubmitted() {
		return submitDate != null && submitDate.before(new Date());
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<FileClass> getFiles() {
		return files;
	}

	public void setFile(FileClass file) {
		this.files.add(file);
	}

	public FileClass getFile(Integer fileID) {
		for (FileClass file : getFiles()) {
			if (file.getId() == fileID) {
				return file;
			}
		}
		return null;
	}
}
