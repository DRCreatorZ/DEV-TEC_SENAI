package model;

public class Vendas {

    // atributos
    private String data;
    private String cliente;
    private String valor;
    private String tipoProduto;
    
    // construtor
    public Vendas(String data, String cliente, String valor, String tipoProduto) {
        this.data = data;
        this.cliente = cliente;
        this.valor = valor;
        this.tipoProduto = tipoProduto;
    }

    // getters and setters
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

}
