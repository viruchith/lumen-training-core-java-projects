package com.movieapp.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthHelper {
	public static void verifyLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  =  request.getSession();
		Boolean isloggedin = (Boolean) session.getAttribute("loggedin");
		if(isloggedin==null || !isloggedin) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
