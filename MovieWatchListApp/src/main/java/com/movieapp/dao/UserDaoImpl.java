package com.movieapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import com.movieapp.model.User;
import com.movieapp.util.DBConnection;
import com.movieapp.util.UserQueries;

public class UserDaoImpl implements IUserDao {

	@Override
	public boolean addUser(User user) {
		try(Connection connection = DBConnection.openConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UserQueries.INSERT_USER)) {
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFirstName());
			preparedStatement.setString(4, user.getLastName());
			preparedStatement.setString(5, user.getGender());
			preparedStatement.execute();
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public User findByEmail(String email) {
		try(Connection connection = DBConnection.openConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UserQueries.SELECT_USER_BY_EMAIL)) {
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setFirstName(resultSet.getString("firstName"));
				user.setLastName(resultSet.getString("lastName"));
				user.setGender(resultSet.getString("gender"));
				
				return user;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	}

	@Override
	public User findById(Integer id) {
		try(Connection connection = DBConnection.openConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UserQueries.SELECT_USER_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setFirstName(resultSet.getString("firstName"));
				user.setLastName(resultSet.getString("lastName"));
				user.setGender(resultSet.getString("gender"));
				
				return user;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	}
}
