import javax.swing.JFrame;

    public class Jframe extends JFrame{
    public Jframe() {
        super("Calculadoras");
        this.add(new Jtabbedpane());
        //set frame
        this.setBounds(500, 100, 300, 200);
        this.setVisible(true);
        this.setResizable(false);
    }
}