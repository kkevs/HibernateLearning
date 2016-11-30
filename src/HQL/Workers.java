package HQL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "workers")
@NamedQuery(name = "Workers.byId", query = "from Workers where worker_id=?")
@NamedNativeQuery(name = "Workers.byName", query = "select * from workers where name=?", resultClass = Workers.class)
public class Workers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int worker_id;
	private String name;
	private String surname;
	private int salary;

	public Workers() {
		
	}

	public Workers(String name, String surname, int salary) {
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}

	public int getWorker_id() {
		return worker_id;
	}

	public void setWorker_id(int worker_id) {
		this.worker_id = worker_id;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
