<?php
// Verifica se os valores foram enviados pelo formulário
if(isset($_POST['a']) && isset($_POST['b'])) {
    // Recebe os valores do formulário e converte para números inteiros
    $a = intval($_POST['a']);
    $b = intval($_POST['b']);

    // Compara os valores e imprime a mensagem correspondente
    if($a > $b) {
        echo "<h2>A é maior que B";
    } elseif($a < $b) {
        echo "A é menor que B";
    } else {
        echo "A é igual a B";
    }
}
?>
