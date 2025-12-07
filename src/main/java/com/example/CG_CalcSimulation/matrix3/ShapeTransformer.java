package com.example.CG_CalcSimulation.matrix3;
import java.util.ArrayList;
import java.util.List;

import com.example.CG_CalcSimulation.shape.Circle;
import com.example.CG_CalcSimulation.shape.Ellipse;
import com.example.CG_CalcSimulation.shape.Rectangle;
import com.example.CG_CalcSimulation.shape.Shapes;
import com.example.CG_CalcSimulation.shape.Triangle;

public class ShapeTransformer {
	
	// 非破壊変換：新しい図形オブジェクトを返す
	@SuppressWarnings("unchecked")
	public static <T extends Shapes> T transformCopy(T shape, Matrix3 transforMatrix) {
		List<Point2D> newVertexes = new ArrayList<Point2D>();
		
		for(Point2D p : shape.getVertexes()) {
			newVertexes.add(transforMatrix.apply(p));
		}
		return (T) switch (shape.getType()){
			case "Rectangle" -> new Rectangle(newVertexes);
			case "Triangle" -> new Triangle();
			case "Circle" -> returnTransCircle((Circle) shape, transforMatrix);
			case "Ellipse" -> returnTransEllipse((Ellipse) shape, transforMatrix);
			default -> throw new IllegalArgumentException("Unsupported shape type: " + shape.getType());
		};
	}
	
	private static Shapes returnTransCircle(Circle c, Matrix3 M) {
		Point2D center = c.getCenter();
		double r = c.getRadius();
		
		// 中心を変換
		Point2D newCenter = M.apply(center);
		
		Point2D px = new Point2D(center.x + r, center.y); // 右端
		Point2D py = new Point2D(center.x, center.y + r); // 上端
		
		// 変換
		Point2D newPx = M.apply(px);
		Point2D newPy = M.apply(py);
		
		// 軸ベクトル
		double vxX = newPx.x - newCenter.x; // 右端
		double vxY = newPx.y - newCenter.y;
		
		double vyX = newPy.x - newCenter.x; // 上端
		double vyY = newPy.y - newCenter.y;
		
		double a = Math.sqrt(vxX * vxX + vxY * vxY); // 長軸
		double b = Math.sqrt(vyX * vyX + vyY * vyY); // 短軸
		
		// 回転角（長軸方向）
		double theta = Math.atan2(vxY, vxX);
		
		// 円判定（a ≒ b のとき）
		if (Math.abs(a - b) < 1e-9) {
			return new Circle(newCenter, a);
		}
		
		// 楕円として返す
		return new Ellipse(newCenter, a, b, Math.toDegrees(theta));
		
	}
	
	private static Shapes returnTransEllipse(Ellipse e, Matrix3 M) {
		Point2D center = e.getCenter();
		double a = e.getA();
		double b = e.getB();
		double th = e.getTheta();
		
		// 中心を変換
		Point2D newCenter = M.apply(center);
		
		// 元の楕円の軸方向
		double cosT = Math.cos(th);
		double sinT = Math.sin(th);
		
		// 長軸方向の端点
		Point2D pA = new Point2D(
				center.x + a * cosT,
				center.y + a * sinT
			);
		
		// 短軸方向の端点（長軸に直交）
		Point2D pB = new Point2D(
				center.x - b * sinT,
				center.y + b * cosT
			);
		
		// 変換
		Point2D newPA = M.apply(pA);
		Point2D newPB = M.apply(pB);
		
		// 軸ベクトル
		double vaX = newPA.x - newCenter.x; // 右端
		double vaY = newPA.y - newCenter.y;
		
		double vbX = newPB.x - newCenter.x; // 上端
		double vbY = newPB.y - newCenter.y;
		
		double A = Math.sqrt(vaX * vaX + vaY * vaY); // 長軸
		double B = Math.sqrt(vbX * vbX + vbY * vbY); // 短軸
		
		// 新しい回転角
		double theta = Math.atan2(vaY, vaX);
		
		// 円判定（A ≒ B のとき）
		if (Math.abs(A - B) < 1e-9) {
			return new Circle(newCenter, A);
		}
		
		// 楕円として返す
		return new Ellipse(newCenter, A, B, Math.toDegrees(theta));
	}
	
	// 破壊的変換：元の図形を書き換える
	public static void transformInPlace(Shapes shape, Matrix3 transformMatrix) {
		 List<Point2D> newVertexes = new ArrayList<>();
		 
		 for(Point2D p : shape.getVertexes()) {
			 newVertexes.add(transformMatrix.apply(p));
		 }
		 
		 shape.setVertexes(newVertexes);
	}
}
