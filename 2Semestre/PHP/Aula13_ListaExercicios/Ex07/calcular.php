<?php
include 'funcoes.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $numero = $_POST["numero"];

    // Verifica se o valor inserido é um número inteiro
    if (!is_numeric($numero) || $numero != (int)$numero) {
        echo "Por favor, insira um número inteiro.";
        exit;
    }

    // Chama a função mostrarMes para obter o resultado
    $resultado = mostrarMes($numero);

    // Exibe o resultado na tela
    echo $resultado;
} else {
    echo "Erro ao processar a requisição. Por favor, volte à página inicial.";
}
?>
