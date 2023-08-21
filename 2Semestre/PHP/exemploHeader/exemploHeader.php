<?php

$x = 1;

//echo $x;

if($x <= 5):
	header('Location: sucesso.php');
else:
	header('Location: erro.php');
endif;

?>