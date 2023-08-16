package com.movieapp.service;

import com.movieapp.exception.UserNotFoundException;
import com.movieapp.model.User;

public interface IUserService {
	void addUser(User user) throws UserAlreadyExistException;
	User getByEmail(String email) throws UserNotFoundException;
	User getById(Integer id)throws UserNotFoundException;
}
