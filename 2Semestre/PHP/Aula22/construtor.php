<?php

class Carro
{

    private $marca;
    private $modelo;
    private $cor;

    public function __construct($marca,$modelo,$cor){
        $this->marca = $marca;
        $this->setModelo($modelo);
        $this->cor = $cor;
    }

    public function getMarca(){
        return $this->marca;
    }

    public function setMarca($m){
        $this->marca = $m;
    }

    public function getModelo(){
        return $this->modelo;
    }

    public function setModelo($m){
        $this->modelo = $m;
    }

    public function getCor(){
        return $this->cor;
    }

    public function setCor($m){
        $this->cor = $m;
    }
}

$carro = new Carro("Toyota", "Hilux","Prata");

// $carro->setMarca("Honda");
// $carro->setModelo("City");
echo "Marca: " . $carro->getMarca() . "\n";
echo "Modelo: " . $carro->getModelo() . "\n";
echo "Cor: " . $carro->getCor(). "\n";

$carros2 = new Carro("","","");

$carros2->setMarca(readline("Digite a marca do veiculo: "));
$carros2->setModelo(readline("Digite o modelo do veiculo: "));
$carros2->setCor(readline("Digite a cor do veiculo: "));
echo "Marca: " . $carros2->getMarca() . "\n";
echo "Modelo: " . $carros2->getModelo() . "\n";
echo "Cor: " . $carros2->getCor() . "\n";

?>