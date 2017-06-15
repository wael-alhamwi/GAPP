package springmvc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "requirements")
public class Additional_Requirements implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Integer id;
    
    private String nameOfField;
    
    private String typeOfField;
    
    private String isRequired;
    
    @ManyToOne
    private Department additionalReqOwner;

    public Additional_Requirements()
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

	public String getNameOfField() {
		return nameOfField;
	}

	public void setNameOfField(String nameOfField) {
		this.nameOfField = nameOfField;
	}

	public String getTypeOfField() {
		return typeOfField;
	}

	public void setTypeOfField(String typeOfField) {
		this.typeOfField = typeOfField;
	}

	public Department getAdditionalReqOwner() {
		return additionalReqOwner;
	}

	public void setAdditionalReqOwner(Department additionalReqOwner) {
		this.additionalReqOwner = additionalReqOwner;
	}

	public String getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}

}

