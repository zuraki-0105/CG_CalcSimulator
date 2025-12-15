package com.example.CG_CalcSimulation;

import com.example.CG_CalcSimulation.matrix3.Matrix3;
import com.example.CG_CalcSimulation.matrix3.Matrix3Util;
import com.example.CG_CalcSimulation.matrix3.ShapeTransformer;
import com.example.CG_CalcSimulation.matrix3.Transform;
import com.example.CG_CalcSimulation.shape.Shapes;

public class CgCalcService {

    /**
     * -------------------------------
     *  図形 + 行列 → 新しい図形を返す
     * -------------------------------
     */
    public Shapes transform(Shapes shape, Matrix3 M) {
        return ShapeTransformer.transformCopy(shape, M);
    }


    /**
     * -------------------------------------------------------
     * TransformPane で入力された値から変換行列を作る
     * 
     * tx, ty : 平行移動
     * sx, sy : 拡大縮小
     * rotDeg : 回転角（度）
     * 
     * （順番は自由に変更可能。GUI に合わせて統一する）
     * -------------------------------------------------------
     */
    public Matrix3 buildMatrix(double tx, double ty, double sx, double sy, double rotDeg) {

        Matrix3 T = Transform.translation(tx, ty);
        Matrix3 S = Transform.scale(sx, sy);
        Matrix3 R = Transform.rotation(rotDeg);

        // ★行列の掛け方はあなたの TransformPane の意図に合わせてください
        //   一般的には S → R → T の順で適用されます。
        //   （右から掛けられる順序）
        //
        //   Canvas 上の見た目として自然なのは以下：
        //   最終変換 = T * R * S

        return Matrix3Util.makeTransMatrix(T, R, S);
    }


    /**
     * -------------------------------------------------------
     * GUI から全ての Transform 入力（オプション）を受け取って行列生成
     * SummaryPane から利用しやすい
     * -------------------------------------------------------
     */
    public Matrix3 buildMatrixFromInput(TransformInput input) {
        return buildMatrix(
                input.tx,
                input.ty,
                input.sx,
                input.sy,
                input.thetaDeg
        );
    }


    /**
     * GUI用データ保持クラス（必要なら利用）
     */
    public static class TransformInput {
        public double tx, ty;
        public double sx, sy;
        public double thetaDeg;

        public TransformInput(double tx, double ty, double sx, double sy, double thetaDeg) {
            this.tx = tx;
            this.ty = ty;
            this.sx = sx;
            this.sy = sy;
            this.thetaDeg = thetaDeg;
        }
    }

}
