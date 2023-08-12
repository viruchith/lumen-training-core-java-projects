package com.lumen.scan;
import java.util.Scanner;
public class SumAvg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int number=scanner.nextInt();
		int marks[]=new int[number];
		for(int i=0;i<number;i++) {
			marks[i]=scanner.nextInt();
		}
		int sum=0;
		int avg=0;
		for(int mark:marks) {
			sum=sum+mark;
		}
		System.out.println("Sum "+sum);
		avg=sum/number;
		System.out.println("Average "+ avg);
		scanner.close();
	}

}
