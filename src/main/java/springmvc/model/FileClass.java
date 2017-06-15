package springmvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class FileClass implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue
	private Integer id;
	
    private String fileName;
	
	private String type;
	
	private Long size;

    private Date date;

    @ManyToOne
    private Application fileAppOwner;
    
    @ManyToOne
    private User fileUserOwner;

    public User getFileUserOwner() {
		return fileUserOwner;
	}

	public void setFileUserOwner(User fileUserOwner) {
		this.fileUserOwner = fileUserOwner;
	}

	public Application getFileAppOwner() {
		return fileAppOwner;
	}

	public void setFileAppOwner(Application fileOwner) {
		this.fileAppOwner = fileOwner;
	}

	public FileClass()
    {
    }

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}