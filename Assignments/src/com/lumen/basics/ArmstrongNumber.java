package com.lumen.basics;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=155;
		int answer=0;
		int cube=1;
		int temp=number;
		while(temp>0)
		{
		cube=temp%10;
		answer=answer+(cube*cube*cube);
		temp=temp/10;
		}
		if(answer==number)
		{
			System.out.println("Armstrong number");
		}
		else
		{
			System.out.println("Not an armstrong number");
		}
	}

}
