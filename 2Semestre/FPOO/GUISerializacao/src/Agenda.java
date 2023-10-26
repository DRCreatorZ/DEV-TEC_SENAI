import java.io.Serializable;

public class Agenda implements Serializable{
    //atributos
    private String data;
    private String hora;
    private String usuario;
    private String descricao;
    //métodos
    public Agenda(String data, String hora, String usuario, String descricao) {
        this.data = data;
        this.hora = hora;
        this.usuario = usuario;
        this.descricao = descricao;
    }
    public String getData() {
        return data;
    }
    public String getHora() {
        return hora;
    }
    public String getUsuario() {
        return usuario;
    }
    public String getDescricao() {
        return descricao;
    }
    

}
