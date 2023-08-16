package POOExercicio3;

import javax.swing.JOptionPane;

public class Elevador {
    //atributos
    int capacidadeMax;
    int nMaxAndar;
    int andarAtual;
    int capacidadeAtual;
    //metodos - constructor
    public Elevador(int capacidadeMax, int nMaxAndar) {
        this.capacidadeMax = capacidadeMax;
        this.nMaxAndar = nMaxAndar;
    }
    //get and set
    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public int getCapacidadeAtual() {
        return capacidadeAtual;
    }

    public void setCapacidadeAtual(int capacidadeAtual) {
        this.capacidadeAtual = capacidadeAtual;
    }
    //metodos adicionais (funcionalidade do elevador)
    //entrar
    public int entrar(){
        if (capacidadeAtual<capacidadeMax){
            capacidadeAtual++;
        }else{
            JOptionPane.showMessageDialog(null, "Capacidade Máx Atingida!!!\n Não vai subir ninguém!!!");
        }
        return capacidadeAtual;
    }
    //sair
    public int sair(){
        if (capacidadeAtual>0){
            capacidadeAtual--;
        }else{
            JOptionPane.showMessageDialog(null, "Não tem  ninguém para sair.");
        }
        return capacidadeAtual;
    }
    //subir e descer 
    public int acao(int nAndares){
        if (andarAtual<=nMaxAndar && nAndares>=0 && nAndares!=andarAtual) {
            andarAtual=nAndares;
        } else{
            JOptionPane.showMessageDialog(null, "Digite um andar válido.");
        }
        return andarAtual;
    }
    //iniciar
    public void iniciar(){
        andarAtual=0;
        capacidadeAtual=0;
    }
}
