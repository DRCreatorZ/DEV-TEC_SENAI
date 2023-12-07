package model;

public class Vendas {

    // atributos
    private String data;
    private String cliente;
    private String quantidade;
    private String produto;
    private String marca;
    private String codigo;
    private String valor;
    // construtor
    public Vendas(String data, String cliente, String quantidade, String produto, String marca, String codigo,
            String valor) {
        this.data = data;
        this.cliente = cliente;
        this.quantidade = quantidade;
        this.produto = produto;
        this.marca = marca;
        this.codigo = codigo;
        this.valor = valor;
    }
    //gets sets
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
    public String getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    
}