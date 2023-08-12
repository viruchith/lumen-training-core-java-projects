package com.lumen.scan;
import java.util.Scanner;
public class Ternary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int num1=scanner.nextInt();
		int num2=scanner.nextInt();
		int num3=scanner.nextInt();
		String answer=num1>num2 && num1>num3?"Number1 is greater":((num2>num3)?"Number2 is greater":"Number3 is greater");
		System.out.println(answer);
		scanner.close();
	}

}
