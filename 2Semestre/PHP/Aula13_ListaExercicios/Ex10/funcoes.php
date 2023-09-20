<?php
function calcularPorcentagens($valor) {
    // Calcula 5% do valor
    $cincoPorcento = $valor * 0.05;

    // Calcula 50% do valor
    $cinquentaPorcento = $valor * 0.5;

    // Retorna os resultados em um array associativo
    return array(
        'cincoPorcento' => $cincoPorcento,
        'cinquentaPorcento' => $cinquentaPorcento
    );
}
?>
