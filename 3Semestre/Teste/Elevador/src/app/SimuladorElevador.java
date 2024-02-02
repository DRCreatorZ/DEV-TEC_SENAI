package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimuladorElevador extends JFrame {
    private JButton[] botoesAndares;
    private JTextArea areaMensagens;
    private Elevador elevador1;
    private Elevador elevador2;

    public SimuladorElevador() {
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
    private class Elevador extends Thread {
        private int numero;
        private int andarAtual;
    
        public Elevador(int numero) {
            this.numero = numero;
            this.andarAtual = 0; // Modificação aqui para iniciar no térreo
            start(); // Inicia a thread do elevador
        }
    
        public int getAndarAtual() {
            return andarAtual;
        }
    
        private String obterNomeAndar(int andar) {
            switch (andar) {
                case 1:
                    return "S2";
                case 2:
                    return "S1";
                case 3:
                    return "Térreo";
                case 4:
                    return "1°";
                case 5:
                    return "2°";
                case 6:
                    return "3°";
                case 7:
                    return "4°";
                case 8:
                    return "5°";
                case 9:
                    return "6°";
                default:
                    return "Andar " + andar;
            }
        }
    
        private void limparTela() {
            // Limpa a área de mensagens
            areaMensagens.setText("");
        }
    
        public void solicitarAndar(int andar) {
            // Limpa a tela antes de exibir o movimento do elevador
            limparTela();
    
            // Verifica se o elevador já está no andar chamado
            if (andarAtual == andar) {
                areaMensagens.append("Elevador " + numero + " já está no " + obterNomeAndar(andarAtual) + "\n");
                return;
            }else{
    
            // Simula o movimento do elevador até o andar solicitado
            areaMensagens.append("Elevador " + numero + " se deslocando para o " + obterNomeAndar(andar) + "\n");
    
            // Espera um tempo para simular o deslocamento entre andares
            try {
                Thread.sleep(1000 * Math.abs(andar - andarAtual));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            // Atualiza o andar atual
            andarAtual = andar;
    
            // Exibe a mensagem de chegada ao destino
            areaMensagens.append("Elevador " + numero + " chegou ao " + obterNomeAndar(andarAtual) + "\n");
        }
    }
        @Override
        public void run() {
            // Método run da thread do elevador
            while (true) {
                // O elevador fica "ocioso" e aguarda novas solicitações
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimuladorElevador();
            }
        });
    }
}
