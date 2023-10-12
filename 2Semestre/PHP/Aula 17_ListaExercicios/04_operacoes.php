<?php
// Verifica se a operação e os números foram submetidos pelo formulário
if(isset($_POST['operacao']) && isset($_POST['numero1']) && isset($_POST['numero2'])) {
    $operacao = $_POST['operacao'];
    $numero1 = floatval($_POST['numero1']); // Converte para número com ponto flutuante
    $numero2 = floatval($_POST['numero2']); // Converte para número com ponto flutuante

    // Realiza a operação de acordo com a escolha do usuário
    switch($operacao) {
        case 'soma':
            $resultado = $numero1 + $numero2;
            break;
        case 'subtracao':
            $resultado = $numero1 - $numero2;
            break;
        case 'multiplicacao':
            $resultado = $numero1 * $numero2;
            break;
        case 'divisao':
            // Verifica se o segundo número é diferente de zero para evitar divisão por zero
            if ($numero2 != 0) {
                $resultado = $numero1 / $numero2;
            } else {
                $resultado = "Erro: Divisão por zero.";
            }
            break;
        default:
            $resultado = "Operação inválida.";
            break;
    }

    // Exibe o resultado na página
    echo "<h2>O resultado da operação é: $resultado</h2>";
}
?>





