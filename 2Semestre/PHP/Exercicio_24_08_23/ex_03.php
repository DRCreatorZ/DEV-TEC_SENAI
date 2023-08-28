<?php
	$salarioHora = $_GET['salarioHora'];
    $horasTrabalhadas = $_GET['horasTrabalhadas'];
	
	function contraCheque($salarioHora, $horasTrabalhadas){
        $salarioBruto = 'Salário Bruto: ....R$' .($salarioHora * $horasTrabalhadas) .'<br>';
        $iR = 'Imposto de Renda: ....R$' .(($salarioHora * $horasTrabalhadas) * (11/100)) .'<br>';
        $inss = 'INSS: ....R$' .(($salarioHora * $horasTrabalhadas) * (8/100)) .'<br>';
        $sindicato = 'Sindicato: ....R$' .(($salarioHora * $horasTrabalhadas) * (5/100)) .'<br>';
        $salarioLiquido = 'Salário Líquido: ....R$' .(($salarioHora * $horasTrabalhadas)-($salarioHora * $horasTrabalhadas)*(24/100)).'<br>';

        return $salarioBruto .$iR .$inss .$sindicato .$salarioLiquido;


    }
    
 echo contraCheque($salarioHora,$horasTrabalhadas);
?>
