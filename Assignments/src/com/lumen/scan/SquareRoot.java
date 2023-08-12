package com.lumen.scan;

import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int number=scanner.nextInt();
		int marks[]=new int[number];
		for(int i=0;i<number;i++) {
			marks[i]=scanner.nextInt();
		}
		int number1=0;
		int count=0;
		int results[]=new int[marks.length];
		for(int i=0;i<marks.length;i++) {
			number1=(int)Math.sqrt(marks[i]);
			results[count++]=number1;
		}
		for(int result:results) {
			System.out.println(result);
		}
		scanner.close();
		
	}

}
