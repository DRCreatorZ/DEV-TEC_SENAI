<?php
include 'funcoes.php';

$perfeitos = encontrarPerfeitos(1000);

echo "Números perfeitos até 1000:<br>";
echo implode(", ", $perfeitos);
?>
