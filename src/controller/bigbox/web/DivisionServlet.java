package controller.bigbox.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.bigbox.web.Division;
import db.bigbox.web.DAOFactory;
import divisions.bigbox.web.DivisionDAO;


// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class DivisionServlet.
 */
@WebServlet({ "/DivisionServlet", "/divisions" })
public class DivisionServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new division servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public DivisionServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DivisionDAO DivisionDAO = DAOFactory.getDivisionDAO();
		String inStore;
		String inDIV;
		ArrayList<Division> divisions = DivisionDAO.getDivisions();
		String divisionNumber = request.getParameter("divisionNumber");
		String Name = request.getParameter("Name");
		String Address = request.getParameter("Address");
		String City = request.getParameter("City");
		String State = request.getParameter("State");
		String ZipCode = request.getParameter("ZipCode");

		// Store s = new Store();
		request.setAttribute("divisions", divisions);
		String url = "/division.jsp";

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
