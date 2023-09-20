<?php
include 'funcoes.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $lado1 = $_POST["lado1"];
    $lado2 = $_POST["lado2"];
    $lado3 = $_POST["lado3"];

    // Verifica se os dados inseridos são válidos
    if (!is_numeric($lado1) || !is_numeric($lado2) || !is_numeric($lado3) || $lado1 <= 0 || $lado2 <= 0 || $lado3 <= 0) {
        echo "Por favor, insira números positivos válidos.";
        exit;
    }

    // Chama a função verificarTriangulo para obter o resultado
    $resultado = verificarTriangulo($lado1, $lado2, $lado3);

    // Exibe o resultado na tela
    echo $resultado;
} else {
    echo "Erro ao processar a requisição. Por favor, volte à página inicial.";
}
?>
