package com.ghobrial.talmza.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@Table(name = "Subject")
@DynamicInsert
@DynamicUpdate
@Data
public class Subject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Basic(optional = false)
	private String name;

	@Basic(optional = false)
	private int max;

	@Basic(optional = false)
	private int min;

	@Basic(optional = false)
	private String teachBy;

	@Basic(optional = false)
	private String term;

	@OneToMany(mappedBy = "subject")
	private Set<StudentSubject> studentSubjects;

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
