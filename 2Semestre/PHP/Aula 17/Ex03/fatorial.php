<?php
if(isset($_POST['numero'])) {
    $numero = intval($_POST['numero']); // Converte para número inteiro

    $fatorial = 1;
    for ($i = $numero; $i > 0; $i--) {
        $fatorial *= $i;
    }

    echo "<h2>O fatorial de $numero é $fatorial</h2>";
}
?>