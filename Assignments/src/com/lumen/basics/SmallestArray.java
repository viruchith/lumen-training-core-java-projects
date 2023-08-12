package com.lumen.basics;

public class SmallestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int marks[]= {12,25,4,21};
		int max=Integer.MAX_VALUE;
		for(int i=0;i<marks.length;i++) {
			if(max>marks[i]) {
				max=marks[i];
			}
		}
		System.out.println(max);
	}

	}


