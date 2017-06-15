package springmvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applicationstatus")
public class ApplicationStatus implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Integer id;
    
    private String status;
    
    private Date timeOfChange;
    
    private String comment;
    
    @OneToOne
    private Application appOwner;

    public ApplicationStatus()
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

	public Date getTimeOfChange() {
		return timeOfChange;
	}

	public void setTimeOfChange(Date timeOfChange) {
		this.timeOfChange = timeOfChange;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
