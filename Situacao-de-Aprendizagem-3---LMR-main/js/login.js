document.addEventListener("DOMContentLoaded", function () {
    const logar = document.getElementById("logar");
    const iframe = document.getElementById("IframeLogar");
    const fechar = document.getElementById("fechar");
    let contador = 0;

    function abrirFrame() {
        if (contador === 0) {
            iframe.style.display = "inline";
            iframe.classList.add("move-iframe");
            contador++;
        } else if (contador === 1) {
            iframe.classList.remove("move-iframe");
            // Close the iframe
            iframe.style.display = "none";
            contador--;
        }
    }
    logar.addEventListener("click", abrirFrame);
    fechar.addEventListener("click", abrirFrame);
});
