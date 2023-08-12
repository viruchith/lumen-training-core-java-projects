package com.lumen.basics;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=1234;
		int reverse=0;
		int reminder;
		while(number>0)
		{
		reminder=number%10;
		reverse=(reverse*10)+reminder;
		number=number/10;
		}
		System.out.println(reverse);
	}

}
