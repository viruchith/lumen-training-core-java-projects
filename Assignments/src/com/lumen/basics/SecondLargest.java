package com.lumen.basics;

public class SecondLargest {

	public static void main(String[] args) {
		int numbers[]= {2,5,7,1,10};
		int number=0;
		for(int i=0;i<numbers.length;i++) {
				for(int j=i+1;j<numbers.length;j++)
					if(numbers[i]<numbers[j]) {
						number=numbers[i];
						numbers[i]=numbers[j];
						numbers[j]=number;
			}
		}
		
			System.out.print(numbers[1]);
	}

}
