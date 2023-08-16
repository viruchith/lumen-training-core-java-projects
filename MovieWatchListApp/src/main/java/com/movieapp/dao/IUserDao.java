package com.movieapp.dao;

import com.movieapp.model.User;

public interface IUserDao {
	boolean addUser(User user);
	User findByEmail(String email);
	User findById(Integer id);
}
