package com.example.CG_CalcSimulation.shape;

import java.util.ArrayList;
import java.util.List;

import com.example.CG_CalcSimulation.matrix3.Point2D;
import com.example.CG_CalcSimulation.util.ValidationUtil;

public class Ellipse extends Shapes{
	private Point2D center;
	private double a;
	private double b;
	private double theta;
	
	public Ellipse(Point2D center, double a, double b, double deg) {
		ValidationUtil.requireValidPoint(center, "center");
		ValidationUtil.requirePositive(a, "a");
		ValidationUtil.requirePositive(b, "b");
		
		this.center = center;
		this.a = a;
		this.b = b;
		this.theta = Math.toRadians(deg);
		super.vertexes.add(center);
	}
	
	public Ellipse(List<Point2D> vertices, double a, double b, double deg) {
		super.vertexes = vertices;
		this.a = a;
		this.b = b;
		this.theta = Math.toRadians(deg);
	}
	
	public Point2D getCenter() { return center; }
	public double getA() { return a; }
	public double getB() { return b; }
	public double getTheta() { return theta; }
	
	@Override
	public void printVertexes() {
		System.out.println("center point and radius of " + getType() + " :");
		System.out.print(vertexes.get(0));
		System.out.printf(", a = %.2f, b = %.2f, th = %.1f°\n", a, b, Math.toDegrees(theta));
	}
	
	@Override
	public String getType() {
		return "Ellipse";
	}

	@Override
	public Shapes copy() {
		List<Point2D> copied = new ArrayList<>();
		for(Point2D p : vertexes) {
			copied.add(new Point2D(p.x, p.y));
		}
		return new Ellipse(copied, a, b, Math.toDegrees(theta));
	}

}
