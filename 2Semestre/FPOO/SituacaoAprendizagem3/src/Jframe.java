import javax.swing.JFrame;

    public class Jframe extends JFrame{
    public Jframe() {
        super("Calculadoras");
        this.add(new Jtabbedpane());
        //set frame
        this.setBounds(500, 500, 370, 230);
        this.setVisible(true);
        //this.setResizable(false);
    }
}