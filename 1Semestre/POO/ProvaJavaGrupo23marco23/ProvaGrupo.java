package ProvaJavaGrupo23marco23;

import java.util.Scanner;

public class ProvaGrupo {
    Scanner sc = new Scanner(System.in);

    public void exercicio() {
        System.out.println("Informe o Nome do Usuário:");
        String nome = sc.nextLine();
       
        System.out.println("Informe a Idade do Usuário:");
        int idade = sc.nextInt();

        while (idade<16) {
            System.out.println("Permitido apenas para maiores de 16 anos");
            System.out.println("Informe a Idade do Usuário:");
            sc.nextInt(idade);
            if (idade<15) {
                System.out.println("Informe a Idade do Usuário:");
            idade=sc.nextInt();
            }else {
                break;
            }
        }
        System.out.println("Informe o Sexo do Usuário: (1 - Masculino)|(2 - Feminino):");
        int sexo = sc.nextInt();
        System.out.println("Informe a Altura (metros) do Usuário:");
        double altura = sc.nextDouble();
        System.out.println("Informe o Peso do Usuário:");
        double peso = sc.nextDouble();

        double pesoIdealHomem = (72.7 * altura) - 58;
        double pesoIdealMulher = (62.1 * altura) - 44.7;
        double diferencaPesoH = pesoIdealHomem - peso;
        double diferencaPesoM = pesoIdealMulher - peso;
        double imc = peso/(altura*altura);

        if (sexo == 1  && diferencaPesoH<peso) {
            System.out.println(nome+ " Seu peso ideal é: " + pesoIdealHomem + " Kg.");
        } else {
            System.out.println(nome+" Seu peso ideal é: " + pesoIdealMulher + " Kg.");
        }

        if (sexo == 1 && pesoIdealHomem < peso) {
            System.out.println("\n Você precisa perder " + diferencaPesoH +" Kg.");
        } else if (sexo == 1 && pesoIdealHomem > peso) {
            System.out.println("\n Você precisa ganhar " + diferencaPesoH + " Kg.");
        } else if (sexo == 2 && pesoIdealMulher < peso) {
            System.out.println("\n Você precisa perder " + diferencaPesoM+ " Kg.");
        } else if (sexo == 2 && pesoIdealMulher > peso) {
            System.out.println("\n Você precisa ganhar " + diferencaPesoM+ " Kg.");
        }

        int imcfe = 0;
        System.out.println(nome + ", seu IMC é " + imc);
        if (imc < 20) {
            imcfe = 1; // abaixo do peso
            System.out.println(nome + ", está abaixo do peso. Sugestão é para ganhar massa muscular");
        } else if (imc > 20 && imc < 27) {
            imcfe = 2; // peso normal
            System.out.println(nome + ", está no peso normal. Sugestão é de atividade moderada");
        } else if (imc > 27) {
            imcfe = 3; // acima do peso
            System.out.println(nome + ", está acima do peso. Sugestão é de atividade leve para perder peso");
        } else {
            System.out.println(" Valor inválido");
        }
        int idadefe = 0;
        if (idade > 16 && idade <= 25) {
            idadefe = 1;

        } else if (idade > 25 && idade <= 35) {
            idadefe = 2;

        } else if (idade > 36 && idade <= 45) {
            idadefe = 3;
        } else if (idade > 46 && idade <= 55) {
            idadefe = 4;
        } else if (idade > 56 && idade <= 65) {
            idadefe = 5;
        } else if (idade > 66) {
            idadefe = 6;
        } else {
            System.out.println("Valor inválido");
        }

        // Relação de atividades com peso e idade
        if (imcfe == 1 && (idadefe == 1 || idadefe == 2 || idadefe == 3 || idadefe == 4)) {
            System.out.println(nome + ", pode fazer Luta");
        }
        if (imcfe == 1 && (idadefe == 2 || idadefe == 3)) {
            System.out.println(nome + ", pode fazer Musculação Intensa");
        }
        if (imcfe == 1 && (idadefe == 4 || idadefe == 5 || idadefe == 6)) {
            System.out.println(nome + ", pode fazer Pilates");
        }
        if (imcfe == 2 && (idadefe == 1 || idadefe == 2 || idadefe == 3 || idadefe == 4)) {
            System.out.println(nome + ", pode fazer Musculação Moderada");
        }
        if (imcfe == 2 && (idadefe == 2 || idadefe == 3 || idadefe == 4 || idadefe == 5)) {
            System.out.println(nome + ", pode fazer Corrida");
        }

        if (imcfe == 2) {
            System.out.println(nome + ", pode fazer Corrida");
        }

        if (imcfe == 3 && (idadefe == 1 || idadefe == 4 || idadefe == 5 || idadefe == 6)) {
            System.out.println(nome + ", pode fazer Musculação Leve");
        }
        if (imcfe == 3) {
            System.out.println(nome + ", pode fazer Ioga");
        }
    }
}