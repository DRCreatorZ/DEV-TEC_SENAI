<?php

class ContaBancaria {
    private $nome;
    private $numeroConta;
    private $saldo;

    public function __construct($nome, $numeroConta) {
        $this->nome = $nome;
        $this->numeroConta = $numeroConta;
        $this->saldo = 100.00; // Saldo inicial
    }

    // Getters
    public function getNome() {
        return $this->nome;
    }

    public function getNumeroConta() {
        return $this->numeroConta;
    }

    public function getSaldo() {
        return $this->saldo;
    }

    // Setters
    public function setNome($nome) {
        $this->nome = $nome;
    }

    public function setNumeroConta($numeroConta) {
        $this->numeroConta = $numeroConta;
    }

    public function setSaldo($saldo) {
        $this->saldo = $saldo;
    }

    public function abrirConta() {
        echo "Conta aberta com sucesso para {$this->nome}. Saldo inicial: R$100,00\n";
    }

    public function sacar($valor) {
        if ($valor > 0 && $valor <= $this->saldo) {
            $this->saldo -= $valor;
            echo "Saque de R$ {$valor} realizado com sucesso. Novo saldo: R$ {$this->saldo}\n";
        } else {
            echo "Saldo insuficiente ou valor de saque inválido. Operação não realizada.\n";
        }
    }

    public function depositar($valor) {
        if ($valor > 0) {
            $this->saldo += $valor;
            echo "Depósito de R$ {$valor} realizado com sucesso. Novo saldo: R$ {$this->saldo}\n";
        } else {
            echo "Valor de depósito inválido. Operação não realizada.\n";
        }
    }

    public function consultarSaldo() {
        echo "Saldo atual: R$ {$this->saldo}\n";
    }

    public function consultarDadosCliente() {
        echo "Nome: {$this->nome}\n";
        echo "Número da Conta: {$this->numeroConta}\n";
        echo "Saldo: R$ {$this->saldo}\n";
    }
}

?>