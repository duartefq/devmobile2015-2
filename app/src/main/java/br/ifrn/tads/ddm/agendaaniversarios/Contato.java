package br.ifrn.tads.ddm.agendaaniversarios;

/**
 * Created by duartemac on 2016-01-23.
 */
public class Contato {
    private String nome;
    private String aniversario;

    public Contato ( String nome, String aniversario ) {
        this.nome = nome;
        this.aniversario = aniversario;
    }

    public String getNome() {
        return nome;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.aniversario;
    }
}
