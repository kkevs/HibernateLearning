package Assocation_onetomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class University {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int universityId;
	private String universityName;
	private String faculty;
	private String department;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "newTable", joinColumns = @JoinColumn(name = "new_id"), inverseJoinColumns = @JoinColumn(name = "new_id2"))
	private Set<Student> studentRecord = new HashSet<Student>();

	public University(String universityName, String faculty, String department) {
		this.universityName = universityName;
		this.faculty = faculty;
		this.department = department;
	}

	public Set<Student> getStudentRecord() {
		return studentRecord;
	}

	public void setStudentRecord(Set<Student> studentRecord) {
		this.studentRecord = studentRecord;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
