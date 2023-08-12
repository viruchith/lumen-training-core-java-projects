package com.lumen.basics;

public class GreatestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int marks[]= {12,25,24,21};
		int max=0;
		for(int i=0;i<marks.length;i++) {
			if(max<marks[i]) {
				max=marks[i];
			}
		}
		System.out.println(max);
	}

}
