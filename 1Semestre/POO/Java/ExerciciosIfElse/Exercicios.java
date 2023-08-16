package ExerciciosIfElse;

import java.util.Scanner;

public class Exercicios {
    Scanner sc = new Scanner(System.in);

    public void exercicio1() {
        System.out.println("Informe o primeiro valor inteiro");
        int valor1 = sc.nextInt();
        System.out.println("Informe o segundo valor inteiro");
        int valor2 = sc.nextInt();

        if (valor1 > valor2) {
            System.out.println("O maior valor é: " + valor1);
        } else {
            System.out.println("O maior valor é: " + valor2);
        }
    }

    public void exercicio2() {
        System.out.println("Informe o seu ano de nascimento");
        int anoNascimento = sc.nextInt();

        if (anoNascimento <= 2007) {
            System.out.println("Você pode votar esse ano!");
        } else {
            System.out.println("Você ainda não pode votar esse ano!");
        }
    }

    public void exercicio3() {
        System.out.println("Informe a senha de Acesso");
        int senha = sc.nextInt();

        if (senha == 1234) {
            System.out.println("ACESSO PERMITIDO!");
        } else {
            System.out.println("ACESSO NEGADO!");
        }
    }

    public void exercicio4() {
        System.out.println("Informe quantas maçãs foram compradas: ");
        double quantidadeMacas = sc.nextDouble();
        double valorMacas;

        if (quantidadeMacas >= 12) {
            valorMacas = 0.25;
        } else {
            valorMacas = 0.30;
        }
        double valorCompra = (valorMacas * quantidadeMacas);
        System.out.println("A compra sairá por R$" + valorCompra + ".");
    }

    public void exercicio5() {
        System.out.println("Informe o primeiro número");
        double X = sc.nextDouble();
        System.out.println("Informe o segundo número");
        double Y = sc.nextDouble();
        System.out.println("Informe o terceiro número");
        double Z = sc.nextDouble();

        if (X < Y && Y < Z) {
            System.out.println("A Sequência numéria em ordem crescente é: " + X + " > " + Y + " > " + Z);
        } else if (X < Z && Z < Y) {
            System.out.println("A Sequência numéria em ordem crescente é: " + X + " > " + Z + " > " + Y);
        } else if (Y < X && X < Z) {
            System.out.println("A Sequência numéria em ordem crescente é: " + Y + " > " + X + " > " + Z);
        } else if (Y < Z && Z < X) {
            System.out.println("A Sequência numéria em ordem crescente é: " + Y + " > " + Z + " > " + X);
        } else if (Z < Y && Y < X) {
            System.out.println("A Sequência numéria em ordem crescente é: " + Z + " > " + Y + " > " + X);
        } else if (Z < Y && Y < X) {
            System.out.println("A Sequência numéria em ordem crescente é: " + Z + " > " + X + " > " + Y);
        }
    }

    public void exercicio6() {
        System.out.println("Informe sua Altura");
        double altura = sc.nextDouble();
        System.out.println("Informe o Sexo:(1) Masculino ou (2)Feminino");
        double sexo = sc.nextDouble();
        double pesoIdealHomem = 72.7 * altura - 58;
        double pesoIdealMulher = 62.1 * altura - 44.7;

        if (sexo == 1) {
            System.out.println("Seu peso ideal é: " + pesoIdealHomem + "Kg.");
        } else {
            System.out.println("Seu peso ideal é: " + pesoIdealMulher + "Kg.");
        }
    }

    public void exercicio7() {
        System.out.println("=========================================");
        System.out.println("Informe o valor da Nota 1. ");
        int Nota1 = sc.nextInt();
        System.out.println("Informe valor da Nota 2.");
        int Nota2 = sc.nextInt();

        System.out.println("========================================");
        double media = (Nota1 + Nota2) / 2;
        System.out.println("A media do Aluno é >> " + media);

        if (media >= 50) {
            System.out.println("O aluno está aprovado por nota!");
        } else {
            System.out.println("O aluno está reprovado por nota!");
        }

        System.out.println("========================================");
        System.out.println("Informe a frequência do Aluno. ");
        int frequencia = sc.nextInt();

        if (frequencia >= 75) {
            System.out.println("O aluno está aprovado por freqência!");
        } else {
            System.out.println("O aluno está reprovado por frequência!");
        }
        System.out.println("========================================");
        if (media >= 50 && frequencia >= 75) {
            System.out.println("<<O aluno está aprovado no Curso!>>");
        } else {
            System.out.println("<<O aluno está reprovado no Curso!>>");
        }
    }

    public void exercicio8() {
        System.out.println("Informe um número Inteiro");
        int numero = sc.nextInt();

        double restoDivisao = numero % 2.0;
        ;

        if (restoDivisao == 0) {
            System.out.println("O Número (" + numero + ") é Par!");
        } else {
            System.out.println("O Número (" + numero + ") é Ímpar!");
        }
    }

    public void exercicio9() {
        System.out.println("Informe sua Nota");
        double nota = sc.nextDouble();
        if (nota >= 7) {
            System.out.println("Passou direto!");
        } else if (nota >= 5 && nota < 7) {
            System.out.println("Têm direito de fazer uma prova de recuperação!");
        } else {
            System.out.println("Reprovado direto!");
        }
    }

}