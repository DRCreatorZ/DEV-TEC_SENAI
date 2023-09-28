<?php
include 'Function.php';

// Exercicio02
$numero01 = $_POST['numero01']; // Primeiro número
$numero02 = $_POST['numero02']; // Segundo número

$resultadoMultiplicacao = multiplicacaoPorSomasSucessivas($numero01, $numero02);

echo "Resultado da multiplicação: " . $resultadoMultiplicacao;

?>
