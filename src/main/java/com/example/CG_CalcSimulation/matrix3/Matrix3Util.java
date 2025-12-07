package com.example.CG_CalcSimulation.matrix3;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;

public class Matrix3Util {
	
	// 行列を操作の順番に掛けていって、変換行列を生成
	public static Matrix3 makeTransMatrix(Matrix3... transes) {
		Matrix3 mat = Matrix3Util.identity();
		for(Matrix3 m : transes) {
			mat = mat.multiply(m);
		}
		return mat;
	}
	
	

	// 単位行列生成
	public static Matrix3 identity() {
		DMatrixRMaj id = CommonOps_DDRM.identity(3);
		return new Matrix3(id);
	}
}
