<?php
$n1 = $_GET['n1'];
$n2 = $_GET['n2'];
$op = $_GET['op'];

function calculadora($num1, $num2, $operacao) {
    switch ($operacao) {
        case 'soma':
            echo "O resultdo de $num1 + $num2 é: ";
            return $num1 + $num2;
        case 'subtracao':
            echo "O resultdo de $num1 - $num2 é: ";
            return $num1 - $num2;
        case 'multiplicacao':
            echo "O resultdo de $num1 x $num2 é: ";
            return $num1 * $num2;
        case 'divisao':
            echo "O resultdo de $num1 / $num2 é: ";
            if ($num2 != 0) {
                return $num1 / $num2;
            } else {
                return "Não é possível dividir por zero.";
            }
        default:
            return "Operação inválida.";
    }
}

echo calculadora($n1, $n2, $op);

?>