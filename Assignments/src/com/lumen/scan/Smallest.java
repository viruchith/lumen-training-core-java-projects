package com.lumen.scan;

import java.util.Scanner;

public class Smallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int num1=scanner.nextInt();
		int num2=scanner.nextInt();
		int num3=scanner.nextInt();
		if(num1<num2 && num1<num3) {
			System.out.println("Number1 is smaller");
		}
		else if(num2<num3) {
			System.out.println("Number2 is smaller");
		}
		else {
			System.out.println("Number3 is smaller");
		}
		scanner.close();
	}

}
