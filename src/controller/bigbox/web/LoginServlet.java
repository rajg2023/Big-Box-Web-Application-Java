
package controller.bigbox.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new login servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		PrintWriter out = response.getWriter();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		UserDAO UserDAO = DAOFactory.getUsersDAO();
		ArrayList<User> users = UserDAO.getUsers();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		/*
		 * System.out.println("Welcome "+userName);
		 * request.setAttribute("users", users); String url = "/login.html";
		 * 
		 * getServletContext().getRequestDispatcher(url). forward(request,
		 * response);
		 */
		if (UserDAO.loginUser(username, password)) {
			RequestDispatcher rd = request.getRequestDispatcher("/home.html");
			rd.forward(request, response);
		} else {

			out.print("Sorry username or password error");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}

		out.close();
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
