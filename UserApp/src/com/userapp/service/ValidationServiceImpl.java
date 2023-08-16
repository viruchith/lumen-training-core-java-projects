package com.userapp.service;

import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;

public class ValidationServiceImpl implements IValidationService {
	public boolean validateUsername(String username) throws NameExistsException{
		String usernames[]= {"Sanjay","Sathya","Saran","Sharuk"};
		for(String name:usernames) {
			if(name.equals(username)) {
				throw new NameExistsException("Name already exists");
			}
		}
		return true;
	}

	@Override
	public boolean validatePassword(String password) throws TooShortException, TooLongException {
		if(password.length()<6) {
			throw new TooShortException("Password should be minimum 6 characters long");
		}
		else if(password.length()>15) {
			throw new TooLongException("Password should be less than 15 characters");
		}else
		{
			return true;
		}
	}
	
}
