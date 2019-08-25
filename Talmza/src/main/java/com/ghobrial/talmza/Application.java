package com.ghobrial.talmza;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ghobrial.talmza.entities.Student;
import com.ghobrial.talmza.utility.PersistenceManager;

public class Application {

	public static void main(String[] args) {

		EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();

		try {

			transaction.begin();

			Student student = new Student();

			student.setAddress("alex");

			student.setBirthdate(new Date());

			student.setClassStudy("youth");

			student.setMobileNumber("01205459968");

			student.setName("Beshoy gerges yacoub");

			student.setChurchFather("rewes morcos");

			student.setChurch("ghobrial");

			entityManager.persist(student);

			entityManager.getTransaction().commit();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

}
