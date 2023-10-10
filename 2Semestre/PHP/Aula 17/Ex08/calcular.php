<?php
include 'funcoes.php';

$primos = encontrarPrimos(1000);

echo "Números primos até 1000:<br>";
echo implode(", ", $primos);
?>
