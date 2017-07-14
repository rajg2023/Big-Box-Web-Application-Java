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
import stores.bigbox.web.StoreDAO;
import divisions.bigbox.web.DivisionDAO;
import storesales.bigbox.web.StoreSalesDAO;


// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class DeleteServlet.
 */
@WebServlet({ "/DeleteServlet", "/delete" })
public class DeleteServlet extends HttpServlet {
	
	/** The divisions ID map. */
	private static HashMap<String, Division> divisionsIDMap = new HashMap<String, Division>();
	
	/** The divisions nbr map. */
	private static HashMap<String, Division> divisionsNbrMap = new HashMap<String, Division>();
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Store DAO. */
	private StoreDAO StoreDAO = null;
	
	/** The Division DAO. */
	private DivisionDAO DivisionDAO = null;
	
	/** The Store sales DAO. */
	private StoreSalesDAO StoreSalesDAO = null;

	/**
	 * Instantiates a new delete servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
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
		StoreDAO = DAOFactory.getStoreDAO();
		DivisionDAO = DAOFactory.getDivisionDAO();
		StoreSalesDAO = DAOFactory.getStoreSalesDAO();
		populateDivisionsMap();
		String inDiv = null;
		String inStore = null;
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url = "/deletestore.html";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("list")) {
			url = "/deletestore.html";
		} else if (action.equalsIgnoreCase("delete")) {
			Store s = StoreDAO.getStore(inDiv, inStore);
			stores.bigbox.web.StoreDAO StoreDAO = DAOFactory.getStoreDAO();
			Store store = null;
			inDiv = request.getParameter("divisionnumber");
			Division d = divisionsNbrMap.get(inDiv);
			inStore = request.getParameter("storenumber");
			// use the constructor which accepts the below + a divisionid
			// TODO start here!
			StoreDAO.deleteStore(s);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/*
	 * Populate both Division HashMaps from all divisions in the db
	 */

	/**
	 * Populate divisions map.
	 */
	private static void populateDivisionsMap() {
		divisions.bigbox.web.DivisionDAO DivisionDAO = DAOFactory.getDivisionDAO();
		ArrayList<Division> divisions = DivisionDAO.getDivisions();
		for (Division d : divisions) {
			divisionsIDMap.put(d.getId(), d);
			divisionsNbrMap.put(d.getDivisionNumber(), d);

		}
	}

}
