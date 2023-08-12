package com.lumen.scan;

import java.util.Scanner;

public class EvenNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		for(int i=1;i<=20;i++) {
			if(i%2==0)
				System.out.println(i);
		}
		
		scanner.close();
	}

}
