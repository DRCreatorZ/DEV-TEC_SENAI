package POOExercicio2;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Random rd = new Random();

            Agenda pessoas[] = new Agenda[10];
            for (int i = 0; i < pessoas.length; i++) {
                pessoas[i] = new Agenda();// construtor objeto
                //preencher os atributos do objeto
                System.out.println("Informe o nome: ");
                pessoas[i].setNome(sc.nextLine());
                pessoas[i].setIdade(rd.nextInt(18, 100));
                pessoas[i].setAltura(rd.nextFloat(160, 200) / 100);
            }

            for (int i = 0; i < pessoas.length; i++) {
                System.out.println("Nome: "+pessoas[i].getNome());
                System.out.println("Idade: "+pessoas[i].getIdade());
                System.out.println("Altura: "+pessoas[i].getAltura());
            }

            //busca de um Objeto na Agends(nome)
             String nomeBuscado = JOptionPane.showInputDialog("Informe o Nome Buscado");
             int cont = 0; //contador
             boolean procure = true;
             while (procure) {
                if (nomeBuscado.equals(pessoas[cont].getNome())) {
                    procure = false;//parar o laço
                    JOptionPane.showMessageDialog(null, "Idade: "+pessoas[cont].getIdade() + "\n Altura: "+ pessoas[cont].getAltura());
                }
                cont++;
             }
        }
    }
}