package controller.bigbox.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.bigbox.web.StoreSales;
import db.bigbox.web.DAOFactory;
import storesales.bigbox.web.StoreSalesDAO;


// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class SaleServlet.
 */
@WebServlet({ "/StoreSaleServlet", "/storesales" })
public class StoreSaleServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new store sale servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreSaleServlet() {
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
		StoreSalesDAO StoreSalesDAO = DAOFactory.getStoreSalesDAO();
		ArrayList<StoreSales> storeSales = StoreSalesDAO.getStoreSales();
		String storeID = request.getParameter("storeID");
		String year = request.getParameter("year");
		String week = request.getParameter("week");
		String sales = request.getParameter("sales");

		// Store s = new Store();
		request.setAttribute("storeSales", storeSales);
		String url = "/storesales.jsp";

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
