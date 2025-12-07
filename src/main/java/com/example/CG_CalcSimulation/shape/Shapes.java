package com.example.CG_CalcSimulation.shape;
import java.util.ArrayList;
import java.util.List;

import com.example.CG_CalcSimulation.matrix3.Point2D;

public abstract class Shapes {
	protected List<Point2D> vertexes = new ArrayList<Point2D>();
	
	
	public List<Point2D> getVertexes() { return this.vertexes; }
	
	public void setVertexes(List<Point2D> newVertices) {
		this.vertexes = newVertices;
	}
	
	public abstract String getType();
	public abstract Shapes copy();
	
	public void printVertexes() {
//		System.out.println(switch(getType()) {
//			case "w" -> "aaa";
//			default -> "ss";
//		});
		switch (getType()) {
		case "Rectangle":
			System.out.println("4 vertexes of " + getType() + " :");
			break;

		case "Circle":
			System.out.println("center point and radius of " + getType() + " :");
			break;
			
		case "Triangle":
			System.out.println("3 vertexes of " + getType() + " :");
			break;
		default:
			break;
		}
		
		for(Point2D p : vertexes) {
			System.out.print(p + " ");
		}
//		System.out.println(", radius = ");
		System.out.print("\n");
	}
	
	@Override
	public String toString() {
		return getType() + " : " + vertexes.toString();
	}
}
