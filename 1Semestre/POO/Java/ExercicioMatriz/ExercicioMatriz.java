package ExercicioMatriz;

import java.util.Scanner;

public class ExercicioMatriz {

    Scanner sc = new Scanner(System.in);

    public void exercicio1() {
        int matrizI[][] = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    matrizI[i][j] = 1;
                } else {
                    matrizI[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.print("| ");
            for (int j = 0; j < 5; j++) {
                System.out.print(matrizI[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    public void exercicio2() {
        int matriz[][] = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.print("| ");
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }
    }
}