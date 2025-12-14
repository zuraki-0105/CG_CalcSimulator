document.addEventListener("DOMContentLoaded", () => {
    console.log("/2d/js/shape.jsが読み込まれました");
    const nextBtn = document.getElementById("nextBtn");
    const backBtn = document.getElementById("backBtn");

    nextBtn.addEventListener("click", () => {
        console.log("戻る");
    });

    backBtn.addEventListener("click", () => {
        if (history.length > 1) {
          history.back();
        } else {
          location.href = "/index.html";
        }
    });
});