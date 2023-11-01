<?php
// Verifica se o nome e a idade foram enviados pelo formulário
if(isset($_POST['nome']) && isset($_POST['idade'])) {
    // Recebe o nome e a idade do formulário
    $nome = $_POST['nome'];
    $idade = intval($_POST['idade']); // Converte para número inteiro

    // Verifica se a idade é maior ou igual a 18
    if ($idade >= 18) {
        $mensagem = "$nome tem $idade anos, portanto já é maior de idade.";
    } else {
        $mensagem = "$nome tem $idade anos, portanto não é maior de idade.";
    }

    // Exibe a mensagem
    echo "<h2>$mensagem</h2>";
}
?>