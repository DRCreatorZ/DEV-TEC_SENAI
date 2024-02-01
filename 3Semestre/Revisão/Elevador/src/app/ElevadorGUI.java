import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Elevador {
    private int andarAtual;

    public Elevador() {
        andarAtual = 1;
    }

    public void moverParaAndar(int andarDestino, List<Elevador> elevadores) {
        if (andarDestino < 1 || andarDestino > 9) {
            JOptionPane.showMessageDialog(null, "Andar inválido. Escolha um andar entre 1 e 9.");
            return;
        }

        int elevadoresNoAndar = 0;
        for (Elevador elevador : elevadores) {
            if (elevador.getAndarAtual() == andarDestino) {
                elevadoresNoAndar++;
            }
        }

        if (elevadoresNoAndar >= 2) {
            JOptionPane.showMessageDialog(null, "Há dois elevadores no andar " + andarDestino + ". Espere um momento.");
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
    private List<Elevador> elevadores;
    private JComboBox<String> andarComboBox;

    public ElevadorGUI() {
        frame = new JFrame("Elevador");
        elevadores = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            elevadores.add(new Elevador());
        }

        andarComboBox = new JComboBox<>();
        for (int i = 1; i <= 9; i++) {
            andarComboBox.addItem("Andar " + i);
        }

        JButton moverButton = new JButton("Mover");
        moverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedAndar = (String) andarComboBox.getSelectedItem();
                int andar = Integer.parseInt(selectedAndar.substring(selectedAndar.lastIndexOf(" ") + 1));
                elevadores.get(0).moverParaAndar(andar, elevadores);
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
        JOptionPane.showMessageDialog(null, "O elevador está atualmente no andar " + elevadores.get(0).getAndarAtual() + ".");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ElevadorGUI();
            }
        });
    }
}
