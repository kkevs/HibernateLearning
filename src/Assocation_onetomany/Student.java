package Assocation_onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	private String studentName;
	private String studentSurname;

	@ManyToOne(cascade = CascadeType.ALL)
	private University university;

	public Student(String studentName, String studentSurname) {
		this.studentName = studentName;
		this.studentSurname = studentSurname;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSurname() {
		return studentSurname;
	}

	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}

}
