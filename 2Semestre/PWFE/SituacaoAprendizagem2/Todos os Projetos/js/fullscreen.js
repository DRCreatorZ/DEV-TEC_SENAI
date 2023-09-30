document.addEventListener("DOMContentLoaded", function () {
    const elementoEmTelaCheia = document.documentElement;

    function entrarEmTelaCheia() {
        if (elementoEmTelaCheia.requestFullscreen) {
            elementoEmTelaCheia.requestFullscreen();
        } else if (elementoEmTelaCheia.mozRequestFullScreen) { // Firefox
            elementoEmTelaCheia.mozRequestFullScreen();
        } else if (elementoEmTelaCheia.webkitRequestFullscreen) { // Chrome, Safari e Opera
            elementoEmTelaCheia.webkitRequestFullscreen();
        } else if (elementoEmTelaCheia.msRequestFullscreen) { // Internet Explorer
            elementoEmTelaCheia.msRequestFullscreen();
        }
    }

    const botaoTelaCheia = document.getElementById("botaotelacheia");
    botaoTelaCheia.addEventListener("click", entrarEmTelaCheia);
});
