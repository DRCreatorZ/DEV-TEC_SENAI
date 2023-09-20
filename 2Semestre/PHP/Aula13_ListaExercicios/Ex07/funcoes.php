<?php
function mostrarMes($numero) {
    // Verifica se o número está no intervalo de 1 a 12
    if ($numero >= 1 && $numero <= 12) {
        $meses = [
            1 => "Janeiro",
            2 => "Fevereiro",
            3 => "Março",
            4 => "Abril",
            5 => "Maio",
            6 => "Junho",
            7 => "Julho",
            8 => "Agosto",
            9 => "Setembro",
            10 => "Outubro",
            11 => "Novembro",
            12 => "Dezembro"
        ];

        return "O mês correspondente é {$meses[$numero]}.";
    } else {
        return "Não existe mês com este número.";
    }
}
?>
