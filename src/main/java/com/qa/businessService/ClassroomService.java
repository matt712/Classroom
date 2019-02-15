package com.qa.businessService;

import com.qa.repository.ClassroomRepository;
import com.qa.util.JSONUtil;

public interface ClassroomService 
{
	//C
	String createClassroom(String classroom);
	//R
	String getAllClassrooms();
	String getAClassroom(int id);
	//U
	String updateClassroom(int id, String classroom);
	//D
	String deleteClassrooms(int id);
	void setRepo(ClassroomRepository repo2);
	void setUtil(JSONUtil util2);
}
