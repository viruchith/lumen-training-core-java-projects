package com.lumen.basics;

public class Pattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=4;
		int count=1;
		for(int i=1;i<=number;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(count);
				count++;
			}
			System.out.println();
		}
	}

}
