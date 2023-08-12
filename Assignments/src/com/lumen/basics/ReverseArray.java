package com.lumen.basics;

public class ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int marks[]=new int[5];
		marks[0]=3;
		marks[1]=4;
		marks[2]=5;
		marks[3]=6;
		marks[4]=12;
		System.out.println("reverse array ");
		for(int i=marks.length-1;i>=0;i--) {
			System.out.println(marks[i]);
		}
	}

}
