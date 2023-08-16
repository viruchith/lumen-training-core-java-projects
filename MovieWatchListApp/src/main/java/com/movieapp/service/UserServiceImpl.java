package com.movieapp.service;

import com.movieapp.dao.IUserDao;
import com.movieapp.dao.UserDaoImpl;
import com.movieapp.exception.UserNotFoundException;
import com.movieapp.model.User;

public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao = new UserDaoImpl();

	@Override
	public void addUser(User user) {
		boolean result =  userDao.addUser(user);
		if(result==false) {
			throw new UserAlreadyExistException();
		}
	}

	@Override
	public User getByEmail(String email) throws UserNotFoundException {
		User user = userDao.findByEmail(email);
		if(user==null) {
			throw new UserNotFoundException();
		}
		return user;
	}

	@Override
	public User getById(Integer id) throws UserNotFoundException {
		User user = userDao.findById(id);
		if(user==null) {
			throw new UserNotFoundException();
		}
		return user;
	}
	
}
