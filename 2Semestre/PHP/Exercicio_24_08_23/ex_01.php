<?php
	$raio = $_GET['raio'];
	$operacao = $_GET['operacao'];
	
	echo "O raio do círculo é $raio";
	echo "<br>";
	function calculadora($raio, $operacao) {
    switch ($operacao) {
        case 'perimetro':
            echo "O perímetro do Círculo de raio $raio é: ";
            return 2*M_PI*$raio;
        case 'area':
            echo "A Área do Círculo de raio $raio é: ";
            return M_PI *($raio*$raio);
        }
    }
 echo calculadora($raio, $operacao);
?>