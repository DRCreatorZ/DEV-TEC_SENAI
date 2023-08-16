package AtividadeFormativa;

import java.util.Scanner;
import java.util.Random;

public class Atividade1 {

    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    public void atividade1() {
        System.out.println("Informe o número de linhas da Matriz");
        int linhas = sc.nextInt();
        System.out.println("Informe o número de colunas da Matriz");
        int colunas = sc.nextInt();
        int matriz[][] = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = rd.nextInt(9);
            }
        }
        System.out.println("-------------");
        System.out.println("Matriz 1");
        System.out.println("-------------");
        for (int i = 0; i < linhas; i++) {
            System.out.print("| ");
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
        System.out.println("Matriz 2");
        System.out.println("-------------");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (i > j) {
                    matriz[i][j] = 1;
                }
                if (i == j) {
                    matriz[i][j] = 0;
                }
                if (j > i) {
                    matriz[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < linhas; i++) {
            System.out.print("| ");
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }
    }
}
