package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElevadorView extends JFrame {
    private JButton[] botoesAndares;
    private JTextArea areaMensagens;

    public ElevadorView() {
        // Configurações básicas da janela
        super("Simulador de Elevadores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicializa os elevadores
        elevador1 = new Elevador(1);
        elevador2 = new Elevador(2);

        // Inicializa os botões dos andares
        botoesAndares = new JButton[9];
        String[] andaresRotulos = {"S2", "S1", "Térreo", "1°", "2°", "3°", "4°", "5°", "6°"};

        for (int i = 0; i < 9; i++) {
            final int andar = i + 1;
            botoesAndares[i] = new JButton("Andar " + andaresRotulos[i]);
            botoesAndares[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    solicitarElevador(andar);
                }
            });
        }

        // Inicializa a área de mensagens
        areaMensagens = new JTextArea();
        areaMensagens.setEditable(false);

        // Adiciona os botões dos andares à janela
        JPanel painelBotoes = new JPanel(new GridLayout(3, 3));
        for (int i = 8; i >= 0; i--) {
            painelBotoes.add(botoesAndares[i]);
        }

        // Adiciona os painéis à janela
        add(painelBotoes, BorderLayout.NORTH);
        add(new JScrollPane(areaMensagens), BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
    }

    private void solicitarElevador(int andar) {
        // Decide qual elevador deve atender a solicitação com base na proximidade
        if (Math.abs(elevador1.getAndarAtual() - andar) <= Math.abs(elevador2.getAndarAtual() - andar)) {
            elevador1.solicitarAndar(andar);
        } else {
            elevador2.solicitarAndar(andar);
        }
    }
}
