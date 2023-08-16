package AtividadeRevisao1;

import java.util.Scanner;

public class ExemploRevisão {
    Scanner sc = new Scanner(System.in);

    public void exemplo1() {
        System.out.println("Insira um Número Intereiro:");
        double numero = sc.nextDouble();

        if (numero > 10) {
            System.out.println(numero+" => É maior que 10!!!");
        } else {
            System.out.println(numero+" => Não é maior que 10!!! ");
        }
    }

    public void exemplo2() {
        System.out.println("Informe a quantidade de Horas Trabalhadas no Mês:");
        double horasMes = sc.nextDouble();

        System.out.println("Informe o Valor da Hora Trabalhada:");
        double valorHora = sc.nextDouble();

        double horaExtra = (horasMes-200);
        double valorHoraExtra = (horaExtra*1.5)*valorHora;
        double salario = valorHora*200;
        double salarioTotal = salario + valorHoraExtra;

        System.out.println("O salário Total com horas extras é de: "+salarioTotal);
    }
}
 