package model;

public class Produtos {
    // atributos
    private String quantidade;
    private String produto;
    private String marca;
    private String codigo;
    private String valor;

    // construtor
    public Produtos(String quantidade, String produto, String marca, String codigo, String valor) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.marca = marca;
        this.codigo = codigo;
        this.valor = valor;
    }

    // gets and sets
    public String getMarca() {
        return quantidade;
    }

    public void setMarca(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getModelo() {
        return produto;
    }

    public void setModelo(String produto) {
        this.produto = produto;
    }

    public String getAno() {
        return marca;
    }

    public void setAno(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return codigo;
    }

    public void setPlaca(String codigo) {
        this.codigo = codigo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
