package ProvaJava23marco23;

import java.util.Scanner;

public class Prova {
    Scanner sc = new Scanner(System.in);

    public void exercicio1() {
        System.out.println("Insira um Número Decimal para realização de uma Operação Aritimética: ");
        double n1 = sc.nextDouble();
        System.out.println("Insira mais um Número Decimal para realização de uma Operação Aritimética: ");
        double n2 = sc.nextDouble();

        System.out.println(
                "Escolha a Operação Aritimética a ser realizada (somente número): 1- ADIÇÃO; 2- SUBTRAÇÃO; 3- DIVISÃO; 4-MULTIPLICAÇÃO");
        double operacao = sc.nextDouble();

        if (operacao == 1) {
            System.out.println("A Operação escolhida foi: " + n1 + " + " + n2 + " = " + (n1 + n2));
        } else if (operacao == 2) {
            System.out.println("A Operação escolhida foi: " + n1 + " - " + n2 + " = " + (n1 - n2));
        } else if (operacao == 3) {
            System.out.println("A Operação escolhida foi: " + n1 + " / " + n2 + " = " + (n1 / n2));
        } else if (operacao == 4) {
            System.out.println("A Operação escolhida foi: " + n1 + " x " + n2 + " = " + (n1 * n2));
        } else  {
            System.out.println("Número de Operação Inválido!!!");
        }
    }

    public void exercicio2() {
        System.out.println("Informe o Número de Matrícula do Aluno (1 a 1000): ");
        int nMatricula = sc.nextInt();

        if (nMatricula > 0 && nMatricula <= 250) {
            System.out.println("Parabéns, você é do TIME CHRIS!!!");
        } else if (nMatricula > 250 && nMatricula <= 500) {
            System.out.println("Parabéns, você é do TIME GREG!!!");
        } else if (nMatricula > 500 && nMatricula <= 750) {
            System.out.println("Parabéns, você é do TIME CARUSO!!!");
        } else if (nMatricula > 750 && nMatricula <= 1000) {
            System.out.println("Parabéns, você é do TIME JEROME!!!");
        } else {
            System.out.println("Número de matrícula INVÁLIDO!!!");
        }
    }

    public void exercicio3() {
        double morango = 2.50;
        double maca = 1.80;
        double banana = 1.30;

        System.out.println("Informe quantos Quilos de Morango, Maçã e Bananas foram comprados Respectivamente: ");
        double KgMorango = sc.nextDouble();
        double KgMaca = sc.nextDouble();
        double KgBanana = sc.nextDouble();

        double totalMorango = morango * KgMorango;
        double totalMaca = maca * KgMaca;
        double totalBanana = banana * KgBanana;

        double totalKgFrutas = KgMorango + KgMaca + KgBanana;
        double totalCompra = (totalMorango + totalMaca + totalBanana);
        double totalCompraDesconto = totalCompra - (totalCompra * 0.1);

        if (totalKgFrutas > 8 || totalCompra > 25) {
            System.out.println("O valor Total da Compra (com 10% de desconto) é de R$" + totalCompraDesconto);
        } else {
            System.out.println("O valor Total da Compra é de R$" + totalCompra);
        }
    }
}