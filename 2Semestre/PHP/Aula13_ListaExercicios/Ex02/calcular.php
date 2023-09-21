<?php
include 'funcoes.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $numero1 = $_POST["numero1"];
    $numero2 = $_POST["numero2"];

    if (!is_numeric($numero1) || !is_numeric($numero2)) {
        echo "Por favor, insira números válidos.";
        exit;
    }

    $resultado = multiplicacaoPorSomas($numero1, $numero2);
    echo "Resultado da multiplicação (por soma) => {$numero1} x {$numero2} = {$resultado} <br>";

    $conta = conta($numero1, $numero2);
    echo "{$conta}";

    echo " = {$resultado}";
} else {
    echo "Erro ao processar a requisição. Por favor, volte à página inicial.";
}
?>
