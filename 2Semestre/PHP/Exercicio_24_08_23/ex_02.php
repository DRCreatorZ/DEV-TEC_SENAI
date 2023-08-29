<?php
	$temp = $_GET['temp'];
	$operacao = $_GET['operacao'];
	
	function ConversorTemp($temp, $operacao) {
    switch ($operacao) {
        case 'TC':
            echo "$temp graus Farenheit é equivalente a: ";
            return ($temp-32)*(5/9);
        case 'TF':
            echo "$temp graus Celcius é equivalente a: ";
            return $temp*(9/5)+32 ;
        }
    }
 echo ConversorTemp($temp,$operacao);
?>
