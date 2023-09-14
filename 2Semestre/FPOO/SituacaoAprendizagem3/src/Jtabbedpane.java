import javax.swing.JTabbedPane;

public class Jtabbedpane extends JTabbedPane{
    public Jtabbedpane() {
        super();
       this.add("Calculadora",new Calculadora());
       this.add("Calculadora Custo Viagem",new CalculadoraCustoViagem());
       this.add("Calculadora IMC",new CalculadoraPesoIdeal());
    }
}