package springmvc.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Academic {
	
    private double TOEFL;
    
    private double GRE;
    
    private double GPA;

	@ManyToOne
    private StudentEduInfo owner;

    public Academic()
    {
    }

	public double getTOEFL() {
		return TOEFL;
	}

	public void setTOEFL(double tOEFL) {
		TOEFL = tOEFL;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public double getGRE() {
		return GRE;
	}

	public void setGRE(double gRE) {
		GRE = gRE;
	}

	public StudentEduInfo getOwner() {
		return owner;
	}

	public void setOwner(StudentEduInfo owner) {
		this.owner = owner;
	}

}