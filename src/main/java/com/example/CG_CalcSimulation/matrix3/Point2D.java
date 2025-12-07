package com.example.CG_CalcSimulation.matrix3;

public class Point2D {
	public double x;
	public double y;
	
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return String.format("(%.2f, %.2f)", x, y);
	}
}
