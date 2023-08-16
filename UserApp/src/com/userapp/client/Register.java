package com.userapp.client;

import java.util.Scanner;

import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;
import com.userapp.service.IValidationService;
import com.userapp.service.ValidationServiceImpl;

public class Register {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		IValidationService iValidationService=new ValidationServiceImpl();
		try {
			System.out.println("Enter the username");
			String username=scanner.next();
			if(iValidationService.validateUsername(username)) {
				System.out.println("Enter the password");
				String password=scanner.next();
				if(iValidationService.validatePassword(password)) {
						System.out.println("User registered succesfully");
				}
			}
		} catch (NameExistsException | TooShortException | TooLongException e) {
			System.out.println(e.getMessage());
		}
		finally {
			scanner.close();
		}
	}

}
