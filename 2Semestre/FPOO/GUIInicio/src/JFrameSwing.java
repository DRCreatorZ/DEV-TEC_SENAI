import javax.swing.JFrame;

public class JFrameSwing extends JFrame {
    public JFrameSwing() {
        super("Minha Primeira janela JFrameSwing");
        this.setSize(300,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
