package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddUser;
import dbHelpers.UserLoginQuery;
import models.User;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data
 		String email = request.getParameter("email");
 		String upwd = request.getParameter("upwd");
 		
 		//create a user object
 		User user = new User();
 		user.setEmail(email);
 		user.setUpwd(upwd);
 		
 		//create a user login object
 		UserLoginQuery ul = new UserLoginQuery("fakenews", "root", "root");
 		
 		//pass the user to userLogin to check the database
 		ul.doLogin(user);
 		
	}

}
