package POOExercicio1;

public class Cadastro {
    // atributos
    private String nome;
    private int dNascimento;
    private int mNascimento;
    private int aNascimento;
    private double altura;

    public Cadastro(String nome, int dNascimento, int mNascimento, int aNascimento, double altura) {
        this.nome = nome;
        this.dNascimento = dNascimento;
        this.mNascimento = mNascimento;
        this.aNascimento = aNascimento;
        this.altura = altura;
    }

    // getter/setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getdNascimento() {
        return dNascimento;
    }

    public void setdNascimento(int dNascimento) {
        this.dNascimento = dNascimento;
    }

    public int getmNascimento() {
        return mNascimento;
    }

    public void setmNascimento(int mNascimento) {
        this.mNascimento = mNascimento;
    }

    public int getaNascimento() {
        return aNascimento;
    }

    public void setaNascimento(int aNascimento) {
        this.aNascimento = aNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // metodos para 'Imprimir'/'Calcular idade'
    public void imprimirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Altura: " + altura);
        System.out.println("Nascimento: " + dNascimento + "/" + mNascimento + "/" + aNascimento);
    }

    public void CalcIdade() {
        int idade;
        if (dNascimento <= 29 && mNascimento <= 5) {
            idade = 2023 - aNascimento;
        } else {
            idade = 2023 - aNascimento - 1;

        }
        System.out.println("A idade é: " + idade);
    }

}
