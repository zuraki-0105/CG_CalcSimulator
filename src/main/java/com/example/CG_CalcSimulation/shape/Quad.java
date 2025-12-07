package com.example.CG_CalcSimulation.shape;

import java.util.ArrayList;
import java.util.List;

import com.example.CG_CalcSimulation.matrix3.Point2D;

public class Quad extends Shapes{
	
	public Quad(List<Point2D> vertexes) {
		this.vertexes = vertexes;
	}
	
	@Override
	public String getType() {
		return "Quad";
	}

	@Override
	public Shapes copy() {
		List<Point2D> copied = new ArrayList<>();
		for(Point2D p : vertexes) {
			copied.add(new Point2D(p.x, p.y));
		}
		return new Quad(copied);
	}

}
