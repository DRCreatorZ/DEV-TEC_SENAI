<?php
// Multiplicando o numero1 pelo numero2 somando o numero1 a quantidade de vezes do valor do numero2
function multiplicacaoPorSomas($numero1, $numero2) {
    $resultado = 0;

    for ($i = 1; $i <= $numero2; $i++) {
        $resultado += $numero1;
    }

    return $resultado;
}
// Agora, vamos imprimir a conta no HTML
    function conta ($numero1, $numero2){
    echo "<br>";
    echo "A conta foi feita assim: ";
    for ($i = 1; $i <= $numero2; $i++) {
        echo "{$numero1}";
        if ($i < $numero2) {
            echo " + ";
        }
    }
}
?>
