package com.movieapp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movieapp.exception.UserNotFoundException;
import com.movieapp.model.User;
import com.movieapp.service.IUserService;
import com.movieapp.service.UserAlreadyExistException;
import com.movieapp.service.UserServiceImpl;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IUserService userService = new UserServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");		
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = (String) request.getParameter("email");
		try {
			User user =  userService.getByEmail(email);
			
			String password = (String) request.getParameter("password");
			
			if(user.getPassword().equals(password)) {
				HttpSession session =  request.getSession();
				session.setAttribute("loggedin", true);
				session.setAttribute("user", user);
				
				response.sendRedirect("search.jsp");
				return;
				
			}else {
				request.setAttribute("message","Incorrect Password !");
			}

		} catch (UserNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("message","User does not exist !");
		}
		
					
		doGet(request, response);
	}

}
