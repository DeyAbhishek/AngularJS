package services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Standards;
import dao.StandardsDAO;
import util.JSONResponse;

@Path("/Standards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Services {

	@GET
	public List<Standards> getAllStandards(){
		JSONResponse jsonResp = new JSONResponse();
		List<Standards> lst = null;;
		try{
			StandardsDAO dao = new StandardsDAO();
			
			lst = dao.getAllStandards();
			jsonResp.setMsg("SUCCESS");
			jsonResp.setObject("standards", lst);
		}
		catch(Exception ex){
			ex.printStackTrace();
			jsonResp.setStatus("ERROR");
			jsonResp.setMsg(ex.getMessage());
		}
		//return jsonResp;
		return lst;
	}
	
	@POST	
	public List<Standards> addPerson(Standards standards){
		
		JSONResponse jsonResp = new JSONResponse();
		StandardsDAO dao = new StandardsDAO();
		try {
			
			
		     dao.addStandards(standards);
			jsonResp.setStatus("SUCCESS");
			//jsonResp.setObject("newStandards", newStandards);
			jsonResp.setMsg("New Standard has been added to the database.");
			
		} catch(Exception ex){
			ex.printStackTrace();
			jsonResp.setStatus("ERROR");
			jsonResp.setMsg(ex.getMessage());
		}
		
	//	return jsonResp;
		return dao.getAllStandards();
	}
	
	@DELETE
	@Path("/{chemicalID}")
	public void deleteStandard(@PathParam("chemicalID") String chemicalID){
		
		JSONResponse jsonResp = new JSONResponse();
		StandardsDAO dao = new StandardsDAO();
		try {
			
			
		     dao.deleteStandards(chemicalID);
			jsonResp.setStatus("SUCCESS");
			//jsonResp.setObject("newStandards", newStandards);
			jsonResp.setMsg("New Standard has been added to the database.");
			
		} catch(Exception ex){
			ex.printStackTrace();
			jsonResp.setStatus("ERROR");
			jsonResp.setMsg(ex.getMessage());
		}
		
	//	return jsonResp;
	//	return dao.getAllStandards();
	}
}
