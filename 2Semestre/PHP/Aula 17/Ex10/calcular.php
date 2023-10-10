<?php
include 'funcoes.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $valor = $_POST["valor"];

    // Verifica se o valor inserido é numérico
    if (!is_numeric($valor)) {
        echo "Por favor, insira um valor numérico.";
        exit;
    }

    // Chama a função calcularPorcentagens para obter os resultados
    $resultados = calcularPorcentagens($valor);

    // Exibe os resultados na tela
    echo "5% do valor é: {$resultados['cincoPorcento']}<br>";
    echo "50% do valor é: {$resultados['cinquentaPorcento']}<br>";
} else {
    echo "Erro ao processar a requisição. Por favor, volte à página inicial.";
}
?>
