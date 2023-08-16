package com.movieapp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieapp.model.User;
import com.movieapp.service.IUserService;
import com.movieapp.service.UserAlreadyExistException;
import com.movieapp.service.UserServiceImpl;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IUserService userService = new UserServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("signup.jsp");		
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setGender(request.getParameter("gender"));
		
		try {
			userService.addUser(user);
		} catch (UserAlreadyExistException e) {
			request.setAttribute("message", "User with the email already exists !");
		}
		
		request.setAttribute("message", "Signup successful!");
		
		doGet(request, response);
	}

}
