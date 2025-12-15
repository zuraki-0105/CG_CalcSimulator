/**
 * 指定した要素配下の input をすべてクリアする
 * @param {HTMLElement|string} root
 */
export function clearInputs(root) {
    const base =
        typeof root === "string"
            ? document.querySelector(root)
            : root;

    if (!base) return;

    base.querySelectorAll("input").forEach(input => {
        input.value = "";
    });
}


