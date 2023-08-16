package POOHeranca;

public class Professor extends Pessoas {
    private int aulasMes;
    private String disciplina;

    public int getAulasMes() {
        return aulasMes;
    }

    public void setAulasMes(int aulasMes) {
        this.aulasMes = aulasMes;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

}
