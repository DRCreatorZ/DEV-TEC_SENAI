package POOHeranca;

public class Funcionarios extends Pessoas {
    private int salario;
    private String setor;
    private int nRegistro;
    
    public int getSalario() {
        return salario;
    }
    public void setSalario(int salario) {
        this.salario = salario;
    }
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }
    public int getnRegistro() {
        return nRegistro;
    }
    public void setnRegistro(int nRegistro) {
        this.nRegistro = nRegistro;
    }

    
}
