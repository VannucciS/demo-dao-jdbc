package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Seller implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String email;
	private Date BirthDate;
	private double baseSalary;

	private Department department;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthDate() {
		return BirthDate;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Seller(int id, String name, String email, Date birthDate, double baseSalary, Department department) {
		this.id = id;
		this.name = name;
		this.email = email;
		BirthDate = birthDate;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + ", email=" + email + ", BirthDate=" + BirthDate + ", baseSalary="
				+ baseSalary + ", department=" + department + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		return id == other.id;
	}
}
