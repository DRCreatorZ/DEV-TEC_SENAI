<?php
// Verifica se o formulário foi submetido
if(isset($_POST['numero'])) {
    $numero = intval($_POST['numero']); // Converte para número inteiro

    // Verifica se o número é par ou ímpar
    if ($numero % 2 == 0) {
        $resultado = "O número $numero é par.";
    } else {
        $resultado = "O número $numero é ímpar.";
    }

    // Exibe o resultado na página
    echo "<h2>$resultado</h2>";
}
?>