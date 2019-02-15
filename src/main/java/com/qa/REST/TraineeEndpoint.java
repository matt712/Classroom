package com.qa.REST;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.apache.log4j.Logger;
import com.qa.businessService.TraineeService;

@Path("/trainee")
public class TraineeEndpoint 
{
	@Inject
	private TraineeService serv;

	public void setService(TraineeService serv2) {
		this.serv =serv2;
	}
	@Path("/createTrainee")
	@POST
	@Produces({"application/json"})
	public String addTrainee(String trainee) {
		return serv.addTrainee(trainee);
	}
	@Path("/getAllTrainees")
	@GET
	@Produces("application/json")
	public String getAllTrainees() {
		return serv.getAllTrainees();
	}
	@Path("/getATrainee/{id}")
	@GET
	@Produces({"application/json"})
	public String getATrainee(int id) {
		return serv.getATrainee(id);
	}
	@Path("/updateTrainee/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateTrainee(int id, String trainee) {
		return serv.updateTrainee(id, trainee);
	}
	@Path("/deleteTrainee/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteTrainee(int id) {
		return serv.deleteTrainee(id);
	}
}
