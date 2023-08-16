package EstruturaDecisaoSwitch;

import java.util.Scanner;

public class switchCase {
    Scanner sc = new Scanner(System.in);

    public void letra() {
        System.out.println("Informe uma Letra");
        String letraDigitada = sc.nextLine();

        switch (letraDigitada) {
            case "a":
                System.out.println(letraDigitada + " É Vogal");
                break;
            case "e":
                System.out.println(letraDigitada + " É Vogal");
                break;
            case "i":
                System.out.println(letraDigitada + " É Vogal");
                break;
            case "o":
                System.out.println(letraDigitada + " É Vogal");
                break;
            case "u":
                System.out.println(letraDigitada + " É Vogal");
                break;
            default:
                System.out.println(letraDigitada + " É Consoante");
                break;
        }
    }

    public void mes() {
        System.out.println("Informe um número");
        int mes = sc.nextInt();
        String nomeMes = "";

        switch (mes) {
            case 1:
                nomeMes = "Janeiro";
                break;
            case 2:
                nomeMes = "Fevereiro";
                break;
            case 3:
                nomeMes = "Março";
                break;
            case 4:
                nomeMes = "Abril";
                break;
            case 5:
                nomeMes = "Maio";
                break;
            case 6:
                nomeMes = "Junho";
                break;
            case 7:
                nomeMes = "Julho";
                break;
            case 8:
                nomeMes = "Agosto";
                break;
            case 9:
                nomeMes = "Setembro";
                break;
            case 10:
                nomeMes = "Outubro";
                break;
            case 11:
                nomeMes = "Novembro";
                break;
            case 12:
                nomeMes = "Dezembro";
                break;
            default:
                nomeMes = "(mês inexistente) Use números de 1 a 12";
                break;
        }
        System.out.println("O mês é: " + nomeMes);
    }
}