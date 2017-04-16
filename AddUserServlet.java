package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddQuery;
import dbHelpers.AddUser;
import model.Product;
import models.User;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
 		
 		//create a product object
 		User user = new User();
 		user.setEmail(email);
 		user.setUpwd(upwd);
 		
 		//create an add query object
 		AddUser au = new AddUser("fakenews", "root", "root");
 		
 		//pass the book to addQuery to add to the database
 		au.doAdd(user);
 		
 		//pass execution control to the ReadServlet
 		String url = "/read";
 		
 		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
 		dispatcher.forward(request, response);
 		
 	}

}
