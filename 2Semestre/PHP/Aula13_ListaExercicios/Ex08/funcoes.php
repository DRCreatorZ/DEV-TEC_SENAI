<?php
function encontrarPrimos($limite) {
    // Inicializa um array com todos os números marcados como não primos
    $naoPrimos = array_fill(2, $limite-1, false);

    // Encontra os números primos
    for ($i = 2; $i <= sqrt($limite); $i++) {
        if (!$naoPrimos[$i]) {
            for ($j = $i * $i; $j <= $limite; $j += $i) {
                $naoPrimos[$j] = true;
            }
        }
    }

    // Retorna os números primos encontrados
    $primos = array();
    for ($i = 2; $i <= $limite; $i++) {
        if (!$naoPrimos[$i]) {
            $primos[] = $i;
        }
    }

    return $primos;
}
?>
