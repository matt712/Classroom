package com.qa.businessService;

import com.qa.repository.TraineeRepository;

public interface TraineeService 
{
	//C
	String addTrainee(String trainee);
	//R
	String getAllTrainees();
	String getATrainee(int id);
	//U
	String updateTrainee(int id, String trainee);
	//D
	String deleteTrainee(int id);
	//Set method
	void setRepo(TraineeRepository repoNew);
}
