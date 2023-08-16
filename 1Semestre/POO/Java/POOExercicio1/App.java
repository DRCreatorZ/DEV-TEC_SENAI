package POOExercicio1;

public class App {
    public static void main(String[] args) {

        Cadastro pessoa1 = new Cadastro("Zé Ruela", 01, 01, 2000, 1.85);
        pessoa1.imprimirInfo();
        pessoa1.CalcIdade();

        // Atribuicao de valores via set
        // pessoa1.setNome("Zé Ruela");
        // pessoa1.setAltura(1.80);
        // pessoa1.setdNascimento(01);
        // pessoa1.setmNascimento(01);
        // pessoa1.setaNascimento(2000);
        // pessoa1.imprimirInfo();
        // pessoa1.CalcIdade();
    }
}
