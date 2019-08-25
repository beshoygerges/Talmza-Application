package com.ghobrial.talmza.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@DynamicInsert
@DynamicUpdate
@Data
public class Meeting implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Basic(optional = false)
	@Temporal(TemporalType.DATE)
	private Date localDate = new Date();

	@Basic(optional = false)
	@Temporal(TemporalType.TIME)
	private Date localTime = new Date();

	@Basic(optional = false)
	private String location;

	@OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
	private Set<StudentMeeting> meetingStudent = new HashSet<>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localDate == null) ? 0 : localDate.hashCode());
		result = prime * result + ((localTime == null) ? 0 : localTime.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
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
		Meeting other = (Meeting) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localDate == null) {
			if (other.localDate != null)
				return false;
		} else if (!localDate.equals(other.localDate))
			return false;
		if (localTime == null) {
			if (other.localTime != null)
				return false;
		} else if (!localTime.equals(other.localTime))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Meeting [id=" + id + ", localDate=" + localDate + ", localTime=" + localTime + ", location=" + location
				+ "]";
	}

}
