package com.movieapp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movieapp.model.Movie;
import com.movieapp.model.User;
import com.movieapp.service.IMovieService;
import com.movieapp.service.MovieServiceImpl;
import com.movieapp.util.AuthHelper;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IMovieService movieService = new MovieServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthHelper.verifyLogin(request, response);
		String imdbID = request.getParameter("imdbID");
		if(imdbID!=null) {
			imdbID=imdbID.trim();
			if(!imdbID.isBlank()) {
				HttpSession session = request.getSession();
				User user =  (User) session.getAttribute("user");
				Movie movie = movieService.getByImdbID(imdbID);
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
