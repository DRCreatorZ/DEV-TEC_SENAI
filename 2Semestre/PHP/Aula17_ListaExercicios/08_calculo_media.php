<?php
// Verifica se as notas foram enviadas pelo formulário
if(isset($_POST['nota1']) && isset($_POST['nota2']) && isset($_POST['nota3'])) {
    // Recebe as notas do formulário e as insere em um array
    $notas = array(
        floatval($_POST['nota1']),
        floatval($_POST['nota2']),
        floatval($_POST['nota3'])
    );

    // Calcula a média geral
    $media = array_sum($notas) / count($notas);

    // Verifica se o aluno foi aprovado ou reprovado e exibe a mensagem correspondente
    if ($media >= 6) {
        $status = "Aprovado";
    } else {
        $status = "Reprovado";
    }

    // Exibe a média final e o status
    echo "<h2>Boletim Escolar <br>";
    echo "Nota 1 = {$notas[0]} | Nota 2 = {$notas[1]} | Nota 3 = {$notas[2]} | Média = $media [$status].";
}
?>
