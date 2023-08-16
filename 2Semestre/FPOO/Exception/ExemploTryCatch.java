package Exception;

import javax.swing.JOptionPane;

public class ExemploTryCatch {
    public static void main(String[] args) {

        int operacao = Integer.parseInt(JOptionPane.showInputDialog("Digite a Operação Desejada:" + " \n1 - Soma"
                + "\n2 - Subtração" + "\n3 - Multiplicação" + "\n4 - Divisão"));
            boolean rodando = true;
            while (rodando) {
                try {
                    int numero1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um Nº Inteiro"));
                    int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro Nº Inteiro"));
                    if (operacao==1) {
                        JOptionPane.showMessageDialog(null, "O resultado é "
                            + (numero1 + numero2));
                    rodando = false;
                    }else if (operacao==2) {
                        JOptionPane.showMessageDialog(null, "O resultado é "
                            + (numero1 - numero2));
                            rodando = false;
                    }else if (operacao==3) {
                        JOptionPane.showMessageDialog(null, "O resultado é "
                            + (numero1 * numero2));
                            rodando = false;
                    }else if (operacao==4) {
                        JOptionPane.showMessageDialog(null, "O resultado é "
                            + (numero1 / numero2));
                            rodando = false;
                    }
                    
                } catch (NumberFormatException erro1) {
                    JOptionPane.showMessageDialog(null, "Erro - Valor digitado não é um inteiro"
                            + "\nDigite novamente");
                } catch (Exception erro2) {
                    JOptionPane.showMessageDialog(null, "Aconteceu um erro"
                            + "\nDigite novamente");
                }
            }
        }
    }

