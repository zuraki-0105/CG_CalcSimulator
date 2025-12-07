package com.example.CG_CalcSimulation.gui;

import com.example.CG_CalcSimulation.InputDataModel;
import com.example.CG_CalcSimulation.matrix3.Matrix3;
import com.example.CG_CalcSimulation.shape.Shapes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ConfirmPane extends VBox {

    public ConfirmPane(InputController controller, InputDataModel model) {
        setSpacing(20);
        setAlignment(Pos.CENTER);

        Button exec = new Button("変換実行");
        exec.setOnAction(e -> {

            Shapes shape = ((ShapeParamPane) ((InputController)controller)
                    .getShapeParamPane()).buildShape();

            Matrix3 M = ((TransformPane)((InputController)controller)
                    .getTransformPane()).buildMatrix();

            controller.executeTransform(shape, M);
        });

        getChildren().add(exec);
    }
}

