package VetoresArrays;

import java.util.Scanner;

public class Vetores {
    Scanner sc = new Scanner(System.in);

    public void exemplo1() {
        // criar meu vetor
        double[] valores = new double[] { 10.5, 15.8, 7.5, -17.6 };
        System.out.println("O 1° Elemento do Vetor - valores[0] é " + valores[0]);
        System.out.println("O 2° Elemento do Vetor - valores[1] é " + valores[1]);
        System.out.println("O 3° Elemento do Vetor - valores[2] é " + valores[2]);
        System.out.println("O 4° Elemento do Vetor - valores[3] é " + valores[3]);
        System.out.println("Digite um novo Valor para a 4° posição/índice 3");
        valores[3] = sc.nextDouble();
        System.out.println("O novo Valor da 4° posição/índice 3 é " + valores[3]);
    }

    public void exemplo2() {
        // criar um vetor (vazio)
        int valoresInt[] = new int[5];
        System.out.println("Digite 5 Valores Inteiros");
        valoresInt[0] = sc.nextInt();
        valoresInt[1] = sc.nextInt();
        valoresInt[2] = sc.nextInt();
        valoresInt[3] = sc.nextInt();
        valoresInt[4] = sc.nextInt();
        System.out.println("O 1° Elemento do Vetor - índice[0] é " + valoresInt[0]);
        System.out.println("O 2° Elemento do Vetor - índice[1] é " + valoresInt[1]);
        System.out.println("O 3° Elemento do Vetor - índice[2] é " + valoresInt[2]);
        System.out.println("O 4° Elemento do Vetor - índice[3] é " + valoresInt[3]);
        System.out.println("O 5° Elemento do Vetor - índice[3] é " + valoresInt[4]);
    }

    public void exemplo3() {
        double[] numerosReais = new double[10];

        System.out.println("Digite 10 números Reais");
        numerosReais[0] = sc.nextDouble();
        numerosReais[1] = sc.nextDouble();
        numerosReais[2] = sc.nextDouble();
        numerosReais[3] = sc.nextDouble();
        numerosReais[4] = sc.nextDouble();
        numerosReais[5] = sc.nextDouble();
        numerosReais[6] = sc.nextDouble();
        numerosReais[7] = sc.nextDouble();
        numerosReais[8] = sc.nextDouble();
        numerosReais[9] = sc.nextDouble();
        System.out.println("A ordem inversa dos Números reais digitados é " + numerosReais[9]+", " + numerosReais[8]+", "
                + numerosReais[7]+", " + numerosReais[6] + numerosReais[5]+", " + numerosReais[4]+", " + numerosReais[3]+", "
                + numerosReais[2]+", " + numerosReais[1]+", " + numerosReais[0]);
    }

    public void exemplo4() {
        double[] notas = new double[4];

          System.out.println("Digite as 4 notas do Aluno");
        notas[0] = sc.nextDouble();
        notas[1] = sc.nextDouble();
        notas[2] = sc.nextDouble();
        notas[3] = sc.nextDouble();

        double media = (notas[0]+notas[1]+notas[2]+notas[3])/4;
        System.out.println("A notas são: "+notas[0]+", "+notas[1]+", "+notas[2]+", "+notas[3]+" "+"e a média é: "+media+"!!!");
    }
}
