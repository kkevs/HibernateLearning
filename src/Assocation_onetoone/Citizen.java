package Assocation_onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Citizen {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int citizen_id;
	private String name;
	private String surname;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private CitizenAddress citizenAddress;

	public CitizenAddress getCitizenAddress() {
		return citizenAddress;
	}

	public void setCitizenAddress(CitizenAddress citizenAddress) {
		this.citizenAddress = citizenAddress;
	}

	public int getCitizen_id() {
		return citizen_id;
	}

	public void setCitizen_id(int citizen_id) {
		this.citizen_id = citizen_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
