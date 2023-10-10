<?php
// Verifica se os valores foram enviados pelo formulário
if(isset($_POST['a']) && isset($_POST['b'])) {
    // Recebe os valores do formulário e converte para números inteiros
    $a = intval($_POST['a']);
    $b = intval($_POST['b']);

    // Compara os valores e imprime a mensagem correspondente
    if($a > $b) {
        echo "A maior que B";
    } elseif($a < $b) {
        echo "A menor que B";
    } else {
        echo "A igual a B";
    }
}
?>
