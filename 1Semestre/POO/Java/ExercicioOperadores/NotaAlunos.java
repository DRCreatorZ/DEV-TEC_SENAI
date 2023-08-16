package ExercicioOperadores;

import java.util.Scanner;

public class NotaAlunos {
    Scanner sc = new Scanner(System.in);

    public void aprovacaoAluno() {
        System.out.println("=========================================");
        System.out.println("Qual o valor da Nota 1? ");
        int Nota1 = sc.nextInt();
        System.out.println("Qual valor da Nota 2? ");
        int Nota2 = sc.nextInt();

        System.out.println("========================================");
        double media = (Nota1 + Nota2) / 2;
        System.out.println("A media do Aluno é >> " + media);

        System.out.println("========================================");
        boolean mediaAprovado = media >= 50;
        System.out.println("O aluno está aprovado por nota? >> " + mediaAprovado);

        System.out.println("========================================");
        System.out.println("Qual a frequência do Aluno? >> ");
        int frequencia = sc.nextInt();

        System.out.println("=========================================");
        boolean frequenciaAprovado = frequencia >= 75;
        System.out.println("O aluno está aprovado por frequência? >> " + frequenciaAprovado);

        System.out.println("=========================================");
        boolean aprovacaoFinal = mediaAprovado && frequenciaAprovado;
        System.out.println("O aluno está aprovado no Curso? >> " + aprovacaoFinal);

        System.out.println("=========================================");
    }
}
