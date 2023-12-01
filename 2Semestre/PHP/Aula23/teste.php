<?php

    require_once 'Veiculo.php';
    // require_once 'Carro.php';
    require_once 'Moto.php';

    $veiculo = new Veiculo();
    // //$veiculo->marca = "Honda";
    // $veiculo->setMarca("Suzuki");
    // //echo $veiculo->marca . "<br>";
    // echo $veiculo->getMarca() . "<br>";

    $veiculo->setModelo("GSR1000");
    echo $veiculo->getModelo() . "<br>";

    $veiculo->setCor = "Preta";
    $veiculo->getCor();
    $veiculo->chamarAcao();
    
    
    echo "<pre>";
    print_r($veiculo);
    echo "</pre>";
    echo "<br>";
    echo "<pre>";
    var_dump($veiculo);
    echo "</pre>";
?>