package ProvaFinalPOO1Sem;

import javax.swing.JOptionPane;

public abstract class Conta {
    //atributos
    String nome;
    int nConta;
    double saldo;
   
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getnConta() {
        return nConta;
    }
    public void setnConta(int nConta) {
        this.nConta = nConta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    //método vazio
    public void saque() {
        double saque = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor a ser sacado:"));
        if (saldo - saque >=0){
            saldo = saldo - saque;
        }else JOptionPane.showMessageDialog(null, "Saldo Insuficiente!");
    }
    public void deposito() {
        double deposito = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor a ser depositado:"));
        saldo = saldo + deposito;
    }
    public void emprestimo() {
        double emprestimo = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor de empréstimo (limitado a 5x seu saldo):"));
        if (emprestimo <= saldo*5){
            saldo = saldo + emprestimo;
        } else JOptionPane.showMessageDialog(null," Empréstimo Negado!");
    }
}
