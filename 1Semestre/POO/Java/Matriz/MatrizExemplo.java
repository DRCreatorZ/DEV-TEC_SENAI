package Matriz;

import java.util.Scanner;
import java.util.Random;

public class MatrizExemplo {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    public void exemplo1() {
        // criar uma matriz 10x9, preencher, imprimir e manipular
        // declarar a matriz
        int matriz[][] = new int[10][9];// 10 linhas x 9 colunas
        // preencher a matriz
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
               // System.out.print("matriz[" + i + "]+[" + j + "]=");
                matriz[i][j] = rd.nextInt(9);
            }
        }
        // imprimir a matriz (posição por posição)
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.println("matriz[" + i + "]+[" + j + "]=" + matriz[i][j]);
            }
        }
        //imprimindo em formato de matriz
        for (int i = 0; i < 10; i++) {
            System.out.print("| ");
            for (int j = 0; j < 9; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }
        //somar todos os elementos da 4ª linha
        int somaL = 0;
        for (int i = 0; i < 9; i++) {
            somaL += matriz[3][i];
        }
        System.out.println("A soma dos elementos da 4ª linha é: " + somaL);

        //somar todos os elementos da 4ª coluna
        int somaC = 0;
        for (int i = 0; i < 10; i++) {
            somaC += matriz[i][3];
        }
        System.out.println("A soma dos elementos da 4ª coluna é: " + somaC);
    }
}
