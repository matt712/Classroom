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
import com.qa.domain.Classroom;
import com.qa.util.JSONUtil;


public class ClassroomDBRepository implements ClassroomRepository{
	private EntityManager em;
	private JSONUtil util;

	public String createClassRoom(String classroom) {
		Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class);
		em.persist(aClassroom);
		return "{\"message\": \"Classroom created\"}";
	}

	public String getAllClassRooms() {
		Query query = em.createQuery("Select a FROM Classroom a");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}

	public String getAClassRoom(int id) {
		return util.getJSONForObject(em.find(Classroom.class, id));
	}

	public String updateClassRoom(int id, String classroom) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteClassRoom(int id) {
		if(em.contains(em.find(Classroom.class, id)))
		{
			em.remove(em.find(Classroom.class, id));
		}
		return "{\"message\": \"Classroom successfully removed\"}";
	}

	public void setEm(EntityManager em) {
		this.em = em;
		
	}
	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
