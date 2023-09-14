import javax.swing.JFrame;

    public class Jframe extends JFrame{
    public Jframe() {
        super("Calculadoras");
        this.add(new Jtabbedpane());
        //set frame
        this.setBounds(500, 500, 420, 260);
        this.setVisible(true);
        this.setResizable(false);
    }
}