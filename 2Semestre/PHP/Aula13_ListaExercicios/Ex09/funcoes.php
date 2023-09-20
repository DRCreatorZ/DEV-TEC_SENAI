<?php
function encontrarPerfeitos($limite) {
    $perfeitos = array();

    for ($i = 2; $i <= $limite; $i++) {
        $somaDivisores = 1; // Inicializa com 1, pois todo número é divisível por 1

        for ($j = 2; $j <= $i/2; $j++) {
            if ($i % $j == 0) {
                $somaDivisores += $j;
            }
        }

        if ($somaDivisores == $i) {
            $perfeitos[] = $i;
        }
    }

    return $perfeitos;
}
?>
