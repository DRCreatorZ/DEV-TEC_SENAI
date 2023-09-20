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
?>