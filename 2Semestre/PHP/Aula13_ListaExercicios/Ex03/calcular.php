<?php
include 'funcoes.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $numero1 = $_POST["numero1"];
    $numero2 = $_POST["numero2"];

    if (!is_numeric($numero1) || !is_numeric($numero2)) {
        echo "Por favor, insira números válidos.";
        exit;
    }

    $resultado = divisaoPorSubtracoes($numero1, $numero2);

    echo "Resultado da divisão: {$resultado}";
} else {
    echo "Erro ao processar a requisição. Por favor, volte à página inicial.";
}
?>
