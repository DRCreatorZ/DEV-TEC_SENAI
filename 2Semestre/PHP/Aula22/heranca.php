<?php

class Veículo{
    private $marca;
    private $modelo;

    public function Ligar()
    {
        echo "Ligando...";
    }

    public function Desligar()
    {
        echo "Desligando...";
    }
}

class Carro extends Veículo{
    private $numPortas;
    public function Acelerar()
    {
        echo "Acelerando...";
    }
}

class Moto extends Veículo{
    private $numPortas;
    public function Acelerar()
    {
        echo "Acelerando a moto";
    }
}

$carro = new Carro();
$carro->marca = "Honda";
//echo $carro->marca;

$moto = new Moto();
$moto->Ligar();
$moto->Acelerar();
$moto->Desligar();
?>