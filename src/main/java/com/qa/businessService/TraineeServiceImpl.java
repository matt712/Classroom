package com.qa.businessService;

import com.qa.repository.TraineeRepository;
import com.qa.util.JSONUtil;

public class TraineeServiceImpl implements TraineeService{
	
	private TraineeRepository repo;
	private JSONUtil util;
	public String addTrainee(String trainee) {
		return repo.createTrainee(trainee);
	}

	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	public String getATrainee(int id) {
		return repo.getATrainee(id);
	}

	public String updateTrainee(int id, String trainee) {
		return repo.updateTrainee(id, trainee);
	}

	public String deleteTrainee(int id) {
		return repo.deleteTrainee(id);
	}

	public void setRepo(TraineeRepository repoNew) {
		this.repo = repoNew;
	}
	public void setUtil(JSONUtil utilNew)
	{
		this.util = utilNew;
	}
}
