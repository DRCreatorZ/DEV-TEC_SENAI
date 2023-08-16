package Colecoes;

import java.util.*;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        // Cadastrar Novo Carro
        // Listar Carros cadastrados
        // Consultar Carro
        // Excliuir Carro da Minha List
        HashMap<String, Carros> placaCarro = new HashMap<>();
        List<Carros> listaCarros = new ArrayList<>();
        JOptionPane.showMessageDialog(null, "     >>> DRC - CARROS <<<\n\n        SEJA BEM VINDO");
        boolean aberto = true;

        while (aberto) {
            int acao = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "          >>> DRC - CARROS <<<\n 1-Cadastrar Carro\n 2-Listar Carros\n 3-Consultar Carro\n 4-Excluir Carro\n 5-Sair"));
            if (acao == 1) {// Cadastrar Novo Carro
                String marcaCar = JOptionPane.showInputDialog("Insira a Marca do Carro");
                String modeloCar = JOptionPane.showInputDialog("Insira o Modelo do Carro");
                String anoCar = JOptionPane.showInputDialog("Insira o Ano do Carro");
                String corCar = JOptionPane.showInputDialog("Insira a Cor do Carro");
                String placaCar = JOptionPane.showInputDialog("Insira a Placa do Carro");
                Carros car = new Carros(marcaCar, modeloCar, anoCar, corCar, placaCar);
                placaCarro.put(placaCar, car);
                listaCarros.add(car);
            } else if (acao == 2) {
                String consulta = "";
                int i = 0;
                for (Carros a : listaCarros) { // Listar Carros cadastrados
                    consulta += i + 1 + " - " + a.imprimirLN();
                    i++;
                }
                JOptionPane.showMessageDialog(null, "     >>> DRC - CARROS <<<\nLista de Carros\n" + consulta);
            } else if (acao == 3) {
                String placa = JOptionPane.showInputDialog("Insira a Placa do Carro");
                if (placaCarro.containsKey(placa)) {
                    JOptionPane.showMessageDialog(null,
                            "     >>> DRC - CARROS <<<\n" + placaCarro.get(placa).imprimirLN());
                } else {
                    JOptionPane.showMessageDialog(null, "     >>> DRC - CARROS <<<\nPlaca não cadastrada");
                }

            } else if (acao == 4) {
                String consulta = "";
                int i = 0;
                for (Carros a : listaCarros) { // Listar Carros cadastrados
                    consulta += i + 1 + " - " + a.imprimirLN();
                    i++;
                }
                int ex = Integer.parseInt(JOptionPane.showInputDialog(
                        "Escolah o Carro Para Excluir:\n" + consulta));
                listaCarros.get(ex).imprimirLN();
                listaCarros.remove(ex);
            } else if (acao == 5) {
                JOptionPane.showMessageDialog(null,
                        "     >>> DRC - CARROS <<<\n           *******************\n   ORIGADO PELA VISITA\n\n       >>>ATÉ MAIS!!!<<<");
                aberto = false;
            } else {
                JOptionPane.showMessageDialog(null, "     >>> DRC - CARROS <<<\nOpção Inválida!");
            }
        }
    }
}
