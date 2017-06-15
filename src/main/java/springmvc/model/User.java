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
@Table(name = "users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Integer id;

    //email & username
    private String username;

	private String lastName;
    
    private String firstName;

	private String role;

    private String password;   

    private boolean enabled = true;
    
    @OneToMany(mappedBy="fileUserOwner")
    private List<FileClass> files;

    public List<FileClass> getFiles() {
		return files;
	}

	public void setFile(FileClass file) {
		this.files.add(file);
	}

	public User()
    {
    	this.files = new ArrayList<FileClass>();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public void setEnabled( boolean enabled )
    {
        this.enabled = enabled;
    }

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
