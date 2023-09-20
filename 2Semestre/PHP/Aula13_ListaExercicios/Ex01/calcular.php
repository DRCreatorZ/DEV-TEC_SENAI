<?php
include 'funcoes.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $area = $_POST["area"];

    // Verifica se a área é um número positivo
    if (!is_numeric($area) || $area <= 0) {
        echo "A área informada é inválida. Por favor, insira um número positivo.";
        exit;
    }

    $quantidadeTinta = calcularQuantidadeTinta($area);

    $quantidadeLatas = calcularQuantidadeLatas($quantidadeTinta);
    $quantidadeGaloes = calcularQuantidadeGaloes($quantidadeTinta);
    list($quantidadeLatasMisturadas, $quantidadeGaloesMisturados) = calcularQuantidadeMisturada($quantidadeTinta);

    $precoLatas = calcularPrecoLatas($quantidadeTinta);
    $precoGaloes = calcularPrecoGaloes($quantidadeTinta);
    $precoMisturado = calcularPrecoMisturado($quantidadeTinta);

    echo "- Quantidade de tinta necessária: {$quantidadeTinta} litros.<br><hr>";
    echo "- Preço comprando apenas latas: R$ {$precoLatas}<br>";
    echo "- Quantidade de latas usadas: {$quantidadeLatas}<br><br>";

    echo "- Preço comprando apenas galões: R$ {$precoGaloes}<br>";
    echo "- Quantidade de galões usados: {$quantidadeGaloes}<br><br>";

    echo "- Preço comprando misturando latas e galões: R$ {$precoMisturado}<br>";
    echo "- Quantidade de latas e galões juntos: {$quantidadeLatasMisturadas} latas e {$quantidadeGaloesMisturados} galões<br>";
    
    
} else {
    echo "Erro ao processar a requisição. Por favor, volte à página inicial.";
}
?>
