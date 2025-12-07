package com.example.CG_CalcSimulation.matrix3;

import com.example.CG_CalcSimulation.util.ValidationUtil;

public class Transform {
	
	// 平行移動行列
	public static Matrix3 translation(double tx, double ty) {
		double[][] values = {
				{1, 0, tx},
				{0, 1, ty},
				{0, 0, 1}
		};
		return new Matrix3(values);
	}
	
	// 拡大縮小行列
	public static Matrix3 scale(double sx, double sy) {
		ValidationUtil.requirePositive(sx, "sx");
		ValidationUtil.requirePositive(sy, "sy");
		double[][] values = {
				{sx, 0, 0},
				{0, sy, 0},
				{0, 0, 1}
		};
		return new Matrix3(values);
	}
	
	// 回転行列
	public static Matrix3 rotaition(double deg) {
		double cos = Math.cos(Math.toRadians(deg));
		double sin = Math.sin(Math.toRadians(deg));
		
		double[][] values = {
				{cos, -sin, 0},
				{sin, cos, 0},
				{0, 0, 1}
		};
		
		return new Matrix3(values);
	}
	
	// 任意の行列
	public static Matrix3 custom(double[][] values) {
		return new Matrix3(values);
	}
}
