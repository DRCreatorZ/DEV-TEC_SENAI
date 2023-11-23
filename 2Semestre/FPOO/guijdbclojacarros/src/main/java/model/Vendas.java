package model;

public class Vendas {
    private String carro;
    private String Cliente;
    private String valorVenda;
    private String formaPagamento;
    private String dataVenda;

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Vendas(String carro, String Cliente, String valorVenda, String formaPagamento, String dataVenda) {
        this.carro = carro;
        this.Cliente = Cliente;
        this.valorVenda = valorVenda;
        this.formaPagamento = formaPagamento;
        this.dataVenda = dataVenda;
    }
}
