package springmvc.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "studentsedu")
public class StudentEduInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
	private Integer id;
	
	@Embedded
    private Degree degree;
    
	@Embedded
    private Academic academic;
	
	@ManyToOne
	private Application infoOwner;

    public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public Academic getAcademic() {
		return academic;
	}

	public void setAcademic(Academic academic) {
		this.academic = academic;
	}

	public Application getInfoOwner() {
		return infoOwner;
	}

	public void setInfoOwner(Application infoOwner) {
		this.infoOwner = infoOwner;
	}

	public StudentEduInfo()
    {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}