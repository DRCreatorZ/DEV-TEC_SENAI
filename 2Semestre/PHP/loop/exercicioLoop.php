<?php

//Exercício 1
//Receba 4 notas de um aluno e calcule sua média, dizendo se ele foi:
//A - Aprovado - media >=7
//B - Exame - media >=5
//C - Reprovado - media <5

$nota01 = 06;
$nota02 = 06;
$nota03 = 06;
$nota04 = 06;
$resultado = 0;

$media = ($nota01+$nota02+$nota03+$nota04)/4;
	echo "Media = ".$media." - ";

if ($media >= 7) {
	$resultado = 0;
		} elseif ($media >= 5) {
		$resultado = 1;
		} else {
		$resultado = 2;
	}

switch ($resultado) {
	case 0:
		echo "Aprovado";
		break;
	case 1:
		echo "Exame";
		break;
	default:
	echo "Reprovado";
	}

	echo "<hr>";

//Exercício 2
//Crie duas variáveis $sexo e $tempo_de_serviço e sabendo que homens só se aposentam com pelo menos 35 anos de serviço e mulheres com pelo menos 30, crie o script PHP que diz se a pessoa pode aposentar ou não.

	$sexo = "homem";
	$tempoDeServiço= 30;

	if ($sexo == "mulher" && $tempoDeServiço >=30) {
		echo "Aposentou!";
	}elseif ($sexo == "homem" && $tempoDeServiço >=35){
		echo "Aposentou!";
	}else {
		echo "Não Aposentou!";
	}
	
?>