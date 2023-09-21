<?php
function divisaoPorSubtracoes($numero1, $numero2) {
    if ($numero2 == 0) {
        return "Não é possível dividir por zero.";
    }

    $maior = max($numero1, $numero2);
    $menor = min($numero1, $numero2);

    $resultado = 0;

    while ($maior >= $menor) {
        $maior -= $menor;
        $resultado++;
    }

    return $resultado;
}
// Agora, vamos imprimir a conta no HTML
    function conta ($numero1, $numero2){
    echo "<br>";
    echo "A conta foi feita assim: <br>";

    while ($numero1 >= $numero2) {
        echo "{$numero1} - {$numero2} = ";
        $numero1 -= $numero2;
        echo "{$numero1}";
        if ($numero1 >= $numero2) {
            echo " => <br>";
        }
    }
}
?>