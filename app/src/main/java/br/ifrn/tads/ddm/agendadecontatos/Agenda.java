package br.ifrn.tads.ddm.agendadecontatos;

import java.util.ArrayList;

/**
 * Created by duartemac on 2016-01-23.
 */

public class Agenda extends ArrayList<Contato> {

    private static final long serialVersionUID = 1L;


    public void inserir(String nome, String fone) {

        this.add(new Contato(nome, fone));
    }

    public boolean editar(String nome, String fone) {
        for ( Contato c :this ) {
            if (c.getNome().equals(nome)) {
                c.setFone(fone);
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
