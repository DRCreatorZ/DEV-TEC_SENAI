<?php

function nPar () {
	$numeros = array (1,2,3,4,5,6,7,8,9);
	foreach ($numeros as $par){
		if ($par % 2 == 0){
		echo " $par é par!<br>";	
		}
	}
}
echo nPar();
?>