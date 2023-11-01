<?php

	$senha = "123456";

	$opcao = [
		'cost' => 10
	];

	$senhaSegura = password_hash($senha, PASSWORD_DEFAULT, $opcao);


	echo "Senha: " .$senha . "<br>";
	echo "Senha Segura: " .$senhaSegura . "<br>";
	
	$senhaBD = '$2y$10$/49xMB8H8DjSZ5/43IBReeUP.AHsCG76McU.iyMiaaJukezI874.6';

	echo "<br><hr>";

	if (password_verify($senha, $senhaBD)):
		echo "Senha Correta!";
	else:
		echo "Senha Inválida!";
	endif;


?>