package com.example.CG_CalcSimulation.shape;
import java.util.ArrayList;
import java.util.List;

import com.example.CG_CalcSimulation.matrix3.Point2D;
import com.example.CG_CalcSimulation.util.ValidationUtil;

public class Rectangle extends Shapes{
	private double width; //幅
	private double height; //高さ
	private Point2D bottomLeft; //基準点
	
	public Rectangle(double width, double height, Point2D bottomLeft) {
		ValidationUtil.requirePositive(width, "width");
		ValidationUtil.requirePositive(height, "height");
		ValidationUtil.requireValidPoint(bottomLeft, "bottomLeft");
		this.width = width;
		this.height = height;
		this.bottomLeft = bottomLeft;
		initVertices(width, height, bottomLeft);
	}
	
	public Rectangle(List<Point2D> vertexes) {
		this.vertexes = vertexes;
		this.bottomLeft = new Point2D(vertexes.get(0).x, vertexes.get(0).y);
		this.width = vertexes.get(1).x - vertexes.get(0).x;
		this.height = vertexes.get(3).y - vertexes.get(0).y;
	}
	

	private void initVertices(double w, double h, Point2D bl) {
		vertexes.add(new Point2D(bl.x, bl.y));		// 左下
		vertexes.add(new Point2D(bl.x+w, bl.y));	// 右下
		vertexes.add(new Point2D(bl.x+w, bl.y+h));	// 右上
		vertexes.add(new Point2D(bl.x, bl.y+h));	// 左上
		
	}
	
	public double getWidth() { return width; }
	public double getHeight() { return height; }
	public Point2D getBottomLeft() { return bottomLeft; }
	
	@Override
	public String getType() {
		return "Rectangle";
	}

	@Override
	public Shapes copy() {
		List<Point2D> copied = new ArrayList<>();
		for(Point2D p : vertexes) {
			copied.add(new Point2D(p.x, p.y));
		}
		return new Rectangle(copied);
	}

}
