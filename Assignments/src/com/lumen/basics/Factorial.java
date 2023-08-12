package com.lumen.basics;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=6;
		int factorial=1;
		for(int i=1;i<=number;i++)
		{
			factorial=factorial*i;
		}
		System.out.println("Factorial is "+factorial);
	}

}
