package com.qa.repository;


public interface ClassroomRepository {
	//C
	String createClassRoom(String classroom);
	//R
	String getAllClassRooms();
	String getAClassRoom(int id);
	//U
	String updateClassRoom(int id, String classroom);
	//D
	String deleteClassRoom(int id);
}
