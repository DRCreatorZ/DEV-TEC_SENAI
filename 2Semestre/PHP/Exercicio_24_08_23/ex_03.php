<?php
	$salarioHora = $_GET['salarioHora'];
    $horasTrabalhadas = $_GET['horasTrabalhadas'];
	
	function contraCheque($salarioHora, $horasTrabalhadas){
        echo '****Folha de Pagamento****<br>';
        $sB = ($salarioHora * $horasTrabalhadas);
        $salarioBruto = 'Salário Bruto: ...........R$' .$sB.'<br>';
        $iR = 'Imposto de Renda: ....R$' .$sB * (11/100) .'<br>';
        $inss = 'INSS: ........................R$' .$sB * (8/100) .'<br>';
        $sindicato = 'Sindicato: ..................R$' .$sB * (5/100) .'<br>';
        $salarioLiquido = 'Salário Líquido: ........R$' .$sB-$sB*(24/100).'<br>';

        return $salarioBruto .$iR .$inss .$sindicato .$salarioLiquido;


    }
    
 echo contraCheque($salarioHora,$horasTrabalhadas);
?>
