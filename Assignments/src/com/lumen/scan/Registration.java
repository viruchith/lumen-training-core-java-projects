package com.lumen.scan;

import java.util.Scanner;

public class Registration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String usernames[]= {"Sanjay","Saran","Sanjana","Sam"};
		System.out.println("Enter name to register");
		String name=scanner.next();
		int count=0;
		for(String username:usernames) {
			if(username.equals(name))
			{
				System.out.println("Name is not unique");
				
					count=1;
					break;
			}
			//System.out.println(user);
		}
		if(count==0)
			System.out.println("You are registered");
		scanner.close();
	}

}
