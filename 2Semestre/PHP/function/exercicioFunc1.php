<?php

function media($a, $b, $c, $d){
	$retorno = (($a + $b + $c + $d)/4);
	if ($retorno >= 7) {
			echo "Aprovado: Sua média foi  $retorno";
		}elseif ($retorno >= 5) {
			echo"Exame: Sua média foi  $retorno";
		} else {
			echo"Reprovado: Sua média foi  $retorno";

	}}

echo media(2,11,5,2);

?>