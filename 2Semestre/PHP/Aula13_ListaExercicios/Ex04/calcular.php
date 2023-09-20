<?php
include 'funcoes.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $numero = $_POST["numero"];

    if (!is_numeric($numero) || $numero < 0 || $numero != (int)$numero) {
        echo "Por favor, insira um número natural.";
        exit;
    }

    $resultado = calcularFatorial($numero);

    echo "O fatorial de {$numero} é {$resultado}.";
} else {
    echo "Erro ao processar a requisição. Por favor, volte à página inicial.";
}
?>
