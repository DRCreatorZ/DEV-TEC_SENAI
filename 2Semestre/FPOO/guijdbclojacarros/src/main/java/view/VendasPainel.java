package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import connection.CarrosDAO;
import connection.ClientesDAO;
import connection.VendasDAO;
import controller.VendasControl;
import model.Carros;
import model.Clientes;
import model.Vendas;

public class VendasPainel extends JPanel {
    private JComboBox<String> carrosComboBox;
    private List<Carros> carros;
    private JComboBox<String> clientesComboBox;
    private List<Clientes> clientes;
    private JButton cadastrarButton;
    private JTable tabelaVendas;
    private DefaultTableModel modeloTabela;

    private VendasControl vendasControl;

    public VendasPainel() {
        super();
        vendasControl = new VendasControl(obterListaVendas(), modeloTabela, tabelaVendas);

        carrosComboBox = new JComboBox<>();
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.addItem("Selecione o Carro");
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca() + " / " + carro.getModelo() + " / " + carro.getPlaca());
        }
        add(carrosComboBox);

        clientesComboBox = new JComboBox<>();
        clientes = new ClientesDAO().listarTodos();
        clientesComboBox.addItem("Selecione o Cliente");
        for (Clientes cliente : clientes) {
            clientesComboBox.addItem(cliente.getNome() + " / " + cliente.getCpf());
        }
        add(clientesComboBox);

        cadastrarButton = new JButton("Realizar Venda");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCarro = (String) carrosComboBox.getSelectedItem();
                String selectedCliente = (String) clientesComboBox.getSelectedItem();

                String[] carroInfo = selectedCarro.split(" / ");
                String[] clienteInfo = selectedCliente.split(" / ");

                String valorVenda = "10000.00";
                String formaPagamento = "Cartão";
                String dataVenda = "2023-11-22";

                vendasControl.cadastrar(carroInfo[0], clienteInfo[0], valorVenda, formaPagamento, dataVenda);
                atualizarTabelaVendas();
            }
        });
        add(cadastrarButton);

        modeloTabela = new DefaultTableModel();
        tabelaVendas = new JTable(modeloTabela);

        JScrollPane scrollPane = new JScrollPane(tabelaVendas);
        add(scrollPane);

        // Adiciona cabeçalhos à tabela
        modeloTabela.addColumn("Carro");
        modeloTabela.addColumn("Cliente");
        modeloTabela.addColumn("Valor Venda");
        modeloTabela.addColumn("Forma Pagamento");
        modeloTabela.addColumn("Data Venda");

        atualizarTabelaVendas();
    }

    public void atualizarComboBox() {
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.removeAllItems();
        carrosComboBox.addItem("Selecione o Carro");
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca() + " " + carro.getModelo() + " " + carro.getPlaca());
        }

        clientes = new ClientesDAO().listarTodos();
        clientesComboBox.removeAllItems();
        clientesComboBox.addItem("Selecione o Cliente");
        for (Clientes cliente : clientes) {
            clientesComboBox.addItem(cliente.getNome() + " " + cliente.getCpf());
        }
    }

    private List<Vendas> obterListaVendas() {
        // Implementação fictícia do VendasDAO
        VendasDAO vendasDAO = new VendasDAO();
        return vendasDAO.listarTodos();
    }

    private void atualizarTabelaVendas() {
        modeloTabela.setRowCount(0);
        List<Vendas> vendas = obterListaVendas();
        for (Vendas venda : vendas) {
            modeloTabela.addRow(new Object[] { venda.getCarro(), venda.getCliente(),
                    venda.getValorVenda(), venda.getFormaPagamento(), venda.getDataVenda() });
        }
    }
}
