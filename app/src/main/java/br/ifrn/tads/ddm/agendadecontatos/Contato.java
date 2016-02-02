package br.ifrn.tads.ddm.agendadecontatos;

/**
 * Created by duartemac on 2016-01-23.
 */
public class Contato {
    private String nome;
    private String fone;

    public Contato ( String nome, String fone ) {
        this.nome = nome;
        this.fone = fone;
    }

    public String getNome() {
        return nome;
    }

    public String getFone() {
        return fone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.fone;
    }
}
