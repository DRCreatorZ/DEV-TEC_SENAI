package RevisaoFPOO;

import javax.swing.JOptionPane;

import RevisaoFPOO.Horario.AgendaConsulta;
import RevisaoFPOO.Cadastro.Animal;
import RevisaoFPOO.Cadastro.Cachorro;
import RevisaoFPOO.Cadastro.Gato;
import RevisaoFPOO.Cadastro.OutrosAnimais;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        // cria o cadastro(armaze nar no vetor)
        Gato gatos[] = new Gato[10];
        Cachorro cachorros[] = new Cachorro[10];
        OutrosAnimais outros[] = new OutrosAnimais[10];
        AgendaConsulta agendas[] = new AgendaConsulta[100];// armazernar as consultas(obj)
        // contadores -
        int contGatos = 0, contCachorros = 0, contOutros = 0, contAgenda = 0;

        // criar a minha aplicação
        JOptionPane.showMessageDialog(null, "Bem-Vindo ao Consultório\n do Dr. Frankstein");
        boolean aberto = true;
        while (aberto) {
            int acao1 = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro\n 2-Consulta\n 3-Sair"));
            if (acao1 == 1) {// cadastro
                int acao2 = Integer.parseInt(JOptionPane.showInputDialog("1-Gato\n 2-Cachorro\n 3-Outro Animal"));
                if (acao2 == 1) {// cadastro dos gato
                    // criar um objeto
                    gatos[contGatos] = new Gato();// utilizei o construtor
                    // setar os valores do cadastro
                    gatos[contGatos].setNome(JOptionPane.showInputDialog("Informe o Nome do PET"));
                    gatos[contGatos].setRaca(JOptionPane.showInputDialog("Informe a Raça do PET"));
                    gatos[contGatos].setProprietario(JOptionPane.showInputDialog("Informe o Nome do Proprietario"));
                    gatos[contGatos].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do PET")));
                    // contador +1
                    contGatos++;
                } else if (acao2 == 2) {// cadastro do cachorro
                    // criar um objeto
                    gatos[contGatos] = new Gato();// utilizei o construtor
                    // setar os valores do cadastro
                    gatos[contGatos].setNome(JOptionPane.showInputDialog("Informe o Nome do PET"));
                    gatos[contGatos].setRaca(JOptionPane.showInputDialog("Informe a Raça do PET"));
                    gatos[contGatos].setProprietario(JOptionPane.showInputDialog("Informe o Nome do Proprietario"));
                    gatos[contGatos].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do PET")));
                    // contador +1
                    contGatos++;
                } else if (acao2 == 3) {// Cadastro de outros Tipos de PET
                    // criar um objeto
                    cachorros[contCachorros] = new Cachorro();// utilizei o construtor
                    // setar os valores do cadastro
                    cachorros[contCachorros].setNome(JOptionPane.showInputDialog("Informe o Nome do PET"));
                    cachorros[contCachorros].setRaca(JOptionPane.showInputDialog("Informe a Raça do PET"));
                    cachorros[contCachorros]
                            .setProprietario(JOptionPane.showInputDialog("Informe o Nome do Proprietario"));
                    cachorros[contCachorros]
                            .setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do PET")));
                    // contador +1
                    contCachorros++;
                }
            } else if (acao1 == 2) {// agendar consulta
                // 1º verificação - cadastro do nome
                boolean cadastroOK = false;
                String nomeAgenda = JOptionPane.showInputDialog("Informe o Nome do PET");
                for (int i = 0; i < contGatos; i++) {// busca no vetor de gatos
                    if (gatos[i].getNome().equals(nomeAgenda)) {
                        // mensagem de confirmação
                        JOptionPane.showMessageDialog(null, "Pet Encontrado");
                        cadastroOK = true;
                        break;
                    }
                }
                for (int i = 0; i < contCachorros; i++) {// busca no vetor de gatos
                    if (cachorros[i].getNome().equals(nomeAgenda)) {
                        // mensagem de confirmação
                        JOptionPane.showMessageDialog(null, "Pet Encontrado");
                        cadastroOK = true;
                        break;
                    }
                }
                for (int i = 0; i < contOutros; i++) {// busca no vetor de gatos
                    if (outros[i].getNome().equals(nomeAgenda)) {
                        // mensagem de confirmação
                        JOptionPane.showMessageDialog(null, "Pet Encontrado");
                        cadastroOK = true;
                        break;
                    }
                }
                // 2º Terminar o Cadastro
                if (cadastroOK) {
                    boolean agendar = true;
                    while (agendar) {
                        String dataAgenda = JOptionPane.showInputDialog("Informe a Data do Agendamento");
                        String horaAgenda = JOptionPane.showInputDialog("Informe a Hora do Agendamento");
                        if (contAgenda == 0) {
                            // agendas[contAgenda] = new Agenda();
                            agendas[contAgenda].setData(dataAgenda);
                            agendas[contAgenda].setHora(horaAgenda);
                            agendar = false;
                        } else {
                            for (int i = 0; i < contAgenda; i++) {
                                if (agendas[i].getDataHora().equals(dataAgenda + horaAgenda)) {
                                    // não pode agendar
                                    break;
                                } else {
                                    // agendas[contAgenda] = new Agenda();
                                    agendas[contAgenda].setData(dataAgenda);
                                    agendas[contAgenda].setHora(horaAgenda);
                                    agendar = false;
                                }
                            }
                        }

                    }
                }

            }
        }

    }
}