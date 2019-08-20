package com.ghobrial.talmza.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String mobileNumber;

	private String homeNumber;

	private String address;

	private Date birthdate;

	private String church;

	private String churchFather;

	private String classStudy;

	@OneToMany(mappedBy = "student")
	private Set<StudentSubject> studentSubjects;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getChurch() {
		return church;
	}

	public void setChurch(String church) {
		this.church = church;
	}

	public String getChurchFather() {
		return churchFather;
	}

	public void setChurchFather(String churchFather) {
		this.churchFather = churchFather;
	}

	public String getClassStudy() {
		return classStudy;
	}

	public void setClassStudy(String classStudy) {
		this.classStudy = classStudy;
	}

	public Set<StudentSubject> getStudentSubjects() {
		return studentSubjects;
	}

	public void setStudentSubjects(Set<StudentSubject> studentSubjects) {
		this.studentSubjects = studentSubjects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((church == null) ? 0 : church.hashCode());
		result = prime * result + ((churchFather == null) ? 0 : churchFather.hashCode());
		result = prime * result + ((classStudy == null) ? 0 : classStudy.hashCode());
		result = prime * result + ((homeNumber == null) ? 0 : homeNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (church == null) {
			if (other.church != null)
				return false;
		} else if (!church.equals(other.church))
			return false;
		if (churchFather == null) {
			if (other.churchFather != null)
				return false;
		} else if (!churchFather.equals(other.churchFather))
			return false;
		if (classStudy == null) {
			if (other.classStudy != null)
				return false;
		} else if (!classStudy.equals(other.classStudy))
			return false;
		if (homeNumber == null) {
			if (other.homeNumber != null)
				return false;
		} else if (!homeNumber.equals(other.homeNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", homeNumber=" + homeNumber
				+ ", address=" + address + ", birthdate=" + birthdate + ", church=" + church + ", churchFather="
				+ churchFather + ", classStudy=" + classStudy + "]";
	}

}
