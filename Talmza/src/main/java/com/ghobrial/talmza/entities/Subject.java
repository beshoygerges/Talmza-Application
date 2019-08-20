package com.ghobrial.talmza.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Subject")
public class Subject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private int max;

	private int min;

	private String teachBy;

	private String term;

	@OneToMany(mappedBy = "subject")
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

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public String getTeachBy() {
		return teachBy;
	}

	public void setTeachBy(String teachBy) {
		this.teachBy = teachBy;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + max;
		result = prime * result + min;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((teachBy == null) ? 0 : teachBy.hashCode());
		result = prime * result + ((term == null) ? 0 : term.hashCode());
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
		Subject other = (Subject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (max != other.max)
			return false;
		if (min != other.min)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (teachBy == null) {
			if (other.teachBy != null)
				return false;
		} else if (!teachBy.equals(other.teachBy))
			return false;
		if (term == null) {
			if (other.term != null)
				return false;
		} else if (!term.equals(other.term))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", max=" + max + ", min=" + min + ", teachBy=" + teachBy
				+ ", term=" + term + "]";
	}

}
