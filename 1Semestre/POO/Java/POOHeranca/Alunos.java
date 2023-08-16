package POOHeranca;

public class Alunos extends Pessoas {
    //atributos especificos
    private int matriciula;
    private double mediaSemestre;
    private String curso;
    private String turma;

    //metodos especificos
    public int getMatriciula() {
        return matriciula;
    }
    public void setMatriciula(int matriciula) {
        this.matriciula = matriciula;
    }
    public double getMediaSemestre() {
        return mediaSemestre;
    }
    public void setMediaSemestre(double mediaSemestre) {
        this.mediaSemestre = mediaSemestre;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getTurma() {
        return turma;
    }
    public void setTurma(String turma) {
        this.turma = turma;
    }

    
}
