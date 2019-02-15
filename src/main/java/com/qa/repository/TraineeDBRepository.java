package com.qa.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.domain.Trainee;
import com.qa.util.JSONUtil;

public class TraineeDBRepository implements TraineeRepository{
	private EntityManager em;
	private JSONUtil util;
	public String createTrainee(String newTraineeJson) {
		Trainee aTrainee = util.getObjectForJSON(newTraineeJson, Trainee.class);
		em.persist(aTrainee);
		return "{\"message\": \"Trainee created\"}";
	}
	public String getAllTrainees() {
		Query query = em.createQuery("Select a FROM Trainee a");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

	public String getATrainee(int id) {
		return util.getJSONForObject(em.find(Trainee.class, id));
	}

	public String updateTrainee(int id, String updatedTrainee) {
		deleteTrainee(id);
		createTrainee(updatedTrainee);
		return "{\"message\": \"Trainee updated\\\"}";
	}

	public String deleteTrainee(int id) {
		if(em.contains(em.find(Trainee.class, id)))
		{
			em.remove(em.find(Trainee.class, id));
		}
		return "{\"message\": \"Trainee successfully removed\"}";
	}
	public void setEm(EntityManager newEm) {
		this.em = newEm;
	}
	public void setUtil(JSONUtil newUtil) {
		this.util = newUtil;
	}

}
