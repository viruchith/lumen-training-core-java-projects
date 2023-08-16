package com.movieapp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieapp.model.Movie;
import com.movieapp.util.AuthHelper;
import com.movieapp.util.MovieFetcher;
import com.movieapp.util.MovieSearchResult;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthHelper.verifyLogin(request, response);
		
		String title = request.getParameter("title");
		
		if(title!=null) {
			List<MovieSearchResult> searchResults = MovieFetcher.fetchMoviesByTitle(title);
			request.setAttribute("results", searchResults);
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("search.jsp");
		requestDispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
