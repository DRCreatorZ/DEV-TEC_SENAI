package Exception;

import javax.swing.JOptionPane;

public class ExemploThrow {
    public static void main(String[] args) {
        // digitação de senhas
        boolean testesenha = true;
        while (testesenha) {
            String nomeUsuario = JOptionPane.showInputDialog("Informe um nome de Usuário");
            String dataNascimento = JOptionPane.showInputDialog("Informe a data de Nascimento [dd/mm/aa]");
            dataNascimento = dataNascimento.replace("/", "");
            String senhaDigitada = JOptionPane.showInputDialog("Informe uma Senha de 6 Digitos");
            try {
                if (senhaDigitada.length() != 6) {
                    throw new Exception("Senha Inválida!");
                }
                if (nomeUsuario.equals(senhaDigitada)) {
                    throw new Exception("Senha Inválida! A senha deve ser diferente do Usuário!");
                }
                if (dataNascimento.equals(senhaDigitada)) {
                    throw new Exception("Senha Inválida! A senha deve ser diferente da Data de Nascimento!");
                }
                testesenha = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
