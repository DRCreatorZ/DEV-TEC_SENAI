<?php

function calculadora($num1, $num2, $operacao) {
    switch ($operacao) {
        case 'soma':
            echo 'O resultdo da soma e: ';
            return $num1 + $num2;
        case 'subtracao':
            echo 'O resultdo da subtracao e: ';
            return $num1 - $num2;
        case 'multiplicacao':
            echo 'O resultdo da multiplicacao e: ';
            return $num1 * $num2;
        case 'divisao':
            echo 'O resultdo da divisao e: ';
            if ($num2 != 0) {
                return $num1 / $num2;
            } else {
                return "Não é possível dividir por zero.";
            }
        default:
            return "Operação inválida.";
    }
}

echo calculadora(5, 1,'subtracao');

?>