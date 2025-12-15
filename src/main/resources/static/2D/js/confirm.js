document.addEventListener("DOMContentLoaded", () => {
    console.log("/2d/js/confirm.js が読み込まれました");

    renderShapeInfo();
    renderTransformList();

    document.getElementById("backBtn").addEventListener("click", () => {
        history.back();
    });

    document.getElementById("sendBtn").addEventListener("click", () => {
        // 後で fetch に置き換える
        console.log("送信データ確認用", buildRequestData());
    });

    function renderShapeInfo() {
        const div = document.getElementById("shapeInfo");

        const shapeType = sessionStorage.getItem("shapeType");

        let html = "";

        if (shapeType === "rectangle") {
            html = `Rectangle
  基準点(x, y) =  (${sessionStorage.getItem("x")}, ${sessionStorage.getItem("y")}),
  幅           =  ${sessionStorage.getItem("width")},
  高さ         =  ${sessionStorage.getItem("height")}`;

            // html = `Rectangle<br>  基準点(x, y)  =  (${sessionStorage.getItem("x")}, ${sessionStorage.getItem("y")}),<br>  幅                     =  ${sessionStorage.getItem("width")},<br>  高さ                =  ${sessionStorage.getItem("height")}`;
        }

        if (shapeType === "ellipse") {
            const x = Number(sessionStorage.getItem("x"));
            const y = Number(sessionStorage.getItem("y"));
            const a = Number(sessionStorage.getItem("a"));
            const b = Number(sessionStorage.getItem("b"));

            if(a === b){
                html = `Circle<br>  中点(x, y)  =  (${x}, ${y}),<br>  半径 r         =  ${a}`;
            } else {
                html = `Ellipse<br>  中点(x, y)  =  (${x}, ${y}),<br>  長半径 a    =  ${a},<br>  短半径 b    =  ${b}`;
            }
            
        }

        div.innerHTML = html;
    }

    function renderTransformList() {
        const listElem = document.getElementById("transformList");
        const queue = JSON.parse(sessionStorage.getItem("transformQueue") || "[]");

        queue.forEach((t, index) => {
            const li = document.createElement("li");

            switch (t.type) {
                case "translation":
                    li.textContent = `${index+1}: 平行移動 (${t.tx}, ${t.ty})`;
                    break;
                case "scale":
                    li.textContent = `${index+1}: 拡大縮小 (${t.sx}, ${t.sy})`;
                    break;
                case "rotation":
                    li.textContent = `${index+1}: 回転 (${t.theta}°)`;
                    break;
                case "custom":
                    const matrixText =
                        "{ " + t.matrix.map(r => r.join(", ")).join("\n  ") + " }";
                    li.innerHTML = `${index+1}: 任意行列<br><pre>${matrixText}</pre>`;
                    break;
            }

            listElem.appendChild(li);
        });
    }

    function buildRequestData() {
        return {
            dimension: "2D",
            shape: {
                type: sessionStorage.getItem("shapeType"),
                params: {  }
            },
            transforms: JSON.parse(sessionStorage.getItem("transformQueue"))
        };
    }

});
