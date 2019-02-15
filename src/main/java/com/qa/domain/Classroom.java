package com.qa.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String trainer;
	@OneToMany(mappedBy="classroom")
	private Set<Trainee> trainees;
	public Classroom(int newId, String trainerName) 
	{
		setId(newId);
		setTrainer(trainerName);
	}
	public String getTrainer() 
	{
		return trainer;
	}
	public void setTrainer(String trainerName) 
	{
		this.trainer = trainerName;
	}
	public void addTrainee(Trainee newTrainee) 
	{
		trainees.add(newTrainee);
	}
	public int getId() {
		return id;
	}
	public void setId(int newId) {
		this.id = newId;
	}
}