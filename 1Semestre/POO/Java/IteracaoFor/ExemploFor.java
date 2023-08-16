package IteracaoFor;

import java.util.Scanner;

public class ExemploFor {
    Scanner sc = new Scanner(System.in);

    public void exemplo1() {
        for (int i=0;i<10;i++){
            System.out.println("O n° da iteração é: " +i);
        }
    }
    public void exemplo2() {
        int vetor[]=new int[10];
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Vetor ["+i+"]=");
            vetor[i]=sc.nextInt();
        }
        for (int i = 9; i >=0; i--) {
            System.out.println("Vetor ["+i+"]="+vetor[i]);
        }
    }
    public void exemplo3() {
        double carrinhoCompra[] = new double[]{19.90, 35.70, 56.80,97.50};
        double valorFinal =0;
        for (int i = 0; i < carrinhoCompra.length; i++) {
            //System.out.print("Insira valor do produto: ");
           // carrinhoCompra[i]=sc.nextDouble();
            valorFinal += carrinhoCompra[i];
            System.out.println("Valor parcial da compra é R$: "+valorFinal);
        }
        System.out.println("O valor da compra é R$: " +valorFinal);
    }
    public void exemplo4() {
        double vetorNotas[] = new double[4];
        for (int i = 0; i < vetorNotas.length; i++) {
            System.out.println("Digite a Nota "+(i+1)+":");
            vetorNotas[i]=sc.nextDouble();
        }
        double mediaNotas=0;
        for (int i = 0; i < vetorNotas.length; i++) {
            mediaNotas += vetorNotas[i];
            System.out.println("A " +(i+1)+" Nota é: "+vetorNotas[i]);
        }
        mediaNotas/=vetorNotas.length;
            System.out.println("A Média do Aluno é: "+mediaNotas);
    }
}
