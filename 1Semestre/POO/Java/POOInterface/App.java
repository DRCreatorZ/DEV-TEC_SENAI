package POOInterface;

public class App {
    public static void main(String[] args) {
        Quadrado figura1 = new Quadrado(6);
        System.out.println("Figura = " + figura1.getNomeFigura() + "/ Área = " +
                figura1.getArea() + "/ Perímetro = " + figura1.getPerimetro());

        Retangulo figura2 = new Retangulo(5, 15);
        System.out.println("Figura = " + figura2.getNomeFigura() + "/ Área = " + figura2.getArea()
                + "/ Perímetro = " + figura2.getPerimetro());

        Trapezio figura3 = new Trapezio(10, 5, 10, 5, 5);
        System.out.println("Figura = " + figura3.getNomeFigura() + " / Área = " + figura3.getArea()
                + "/ Perimetro = " + figura3.getPerimetro());
    }
}
