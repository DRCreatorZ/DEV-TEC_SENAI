package POOIntroducao;

public class App {
        public static void main(String[] args) {
        //criar 3 objetos ResgistraAluno
        RegistraAluno aluno1 = new RegistraAluno();
        RegistraAluno aluno2 = new RegistraAluno();
        RegistraAluno aluno3 = new RegistraAluno();
        //set do nomne usando o setName()
        //aluno1
        aluno1.setNome("Ana Machado");
        aluno1.setEndereco("Rua 1, nº1");
        aluno1.setIdade(20);
        aluno1.setNotaCiencias(10);
        aluno1.setNotaMatematica(9);
        aluno1.setNotaPortugues(8);
        //aluno2
        aluno2.setNome("Roberto da Silva");
        aluno2.setEndereco("Rua 2, nº2");
        aluno2.setIdade(25);
        aluno2.setNotaCiencias(8);
        aluno2.setNotaMatematica(7);
        aluno2.setNotaPortugues(9);
        //aluno3
        aluno3.setNome("Carlos Alberto");
        aluno3.setEndereco("Rua 3, nº3");
        aluno3.setIdade(30);
        aluno3.setNotaCiencias(7);
        aluno3.setNotaMatematica(8);
        aluno3.setNotaPortugues(10);

        //imprime usando o método getNome()
        //aluno1
        System.out.println("Nome : "+aluno1.getNome());
        System.out.println("Endereço : "+aluno1.getEndereco());
        System.out.println("Idade : "+aluno1.getIdade());
        System.out.println("Média : "+aluno1.getMedia());
        System.out.println("Contador: "
        +RegistraAluno.getQuantidadeAlunos());
        
        //aluno2
        System.out.println("Nome : "+aluno2.getNome());
        System.out.println("Endereço : "+aluno2.getEndereco());
        System.out.println("Idade : "+aluno2.getIdade());
        System.out.println("Média : "+aluno2.getMedia());
        System.out.println("Contador: "
        +RegistraAluno.getQuantidadeAlunos());

        //aluno3
        System.out.println("Nome : "+aluno3.getNome());
        System.out.println("Endereço : "+aluno3.getEndereco());
        System.out.println("Idade : "+aluno3.getIdade());
        System.out.println("Média : "+aluno3.getMedia());
        System.out.println("Contador: "
        +RegistraAluno.getQuantidadeAlunos());
        }
        
}
