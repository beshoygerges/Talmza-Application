package com.ghobrial.talmza.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@DynamicInsert
@DynamicUpdate
@Data
public class StudentMeeting implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumn(name = "StudentId")
	@ManyToOne
	private Student student;

	@Id
	@JoinColumn(name = "MeetingId")
	@ManyToOne
	private Meeting meeting;

	@Basic(optional = false)
	private Date attendenceDate = new Date();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attendenceDate == null) ? 0 : attendenceDate.hashCode());
		result = prime * result + ((meeting == null) ? 0 : meeting.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		StudentMeeting other = (StudentMeeting) obj;
		if (attendenceDate == null) {
			if (other.attendenceDate != null)
				return false;
		} else if (!attendenceDate.equals(other.attendenceDate))
			return false;
		if (meeting == null) {
			if (other.meeting != null)
				return false;
		} else if (!meeting.equals(other.meeting))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentMeeting [student=" + student + ", meeting=" + meeting + ", attendenceDate=" + attendenceDate
				+ "]";
	}

}
