package com.lumen.main;

import java.util.Scanner;

import com.voterapp.exception.InvalidVoterException;
import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.service.ElectionBoothImpl;

public class Voter {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the age");
		int age=scanner.nextInt();
		System.out.println("Enter the city");
		String city=scanner.next();
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		ElectionBoothImpl boothImpl=new ElectionBoothImpl();
		try {
			if(boothImpl.checkEligibility(age,city,id)) {
				System.out.println("Voter is eligible ");
			}
		}catch(InvalidVoterException e) {
			e.getMessage();
		}
		
	}

}
