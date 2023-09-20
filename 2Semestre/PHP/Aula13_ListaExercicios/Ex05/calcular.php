<?php
include 'funcoes.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $quilometragem = $_POST["quilometragem"];
    $consumo = $_POST["consumo"];
    $precoLitro = $_POST["precoLitro"];

    // Verifica se os dados inseridos são válidos
    if (!is_numeric($quilometragem) || !is_numeric($consumo) || !is_numeric($precoLitro) || $quilometragem <= 0 || $consumo <= 0 || $precoLitro <= 0) {
        echo "Por favor, insira números positivos válidos.";
        exit;
    }

    // Chama a função calcularConsumo para obter os resultados
    $resultado = calcularConsumo($quilometragem, $consumo, $precoLitro);

    // Exibe os resultados na tela
    echo "Consumo médio: {$resultado['consumoMedio']} km/l<br>";
    echo "Custo por quilômetro: R$ {$resultado['custoPorQuilometro']}<br>";
} else {
    echo "Erro ao processar a requisição. Por favor, volte à página inicial.";
}
?>
