package AtividadeFormativa;

import java.util.Scanner;
import java.util.Random;

public class Atividade2 {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    public void atividade2() {
        int numeroAleatorio = rd.nextInt(1000);
        System.out.println("Tente adivinhar um número de 1 a 1000!!! ");
        System.out.println("(Aperte CTRL+C, a qualquer momento, para parar!)");
        System.out.println("Digite o Número: ");
        int numero = sc.nextInt();
        int cont = 1;
        while (numero != numeroAleatorio) {

            if (numero < numeroAleatorio) {
                System.out.println("Seu palpite é menor que o número sorteado!!!! Tente outra vez!!!");
                numero = sc.nextInt();
                cont++;
            }
            if (numero > numeroAleatorio) {
                System.out.println("Seu palpite é maior que o número sorteado!!!! Tente outra vez!!!");
                numero = sc.nextInt();
                cont++;
            }
        }
        System.out.println("Parabéns, você acertou!!!");
        System.out.println("Você precisou de " + cont + " tentativas!!!");
    }

    public void atividade22() {
        int numeroAleatorio = rd.nextInt(5);
        double palpite[] = new double[] { numeroAleatorio };
        for (int i = 0; i < palpite.length; i++) {
            System.out.print("Tente adivinhar um número: ");
            palpite[i] = sc.nextDouble();
            if (palpite[i] > numeroAleatorio) {
                System.out.println("Seu palpite é maior que o número sorteado!!!!");
            }
            if (palpite[i] < numeroAleatorio) {
                System.out.println("Seu palpite é menor que o número sorteado!!!!");
            }
            if (palpite[i] != numeroAleatorio) {
                System.out.println("ERRADO!!! Tente outra vez!!!");
            }

        }

    }
}
