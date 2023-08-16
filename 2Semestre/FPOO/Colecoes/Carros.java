package Colecoes;

public class Carros {
    // atributos (Marca, Modelo, Ano, Cor)
    String marca;
    String modelo;
    String ano;
    String cor;
    String placa;

    // metodos
    // contrutor cheio
    public Carros(String marca, String modelo, String ano, String cor, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
    }

    // Construtor vazio
    public Carros() {
    }

    // getters and setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // metodo próprio
    public String imprimirLN() {
        String imprimir = this.marca + " / " + this.modelo + " / " + this.ano + " / " + this.cor + " / " + this.placa
                + "\n";
        return imprimir;
    }
}