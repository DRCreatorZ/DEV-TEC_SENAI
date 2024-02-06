package model;

public class ElevadorModel extends Thread {
    private int numero;
    private int andarAtual;

    public ElevadorModel(int numero) {
        this.numero = numero;
        this.andarAtual = 0;
        start();
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
        // areaMensagens.setText("");
    }

    public void solicitarAndar(int andar) {
        // Limpa a tela antes de exibir o movimento do elevador
        limparTela();

        // Verifica se o elevador já está no andar chamado
        if (andarAtual == andar) {
            // areaMensagens.append("Elevador " + numero + " já está no " + obterNomeAndar(andarAtual) + "\n");
            return;
        } else {

            // Simula o movimento do elevador até o andar solicitado
            // areaMensagens.append("Elevador " + numero + " se deslocando para o " + obterNomeAndar(andar) + "\n");

            // Espera um tempo para simular o deslocamento entre andares
            try {
                // Thread.sleep(1000 * Math.abs(andar - andarAtual));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Atualiza o andar atual
            andarAtual = andar;

            // Exibe a mensagem de chegada ao destino
            // areaMensagens.append("Elevador " + numero + " chegou ao " + obterNomeAndar(andarAtual) + "\n");
        }
    }

    @Override
    public void run() {
        // Método run da thread do elevador
        while (true) {
            // O elevador fica "ocioso" e aguarda novas solicitações
            try {
                // Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
