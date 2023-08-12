package com.lumen.basics;

public class SumAvg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int marks[]=new int[5];
		marks[0]=3;
		marks[1]=4;
		marks[2]=5;
		marks[3]=6;
		marks[4]=12;
		int sum=0;
		int average=0;
		for(int mark:marks) {
			sum=sum+mark;
		}
		System.out.println("Sum "+sum);
		average=sum/5;
		System.out.println("Average "+average);
	}

}
