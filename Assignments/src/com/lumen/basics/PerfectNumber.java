package com.lumen.basics;

public class PerfectNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=28;
		int sum=0;
		for(int i=1;i<number;i++)
		{
			if(number%i==0)
			{
				sum=sum+i;
			}
		}
		if(sum==number)
		{
			System.out.println("Perfect number");
		}
		else
		{
			System.out.println("Not a perfect number");
		}
	}

}
