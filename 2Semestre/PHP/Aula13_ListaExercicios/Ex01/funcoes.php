<?php

// Função para calcular a quantidade de tinta necessária
function calcularQuantidadeTinta($area)
{
    // Considerando 10% de folga
    $areaComFolga = $area * 1.1;

    // 1 litro de tinta para cada 3 metros quadrados
    return ceil($areaComFolga / 3);
}

// Função para calcular o preço de latas de 18 litros
function calcularPrecoLatas($quantidade)
{
    $litrosPorLata = 18;
    $precoPorLata = 80;

    $quantidadeLatas = ceil($quantidade / $litrosPorLata);

    return $quantidadeLatas * $precoPorLata;
}

// Função para calcular o preço de galões de 3,6 litros
function calcularPrecoGaloes($quantidade)
{
    $litrosPorGalao = 3.6;
    $precoPorGalao = 25;

    $quantidadeGaloes = ceil($quantidade / $litrosPorGalao);

    return $quantidadeGaloes * $precoPorGalao;
}

// Função para calcular o preço misturando latas e galões
function calcularPrecoMisturado($quantidade)
{
    $litrosPorLata = 18;
    $litrosPorGalao = 3.6;
    $precoPorLata = 80;
    $precoPorGalao = 25;

    $quantidadeLatas = floor($quantidade / $litrosPorLata);
    $resto = $quantidade % $litrosPorLata;
    $quantidadeGaloes = ceil($resto / $litrosPorGalao);

    $precoTotalLatas = $quantidadeLatas * $precoPorLata;
    $precoTotalGaloes = $quantidadeGaloes * $precoPorGalao;

    return $precoTotalLatas + $precoTotalGaloes;
}

// Função para calcular a quantidade de latas necessárias
function calcularQuantidadeLatas($quantidade)
{
    $litrosPorLata = 18;

    return ceil($quantidade / $litrosPorLata);
}

// Função para calcular a quantidade de galões necessários
function calcularQuantidadeGaloes($quantidade)
{
    $litrosPorGalao = 3.6;

    return ceil($quantidade / $litrosPorGalao);
}

// Função para calcular a quantidade de latas e galões misturados
function calcularQuantidadeMisturada($quantidade)
{
    $litrosPorLata = 18;
    $litrosPorGalao = 3.6;

    $quantidadeLatas = floor($quantidade / $litrosPorLata);
    $resto = $quantidade % $litrosPorLata;
    $quantidadeGaloes = ceil($resto / $litrosPorGalao);

    return array($quantidadeLatas, $quantidadeGaloes);
}

?>
