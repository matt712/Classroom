package com.qa.repository;

public interface TraineeRepository 
{
	//C
	String createTrainee(String newTraineeJson);
	//R
	String getAllTrainees();
	String getATrainee(int id);
	//U
	String updateTrainee(int id, String updatedTrainee);
	//D
	String deleteTrainee(int id);
}
