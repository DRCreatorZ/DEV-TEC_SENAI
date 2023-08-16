package IteracaoWhile;

public class ExerciciosWhile {
    public void exercicio1() {
        int vetorA[] = new int[] { 3, 5, 7, 11, 13 };
        int vetorB[] = new int[5];
        int i = 0;
        while (i < vetorA.length) {
            vetorB[i] = vetorA[i];
            System.out.println("VetorB[" + i + "]=" + vetorB[i]);
            i++;
        }
    }

    public void exercicio2() {
        int vetorA[] = new int[] { 5, 10, 15, 20, 25, 30, 35, 40 };
        double vetorB[] = new double[vetorA.length];
        int i = 0;
        while (i < vetorA.length) {
            vetorB[i] = vetorA[i] * 2;
            System.out.println("VetorB[" + i + "]=" + vetorB[i]);
            i++;
        }
    }

    public void exercicio3() {
        int vetorA[] = new int[] { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75 };
        double vetorB[] = new double[vetorA.length];
        int i = 0;
        while (i < vetorA.length) {
            vetorB[i] = vetorA[i] * vetorA[i];
            System.out.println("VetorB[" + i + "]=" + vetorB[i]);
            i++;
        }
    }

    public void exercicio4() {
        double vetorA[] = new double[] { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75 };
        double vetorB[] = new double[vetorA.length];
        int i = 0;
        while (i < vetorA.length) {
            vetorB[i] = Math.sqrt(vetorA[i]);
            System.out.println("VetorB[" + i + "]=" + vetorB[i]);
            i++;
        }
    }

    public void exercicio5() {
        int vetorA[] = new int[] { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 };
        int vetorB[] = new int[vetorA.length];
        int i = 0;
        while (i < vetorA.length) {
            vetorB[i] = vetorA[i] * i;
            System.out.println("VetorB[" + i + "]=" + vetorB[i]);
            i++;
        }
    }

    public void exercicio6() {
        int vetorA[] = new int[] { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 };
        int vetorB[] = new int[] { 50, 45, 40, 35, 30, 25, 20, 15, 10, 5 };
        int vetorC[] = new int[vetorA.length];
        int i = 0;
        while (i < vetorA.length) {
            vetorC[i] = vetorA[i] + vetorB[i];
            System.out.println("VetorB[" + i + "]=" + vetorC[i]);
            i++;
        }
    }
}