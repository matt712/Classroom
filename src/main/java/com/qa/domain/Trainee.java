package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;

@Entity
public class Trainee 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int traineeID;
	@Column
	private String traineeName;
	@ManyToOne
	@JoinColumn(name = "id", nullable=false)
	private Classroom classroom;
	
	public Trainee(int id, String fullName) 
	{
		this.traineeID = id;
		setName(fullName);
	}
	public String getName() 
	{
		return traineeName;
	}
	public void setName(String newName) 
	{
		this.traineeName = newName;
	}
	public int getId() 
	{
		return traineeID;
	}
	public void setId(int newId)
	{
		this.traineeID = newId;
	}
}
