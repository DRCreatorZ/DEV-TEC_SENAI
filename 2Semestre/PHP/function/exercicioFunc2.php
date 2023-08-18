<?php

function fatorial ($n){
	$f = array_product(range($n, 1));
	echo "O Fatorial de $n é: $f !";
}

echo fatorial(5);

?>
