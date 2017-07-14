package controller.bigbox.web;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.bigbox.web.User;
import db.bigbox.web.DAOFactory;
import users.bigbox.web.UserDAO;
 

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class UserServlet.
 */
@WebServlet({ "/UserServlet", "/users" })
public class UserServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new user servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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
		UserDAO UserDAO = DAOFactory.getUsersDAO();
		ArrayList<User> users = UserDAO.getUsers();
		String userName = request.getParameter("UserName");
		String password = request.getParameter("Password");
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String phone = request.getParameter("Phone");
		String email = request.getParameter("Email");

		// Store s = new Store();
		request.setAttribute("users", users);
		String url = "/user.jsp";

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
