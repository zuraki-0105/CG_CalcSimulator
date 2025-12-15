document.addEventListener("DOMContentLoaded", () => {
    console.log("/2d/js/index.jsが読み込まれました");
    const nextBtn = document.getElementById("nextBtn");

    nextBtn.addEventListener("click", () => {
        const selected = document.querySelector('input[name="dimension"]:checked');

        if (!selected) {
            alert("Select a dimension");
            return;
        }

        const dimension = selected.value;
        sessionStorage.setItem("dimension", dimension);

        if (dimension === "2D") {
            console.log("2Dが選択されました");
            location.href = "/2d/html/shape.html";
        } else {
            // location.href = "/3d/html/shape.html";
        }
    });
});
