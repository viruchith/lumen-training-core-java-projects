package com.movieapp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movieapp.model.User;
import com.movieapp.model.WatchList;
import com.movieapp.service.IWatchListService;
import com.movieapp.service.WatchListService;
import com.movieapp.util.AuthHelper;

/**
 * Servlet implementation class MyListsServlet
 */
@WebServlet("/MyListsServlet")
public class MyListsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IWatchListService watchListService = new WatchListService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyListsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthHelper.verifyLogin(request, response);
		HttpSession session = request.getSession();
		User user =  (User) session.getAttribute("user");
		List<WatchList> watchLists;
		try {
			 watchLists = watchListService.getByUser(user);
		} catch (Exception e) {
			watchLists = new ArrayList<WatchList>();
		}
		
		request.setAttribute("watchLists", watchLists);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("mylists.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthHelper.verifyLogin(request, response);
		HttpSession session = request.getSession();
		User user =  (User) session.getAttribute("user");

		String title = request.getParameter("title");
		
		WatchList watchList = new WatchList();
		watchList.setTitle(title);
		
		watchListService.addWatchList(user, watchList);
		
		doGet(request, response);
	}

}
