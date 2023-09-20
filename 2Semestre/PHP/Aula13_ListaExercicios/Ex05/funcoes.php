<?php
function calcularConsumo($quilometragem, $consumo, $precoLitro) {
    // Calcula o consumo médio em km/l
    $consumoMedio = $quilometragem / $consumo;

    // Calcula o custo por quilômetro
    $custoPorQuilometro = $precoLitro / $consumo;

    // Retorna os resultados em um array associativo
    return array(
        'consumoMedio' => $consumoMedio,
        'custoPorQuilometro' => $custoPorQuilometro
    );
}
?>
