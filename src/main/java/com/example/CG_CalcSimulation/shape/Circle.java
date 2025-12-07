package com.example.CG_CalcSimulation.shape;

import java.util.ArrayList;
import java.util.List;

import com.example.CG_CalcSimulation.matrix3.Point2D;
import com.example.CG_CalcSimulation.util.ValidationUtil;

public class Circle extends Shapes{
	private Point2D center;
	private double radius;
	
	public Circle(Point2D center, double r) {
		ValidationUtil.requireValidPoint(center, "center");
		ValidationUtil.requirePositive(r, "radius");
		this.center = center;
		this.radius = r;
		this.vertexes.add(new Point2D(center.x, center.y));
	}
	
	public Circle(List<Point2D> vertices, double r) {
		this.vertexes = vertices;
		this.radius = r;
	}
	
	public double getRadius() { return radius; }
	public Point2D getCenter() { return center; }
	
	@Override
	public String getType() {
		return "Circle";
	}
	
	@Override
	public void printVertexes() {
		System.out.println("center point and radius of " + getType() + " :");
		System.out.print(vertexes.get(0));
		System.out.println(", radius = " + radius);
	}
	
	public void printVertexes(Boolean bl) {
		System.out.println("center point and radius of " + getType() + " :");
		System.out.print(vertexes.get(0));
		System.out.print(", radius = " + radius);
		if(bl) {
			System.out.printf(", a = %.2f, b = %.2f", center.x+radius, center.y+radius);
		}
		System.out.println();
	}
	
	@Override
	public Shapes copy() {
		List<Point2D> copied = new ArrayList<>();
		for(Point2D p : vertexes) {
			copied.add(new Point2D(p.x, p.y));
		}
		return new Circle(copied, this.radius);
	}

}
