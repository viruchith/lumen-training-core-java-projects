package com.lumen.fun;

public class FunMain {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		shapeFactory.printArea((x, y) -> {
			System.out.println("Area of rectangle "+x*y);
			return x*y;
		}, 4, 5);
		shapeFactory.printArea((x, y) -> {
			System.out.println("area of traingle "+0.5 * x * y);
			return 0.5 * x * y;
		}, 4, 5);
	}

}
