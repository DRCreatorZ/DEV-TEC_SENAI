package IteracaoWhile;

import java.util.Random;
import java.util.Scanner;

public class ExemploWhile {
    Scanner sc = new Scanner (System.in);
    public void exemplo1() {
        int iteracao =0;
        while (iteracao<10) {
            iteracao+=1;
            System.out.println("Essa é a iteração de n° "+iteracao);
        }
    }
    public void exemplo2() {
        Random rd = new Random();
        int numeroAleatorio = rd.nextInt(10);
        boolean tentarNovamente = true;
        System.out.println("Aperte CTRL+C, a qualquer momento, para parar.");
        while (tentarNovamente) {
            System.out.println("Tente adivinhar um número: ");
            int numero = sc.nextInt();
            //tentarNovamente = numeroAleatorio !=numero;
            //if (tentarNovamente) {
               // System.out.println("ERRADO!!!");
            //}
            if (numero==numeroAleatorio) {
                System.out.println("Parabéns!!! Você advinhou o número!!! :)");
                tentarNovamente=false;
            } else {
                System.out.println("ERRADO!!! Tente outra vez!!!");
            }
        }
        //System.out.println("Parabéns!!! Você advinhou o número!!! :)");
    }
    public void exemplo3() {
        int vetor[] = new int[5];
        int i=0;
        while (i<5) {
            System.out.println("Digite o valor para o vetor ["+i+"]");
            vetor[i]=sc.nextInt();
            i++;
        }
        i=0;
        while (i<5) {
            System.out.println("O valor do vetor ["+i+"] é "+vetor[i]);
            i++;
        }
    }
}
