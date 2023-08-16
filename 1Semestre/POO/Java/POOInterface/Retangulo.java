package POOInterface;

public class Retangulo implements FiguraGeometrica {
    int base;
    int altura;

    public int getBase() {
        return base;
    }
    public void setBase(int base) {
        this.base = base;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public Retangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }
    @Override
    public double getArea() {
        int area = base * altura;
        return area;
    }
    @Override
    public String getNomeFigura() {
        return "Retângulo";
    }
    @Override
    public double getPerimetro() {
        int perimetro = 0;
        perimetro = base * 2+ altura*2;
        return perimetro;
    }
    
}
