package com.example.CG_CalcSimulation.util;

import com.example.CG_CalcSimulation.matrix3.Point2D;

public class ValidationUtil {
	// 値が正（>0）か確認
	public static void requirePositive(double value, String name) {
		if (value <= 0) {
			throw new IllegalArgumentException(name + " must be > 0, but was " + value);
		}
	}
	
	// 値が非負（>=0）か確認
	public static void requireNonNegative(double value, String name) {
		if (value < 0) {
			throw new IllegalArgumentException(name + " must be >= 0, but was " + value);
		}
	}
	
	// NaN チェック
	public static void requireNonNaN(double value, String name) {
		if (Double.isNaN(value)) {
			throw new IllegalArgumentException(name + " must not be NaN");
		}
	}
	
	// Point2D チェック
	public static void requireValidPoint(Point2D p, String name) {
		requireNonNaN(p.x, name + ".x");
		requireNonNaN(p.y, name + ".y");
	}
}
