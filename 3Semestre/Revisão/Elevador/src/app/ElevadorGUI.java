import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Elevador {
    private int andarAtual;

    public Elevador() {
        andarAtual = 1;
    }

    public void moverParaAndar(int andarDestino) {
        if (andarDestino < 1 || andarDestino > 9) {
            JOptionPane.showMessageDialog(null, "Andar inválido. Escolha um andar entre 1 e 9.");
            return;
        }

        if (andarDestino == andarAtual) {
            JOptionPane.showMessageDialog(null, "O elevador já está no andar desejado.");
            return;
        }

        JOptionPane.showMessageDialog(null, "Movendo o elevador do andar " + andarAtual + " para o andar " + andarDestino + ".");
        andarAtual = andarDestino;
        JOptionPane.showMessageDialog(null, "O elevador chegou ao andar " + andarAtual + ".");
    }

    public int getAndarAtual() {
        return andarAtual;
    }
}

public class ElevadorGUI {
    private JFrame frame;
    private Elevador elevador;
    private JComboBox<String> andarComboBox;

    public ElevadorGUI() {
        frame = new JFrame("Elevador");
        elevador = new Elevador();

        andarComboBox = new JComboBox<>();
        for (int i = 1; i <= 9; i++) {
            andarComboBox.addItem("Andar " + i);
        }

        JButton moverButton = new JButton("Mover");
        moverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedAndar = (String) andarComboBox.getSelectedItem();
                int andar = Integer.parseInt(selectedAndar.substring(selectedAndar.lastIndexOf(" ") + 1));
                elevador.moverParaAndar(andar);
                atualizarLabel();
            }
        });

        JPanel panel = new JPanel();
        panel.add(andarComboBox);
        panel.add(moverButton);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);

        atualizarLabel();

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void atualizarLabel() {
        JOptionPane.showMessageDialog(null, "O elevador está atualmente no andar " + elevador.getAndarAtual() + ".");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ElevadorGUI();
            }
        });
    }
}
