package com.qa.businessService;

import com.qa.repository.ClassroomRepository;
import com.qa.util.JSONUtil;

public class ClassroomServiceImpl implements ClassroomService{

	private ClassroomRepository repo;
	private JSONUtil util;
	public String createClassroom(String classroom) {
		return repo.createClassRoom(classroom);
	}

	public String getAllClassrooms() {
		return repo.getAllClassRooms();
	}

	public String getAClassroom(int id) {
		return repo.getAClassRoom(id);
	}

	public String updateClassroom(int id, String classroom) {
		return repo.updateClassRoom(id, classroom);
	}

	public String deleteClassrooms(int id) {
		return repo.deleteClassRoom(id);
	}
	public void setUtil(JSONUtil util2)
	{
		this.util = util2;
	}
	public void setRepo(ClassroomRepository repo2) {
		this.repo = repo2;
	}
	
}
