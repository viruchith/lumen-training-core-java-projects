package com.lumen.basics;

public class Pattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=5;
		for(int i=1;i<=number;i++) {
			for(int j=number;j>=i;j--) {
				
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
