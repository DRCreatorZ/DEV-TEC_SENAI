package POOInterface;

public class Trapezio implements FiguraGeometrica {
    int baseMaior;
    int baseMenor;
    int altura;
    int ladoA;
    int ladoB;

    // construtor
    public Trapezio(int baseMaior, int baseMenor, int altura, int ladoA, int ladoB) {
        this.baseMaior = baseMaior;
        this.baseMenor = baseMenor;
        this.altura = altura;
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    // getters and setters
    public int getLadoA() {
        return ladoA;
    }

    public void setLadoA(int ladoA) {
        this.ladoA = ladoA;
    }

    public int getLadoB() {
        return ladoB;
    }

    public void setLadoB(int ladoB) {
        this.ladoB = ladoB;
    }

    public int getBaseMaior() {
        return baseMaior;
    }

    public void setBaseMaior(int baseMaior) {
        this.baseMaior = baseMaior;
    }

    public int getBaseMenor() {
        return baseMenor;
    }

    public void setBaseMenor(int baseMenor) {
        this.baseMenor = baseMenor;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    // metodos 'implements' da classe "FiguraGeometrica"
    @Override
    public double getArea() {
        return (baseMaior + baseMenor) * altura / 2;
    }

    @Override
    public String getNomeFigura() {
        return "Trapézio";
    }

    @Override
    public double getPerimetro() {
        return ladoA + ladoB + baseMaior + baseMenor;
    }
}
