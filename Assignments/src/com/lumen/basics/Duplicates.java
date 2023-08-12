package com.lumen.basics;

public class Duplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int marks[]= {20,60,40,20,20,60,60,40,20};
		int count=0;
		for(int i=0;i<marks.length;i++) {
			for(int j=i+1;j<marks.length;j++) {
				if(marks[i]==marks[j])
				marks[j]=-1;
			}
		}
		for(int i=0;i<marks.length;i++) {
			if(marks[i]==-1) {
				count++;
			}
		}
		System.out.println(count);
	}
}
