<?php 

require_once 'ContaBancaria.php';
class MenuBanco extends ContaBancaria{
        public static function exibirMenu() {
            echo "1- Abrir conta\n";
            echo "2- Consultar saldo\n";
            echo "3- Sacar\n";
            echo "4- Depositar\n";
            echo "5- Consultar dados do cliente\n";
            echo "6- Sair\n";
        }
    }
    
    // Exemplo de uso
    echo "Digite seu nome: ";
    $nomeCliente = readline();
    
    echo "Digite o número da conta: ";
    $numeroContaCliente = readline();
    
    $conta = new ContaBancaria($nomeCliente, $numeroContaCliente);
    
    do {
        MenuBanco::exibirMenu();
        echo "Escolha uma opção: ";
        $opcao = readline();
    
        switch ($opcao) {
            case 1:
                $conta->abrirConta();
                break;
            case 2:
                $conta->consultarSaldo();
                break;
            case 3:
                echo "Digite o valor do saque: ";
                $valorSaque = readline();
                $conta->sacar($valorSaque);
                break;
            case 4:
                echo "Digite o valor do depósito: ";
                $valorDeposito = readline();
                $conta->depositar($valorDeposito);
                break;
            case 5:
                $conta->consultarDadosCliente();
                break;
            case 6:
                echo "Saindo do programa. Até mais!\n";
                break;
            default:
                echo "Opção inválida. Tente novamente.\n";
                break;
        }
    } while ($opcao != 6);

?>
