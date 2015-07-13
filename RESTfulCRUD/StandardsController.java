package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Standards;
import dao.StandardsDAO;

/**
 * Servlet implementation class StandardsController
 */
@WebServlet("/StandardsController")
public class StandardsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String INSERT_OR_EDIT = "/popup.jsp";  //"/standards.jsp";
	private static String STANDARDS_LIST = "/listStandards.jsp";
	
	private StandardsDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StandardsController() {
        super();
        dao = new StandardsDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String forward="";
	        String action = request.getParameter("action");

	        if (action.equalsIgnoreCase("delete")){
	            String chemicalID = request.getParameter("chemical_id");
	            dao.deleteStandards(chemicalID);
	            forward = STANDARDS_LIST;
	            request.setAttribute("standards", dao.getAllStandards());    
	        } else if (action.equalsIgnoreCase("update")){
	            forward = INSERT_OR_EDIT;
	            String chemicalID = request.getParameter("chemical_id");
	            Standards standard = dao.getStandardsByChemicalID(chemicalID);
	            request.setAttribute("standard", standard);
	            request.setAttribute("standards", dao.getAllStandards());
	        } else if (action.equalsIgnoreCase("listStandards")){
	            forward = STANDARDS_LIST;
	            request.setAttribute("standards", dao.getAllStandards());
	        } else {
	           forward = INSERT_OR_EDIT;  //for insert
	        //	forward = "/popup.jsp";
	        	request.setAttribute("standards", dao.getAllStandards());
	        }

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Standards standards = new Standards();

	standards.setStatus(request.getParameter("status"));
	standards.setLocation(request.getParameter("location"));
	
	/*if(request.getParameter("chemical_id") == null || request.getParameter("chemical_id").isEmpty()){
		dao.addStandards(standards);
	}
	else{
	standards.setChemical_id(request.getParameter("chemical_id"));	
	dao.updateStandards(standards);
	}
	*/
	standards.setChemical_id(request.getParameter("chemical_id"));
	if(dao.checkStandardsExistsWithChemicalID(request.getParameter("chemical_id"))) 
		dao.updateStandards(standards);
	else
		dao.addStandards(standards);
	RequestDispatcher view  = request.getRequestDispatcher(STANDARDS_LIST);
	request.setAttribute("standards", dao.getAllStandards());
	view.forward(request, response);
	
    }

}
