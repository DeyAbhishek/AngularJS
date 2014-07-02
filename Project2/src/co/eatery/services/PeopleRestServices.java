package co.prvn.eatery.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.prvn.eatery.dao.PeopleDAO;
import co.prvn.eatery.entities.PersonVO;
import co.prvn.eatery.exception.EateryException;
import co.prvn.eatery.utils.JSONResponse;

@Path("/people")
public class PeopleRestService {

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse getAllPeople(){
		
		JSONResponse jsonResp = new JSONResponse();
		
		try {
			PeopleDAO dao = new PeopleDAO();
			List<PersonVO> peopleList;
			
			peopleList = dao.getAllPeople();
			jsonResp.setStatus("SUCCESS");
			jsonResp.setObject("people", peopleList);
			
		} catch (EateryException e) {
			e.printStackTrace();
			jsonResp.setStatus("ERROR");
			jsonResp.setMsg(e.getMessage());
		}
		
		return jsonResp;
	}
	
	
	// rest/people/getPerson/101
	@GET
	@Path("/getPerson/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse getPerson(@PathParam("id") int personId){
		
		JSONResponse jsonResp = new JSONResponse();
		
		try {
			PeopleDAO dao = new PeopleDAO();
			
			PersonVO person = dao.getPerson(personId);
			jsonResp.setStatus("SUCCESS");
			jsonResp.setObject("person", person);
			
		} catch (EateryException e) {
			e.printStackTrace();
			jsonResp.setStatus("ERROR");
			jsonResp.setMsg(e.getMessage());
		}
		
		return jsonResp;
	}
	
	// rest/people/getPersonParam?id=101&firstName=PRVN
	
	@GET
	@Path("/getPersonParam")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse getPersonByParams(@QueryParam("id") int personId, @QueryParam("firstName") String firstName){
		
		JSONResponse jsonResp = new JSONResponse();
		
		return jsonResp;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONResponse addPerson(PersonVO person){
		
		JSONResponse jsonResp = new JSONResponse();
		
		try {
			PeopleDAO dao = new PeopleDAO();
			
			PersonVO newPerson = dao.addPerson(person);
			jsonResp.setStatus("SUCCESS");
			jsonResp.setObject("newPerson", newPerson);
			jsonResp.setMsg("New Person has been added to the database.");
			
		} catch (EateryException e) {
			e.printStackTrace();
			jsonResp.setStatus("ERROR");
			jsonResp.setMsg(e.getMessage());
		}
		
		return jsonResp;
	}
	
	//editPerson
	//deletePerson
}
