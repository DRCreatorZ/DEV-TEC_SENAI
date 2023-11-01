<?php
// Verifica se os valores foram enviados pelo formulário
if(isset($_POST['a']) && isset($_POST['b']) && isset($_POST['c']) && isset($_POST['d']) && isset($_POST['e'])) {
    // Recebe os valores do formulário
    $a = intval($_POST['a']);
    $b = intval($_POST['b']);
    $c = intval($_POST['c']);
    $d = intval($_POST['d']);
    $e = intval($_POST['e']);

    // Cria um array com os valores
    $valores = array($a, $b, $c, $d, $e);

    // Ordena o array em ordem crescente
    sort($valores);

    // Imprime os valores em ordem crescente
    echo "<h2>A ordem crescente dos valores digitados é: " ;
    foreach($valores as $valor) {
    echo "$valor . ";
    }
}
?>