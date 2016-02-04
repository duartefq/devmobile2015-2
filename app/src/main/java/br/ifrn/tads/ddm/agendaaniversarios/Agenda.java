package br.ifrn.tads.ddm.agendaaniversarios;

import java.util.ArrayList;
import java.util.Date;


public class Agenda extends ArrayList<Contato> {

    private static final long serialVersionUID = 1L;


    public void inserir(String nome, String aniversario) {

        this.add(new Contato(nome, aniversario));
    }

    public boolean editar(String nome, String aniversario) {
        for ( Contato c :this ) {
            if (c.getNome().equals(nome)) {
                c.setAniversario(aniversario);
                return true;
            }
        }
        return false;
    }

    public boolean excluir(String nome ) {
        for ( Contato c :this ) {
            if (c.getNome().equals(nome)) {
                this.remove(c);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String result ="";

        for ( Contato c : this ) {
            result += c.toString() + "\n";
        }

        return result;
    }
}
