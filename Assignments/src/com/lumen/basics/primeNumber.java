package com.lumen.basics;

public class primeNumber {

	public static void main(String[] args) {
		int number=19;
		int half=number/2;
		boolean flag=false;
		if(number==0||number==1) {
			System.out.println("Not a prime number");
		}
		else {
			for(int i=2;i<half;i++) {
				if(number%half==0) {
					flag=true;
					System.out.println("Not a prime number");
					break;
				}
			}
		}
		if(!flag) {
			System.out.println("Prime number");
		}
	}

}
