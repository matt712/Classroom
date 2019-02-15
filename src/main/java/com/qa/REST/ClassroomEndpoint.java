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
import com.qa.businessService.ClassroomService;

@Path("/classroom")
public class ClassroomEndpoint {
	@Inject
	private ClassroomService serv;

	public void setService(ClassroomService serv2) {
		this.serv =serv2;
	}
	@Path("/getAClassroom/{id}")
	@GET
	@Produces({"application/json"})
	public String getAClassroom(int id)
	{
		return serv.getAClassroom(id);
	}
	@Path("/getAllClassrooms")
	@GET
	@Produces("application/json")
	public String getallClassrooms()
	{
		return serv.getAllClassrooms();
	}
	@Path("/updateClassroom/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateClassroom(int id, String classroom)
	{
		return serv.updateClassroom(id, classroom);
	}
	@Path("/createClassroom")
	@POST
	@Produces("application/json")
	public String createClassroom(String classroom)
	{
		return serv.createClassroom(classroom);
	}
	@Path("/deleteClassroom/{id}")
	@POST
	@Produces({"application/json"})
	public String deleteClassroom(int id)
	{
		return serv.deleteClassrooms(id);
	}
}
