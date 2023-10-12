<?php
// Verifica se o número foi enviado pelo formulário
if(isset($_POST['numero'])) {
    // Recebe o número do formulário e converte para inteiro
    $numero = intval($_POST['numero']);

    // Verifica se o número está dentro do intervalo de 1 a 12
    if($numero >= 1 && $numero <= 12) {
        // Cria um array com os nomes dos meses
        $meses = array(
            "Janeiro", "Fevereiro", "Março", "Abril",
            "Maio", "Junho", "Julho", "Agosto",
            "Setembro", "Outubro", "Novembro", "Dezembro"
        );

        // Obtém o nome do mês correspondente
        $nome_mes = $meses[$numero - 1];

        // Exibe o nome do mês
        echo "<h2>O número $numero corresponde ao mês de $nome_mes.</h2>";
    } else {
        // Exibe mensagem de erro se o número estiver fora do intervalo
        echo "<h2>Não existe mês com este número.</h2>";
    }
}
?>