package controller.bigbox.web;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class RegistrationServlet.
 */
@WebServlet({ "/RegistrationServlet", "/registration" })
public class RegistrationServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new registration servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
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
		PrintWriter out = response.getWriter();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		UserDAO UserDAO = DAOFactory.getUsersDAO();
		User u = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String FirstName = request.getParameter("firstname");
		String LastName = request.getParameter("lastname");
		String Phone = request.getParameter("phone");
		String Email = request.getParameter("email");
		u = new User(username, password, FirstName, LastName, Phone, Email);
		boolean users = UserDAO.addUser(u);
		request.setAttribute("users", users);
		String url = "/index.html";
		System.out.println("Youre registration is successful");
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
