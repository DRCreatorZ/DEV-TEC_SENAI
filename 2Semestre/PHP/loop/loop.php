<?php

// forma 01
	$x = 4;
	while ($x <= 5) {
		echo "Numero: $x <br>";
		$x++;
	}
	echo("<hr>");

// forma 02
	do {
		echo "Numero: $x \n";
		$x = $x +1;
	} while ($x <= 5);
	echo("<hr>");

// forma 03
	for ($i = 1; $i <= 10; $i++) {
		echo $i . "<br>" . "\n"; // (\n para prompt) e (<br> para navegador)
	}
	echo ("<hr>");

// forma 04
	$cores = array("verde", "amarelo", "azul", "branca");
	foreach ($cores as $cor) {
		echo " Cor: $cor <br>";
	}

?>