package controller.bigbox.web;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.bigbox.web.Store;
import db.bigbox.web.DAOFactory;
import stores.bigbox.web.StoreDAO;
 

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class StoresServlet.
 */
@WebServlet({ "/StoresServlet", "/stores" })
public class StoreServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	// private StoreDAO StoreDAO = null;

	/**
	 * Instantiates a new store servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreServlet() {
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		StoreDAO StoreDAO = DAOFactory.getStoreDAO();
		ArrayList<Store> stores = StoreDAO.getStores();
		String inDiv = null;
		String divisionID = request.getParameter("divisionID");
		String storeNumber = request.getParameter("storeNumber");
		String Name = request.getParameter("storeName");
		String Address = request.getParameter("Address");
		String City = request.getParameter("City");
		String State = request.getParameter("State");
		String ZipCode = request.getParameter("ZipCode");
		// Store s = new Store();
		request.setAttribute("stores", stores);
		String url = "/store.jsp";

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

}
