package springmvc.model;

import javax.persistence.Embeddable;

@Embeddable
public class Degree {

    private String university;
    
    private String periodOfAttendence;
    
    private String degree;
    
    private String major;

    public Degree()
    {
    }

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getPeriodOfAttendence() {
		return periodOfAttendence;
	}

	public void setPeriodOfAttendence(String periodOfAttendence) {
		this.periodOfAttendence = periodOfAttendence;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
}