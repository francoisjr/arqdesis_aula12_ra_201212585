package entity;

import java.io.Serializable;

/**
 * Created by François on 9/1/2015.
 */
public class Voo implements  Serializable{

    private String origem;
    private String destino;
    private String data;
    private String hora;

    public Voo(String origem, String destino, String hora, String data) {
        this.origem = origem;
        this.destino = destino;
        this.hora = hora;
        this.data = data;
    }

    public Voo() {
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Voo{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }

}
