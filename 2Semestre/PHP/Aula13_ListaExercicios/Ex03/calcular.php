<?php
include 'funcoes.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $numero1 = $_POST["numero1"];
    $numero2 = $_POST["numero2"];

    if (!is_numeric($numero1) || !is_numeric($numero2) || $numero2 == 0) {
        echo "Por favor, insira números válidos. O segundo número não pode ser zero.";
        exit;
    }

    $resultado = divisaoPorSubtracoes($numero1, $numero2);
    echo "Resultado da divisão(por subtração) => {$numero1} / {$numero2} = {$resultado} <br>";
    $resto = $numero1 % $numero2;
    echo "Resto da divisão: {$resto}";

    $conta = conta($numero1, $numero2);
    echo "{$conta}";
    
} else {
    echo "Erro ao processar a requisição. Por favor, volte à página inicial.";
}
?>
