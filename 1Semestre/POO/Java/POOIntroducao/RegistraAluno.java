package POOIntroducao;

public class RegistraAluno {
    // declaração dos atributos do objeto
    private String nome;
    private String endereco;
    private int idade;
    private double notaMatematica;
    private double notaPortugues;
    private double notaCiencias;

    // atributo da classe
    private static int contadorEstudante;

    // criação de metodos de acesso _GET
    
    // retorna o nome do estudante
    protected String getNome() {
        return nome;
    }

    // retorna o endereço do estudante
    protected String getEndereco() {
        return endereco;
    }

    // retorna idade do estudante
    protected int getIdade() {
        return idade;
    }

    // retorna a média do estudante
    protected double getMedia() {
        double resultado = 0;
        resultado = (notaMatematica
                + notaPortugues
                + notaCiencias) / 3;

        return resultado;
    }

    // retorna a quantidade de estudantes cadastrados
    public static int getQuantidadeAlunos() {
        return contadorEstudante;
    }

    // métodos de definição - SET

    // define ou altera o nome do estudante
    public void setNome(String temp) {
        nome = temp;
    }

    // define ou altera o endereço do estudante
    public void setEndereco(String temp) {
        endereco = temp;
    }

    // define ou altera o endereço do estudante
    protected void setIdade(int temp) {
        idade = temp;
    }

    // define ou altera o endereço do estudante
    protected void setNotaMatematica(double temp) {
        notaMatematica = temp;
    }

    // define ou altera o endereço do estudante
    public void setNotaPortugues(double temp) {
        notaPortugues = temp;
    }

    // define ou altera o endereço do estudante
    public void setNotaCiencias(double temp) {
        notaCiencias = temp;
    }
}