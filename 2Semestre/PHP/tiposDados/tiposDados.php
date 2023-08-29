<?php

	//string
	$str = "12132";
	var_dump($str);

	echo "<br>";

	if (is_string($str)):
		echo "É uma variável string";
	else:
		echo "Não é uma variável string";
	endif;

	echo "<hr>";

	//int
	$numero = 1;
	var_dump($numero);

	echo "<br>";

	if (is_int($numero)):
		echo "É uma variável inteira";
	else:
		echo "Não é uma variável inteira";
	endif;

	echo "<hr>";

	//ponto flutuante
	$real = 1.50;
	var_dump($real);

	echo "<br>";

	if (is_float($real)):
		echo "É uma variável float";
	else:
		echo "Não é uma variável float";
	endif;

	echo "<hr>";

	//booleana
	$bool = true;
	var_dump($bool);

	echo "<br>";

	if (is_bool($bool)):
		echo "É uma variável booleana";
	else:
		echo "Não é uma variável booleana";
	endif;

	echo "<hr>";

	//array
	$frutas = array("Melancia", "Uva", "Morango");
	var_dump($frutas);

	echo "<br>";

	if (is_array($frutas)):
		echo "É uma variável array";
	else:
		echo "Não é uma variável array";
	endif;

	echo "<hr>";

	//objeto
	class Alunos{

		public $nome;
		public function nomeAluno($nome){
			$this->$nome = $nome;
		}
	}

	$aluno = new Alunos();
	$aluno->nomeAluno("João");
	var_dump($aluno);

	echo "<br>";

	if (is_object($aluno)):
		echo "É uma variável objeto";
	else:
		echo "Não é uma variável objeto";
	endif;

	echo "<hr>";

	//null
	$saldo = NULL;
	var_dump($saldo);

	echo "<br>";

	$a = 10;
	$b = 50;

	if ($a > $b) {
		echo "a é maior a b";
	} elseif ($a == $b) {
		echo "a é igual a b";
	}else{
		echo "a é menor a b";
	}

	echo "<hr>";

	$i = 3;
	switch ($i) {
		case 0:
			echo "i é igual a 0";
			break;
		case 1:
			echo "i é igual a 1";
			break;
		case 2:
			echo "i é igual a 2";
			break;
		default:
		echo "i não é igual a 0, 1 ou 2.";
	}

?>