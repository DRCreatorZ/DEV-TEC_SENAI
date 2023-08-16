package AtividadeFormativa;

import java.util.Scanner;
import java.util.Random;

public class Atividade3 {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    public void atividade3() {
        int vetor[] = new int[rd.nextInt(100, 1000)];
        int cPar = 0;
        int cImpar = 0;

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rd.nextInt(100);
        }
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) {
                System.out.println(vetor[i] + ": É Par");
            }
        }
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 1) {
                System.out.println(vetor[i] + ": É Ímpar");
            }
        }
        for (int i = 1; i < vetor.length; i += 2) {
            if (vetor[i] % 2 == 0) {
                cPar++;
            }
        }
        for (int i = 0; i < vetor.length; i += 2) {
            if (vetor[i] % 2 == 1) {
                cImpar++;
            }
        }
        System.out.println("Foram sorteados " + vetor.length + " Números!!!");
        System.out.println("Números Pares em posição Ímpar aparecem " + cPar + " vezes!!!");
        System.out.println("Números Ímpares em posição Par aparecem " + cImpar + " vezes!!!");
    }
}
