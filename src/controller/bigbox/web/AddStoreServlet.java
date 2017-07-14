package controller.bigbox.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.bigbox.web.Division;
import business.bigbox.web.Store;
import db.bigbox.web.DAOFactory;
import divisions.bigbox.web.DivisionDAO;
import stores.bigbox.web.StoreDAO;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class AddStoreServlet.
 */
@WebServlet({ "/AddStoreServlet", "/addstore" })
public class AddStoreServlet extends HttpServlet {
	
	/** The divisions ID map. */
	// private static DivisionDAO DivisionDAO = null;
	private static HashMap<String, Division> divisionsIDMap = new HashMap<String, Division>();
	
	/** The divisions nbr map. */
	private static HashMap<String, Division> divisionsNbrMap = new HashMap<String, Division>();
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new adds the store servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStoreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		populateDivisionsMap();
		String url = "/addstore.html";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("list")) {
			url = "/addstore.html";
		} else if (action.equalsIgnoreCase("add")) {
			StoreDAO StoreDAO = DAOFactory.getStoreDAO();
			Store store = null;
			String inDiv = request.getParameter("divisionnumber");
			Division d = divisionsNbrMap.get(inDiv);
			String inStore = request.getParameter("storenumber");
			String inName = request.getParameter("name");
			String inAddress = request.getParameter("address");
			String inCity = request.getParameter("city");
			String inState = request.getParameter("state");
			String inZipCode = request.getParameter("zipCode");			 
			store = new Store(inStore, inName, inAddress, inCity, inState, inZipCode);
			StoreDAO.addStore(store);
			System.out.println("You have added the store successfully");
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);

	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		doGet(request, response);
	}
	/*
	 * Populate both Division HashMaps from all divisions in the db
	 */

	/**
	 * Populate divisions map.
	 */
	private static void populateDivisionsMap() {
		DivisionDAO DivisionDAO = DAOFactory.getDivisionDAO();
		ArrayList<Division> divisions = DivisionDAO.getDivisions();
		for (Division d : divisions) {
			divisionsIDMap.put(d.getId(), d);
			divisionsNbrMap.put(d.getDivisionNumber(), d);

		}
	}

}
