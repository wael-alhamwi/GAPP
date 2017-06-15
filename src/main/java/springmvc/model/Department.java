package springmvc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    
    @OneToMany(mappedBy="programOwner")
    private List<Program> programs;
    
    @OneToMany(mappedBy="additionalReqOwner")
    private List<Additional_Requirements> requirements;

	public List<Additional_Requirements> getRequirements() {
		return requirements;
	}

	public void setRequirement(Additional_Requirements requirement) {
		this.requirements.add(requirement);
	}

	public Department()
    {
		this.programs = new ArrayList<Program>();
		this.requirements = new ArrayList<Additional_Requirements>();
    }
    
    public List<Program> getPrograms() {
		return programs;
	}

	public void setProgram(Program program) {
		this.programs.add(program);
	}

	public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
