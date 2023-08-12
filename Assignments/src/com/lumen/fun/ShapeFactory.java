package com.lumen.fun;

public class ShapeFactory {
	void printArea(Shape shape,double x,double y) {
		System.out.println("Printing area");
		shape.calcArea(x,y);
		System.out.println("Dones");
	}
}
