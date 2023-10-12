<?php
if(isset($_POST['numero'])) {
    $numero = floatval($_POST['numero']); // Converte para número com ponto flutuante
    if($numero > 0) {
        echo "Valor Positivo";
    } elseif($numero < 0) {
        echo "Valor Negativo";
    } else {
        echo "Igual a Zero";
    }
}
?>