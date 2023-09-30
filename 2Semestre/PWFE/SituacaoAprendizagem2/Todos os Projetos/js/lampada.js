// Este código é para controlar uma lâmpada em um quarto.
document.addEventListener("DOMContentLoaded", function () {
    // Seleciona os elementos HTML necessários.
    const luz = document.getElementById("luz");
    const botao = document.getElementById("botao");
    const lampada = document.getElementById("lampada");
    const quebrado = document.getElementById("quebrado");
    const chave = document.getElementById("chave");
    const music = new Audio('sound/interruptor.mp3');

    // Define a cor de fundo inicial do quarto.
    let backgroundColor = "yellow";

    // Define um contador para controlar o número de vezes que a luz foi acionada.
    let contador = 1;

    // Função para controlar a luz do quarto.
    function quarto() {
        // Se a cor de fundo do quarto for amarela e o contador for menor que 5,
        // acende a luz do quarto e aumenta o contador.
        if (backgroundColor == "yellow" && contador < 5) {
            backgroundColor = "black";
            luz.style.backgroundColor = "black";
            luz.style.boxShadow = "none";
            lampada.style.backgroundColor = "rgb(102, 3, 3)";
            lampada.style.filter = "brightness(30%)";
            quebrado.style.display = "none";
            chave.style.display = "none";
            music.play();
            contador++;
        }

        // Se a cor de fundo do quarto for preta e o contador for menor que 5,
        // apaga a luz do quarto e aumenta o contador.
        else if (backgroundColor == "black" && contador < 5) {
            backgroundColor = "yellow";
            luz.style.backgroundColor = "yellow";
            luz.style.boxShadow = "0px 0px 90px 30px rgb(253, 250, 162)";
            lampada.style.backgroundColor = "brown";
            lampada.style.filter = "brightness(100%)";
            quebrado.style.display = "none";
            chave.style.display = "none";
            music.play();
            contador++;
        }

        // Se a cor de fundo do quarto for amarela e o contador for igual a 5,
        // acende a luz do quarto, mostra o layer de vidro quebrado e a chave, e zera o contador.
        else if (backgroundColor == "yellow" && contador == 5) {
            backgroundColor = "black";
            luz.style.backgroundColor = "black";
            luz.style.boxShadow = "none";
            lampada.style.backgroundColor = "rgb(102, 3, 3)";
            lampada.style.filter = "brightness(30%)";
            quebrado.style.display = "block";
            chave.style.display = "block";
            music.play();
            contador = 0;
        }
    }

    // Adiciona um evento de clique no botão para chamar a função quarto().
    botao.addEventListener("click", quarto);
});
