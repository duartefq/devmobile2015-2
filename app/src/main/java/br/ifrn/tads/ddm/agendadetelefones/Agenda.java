package br.ifrn.tads.ddm.agendadetelefones;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by duartemac on 2016-02-17.
 */

public class Agenda extends ArrayList<Contato> {
    private final String Tag="Agenda";

    private static final long serialVersionUID = 1L;

    public void inserir(String nome, String fone) {
        Log.i(Tag, "inserir");

        this.add(new Contato(nome, fone));
    }

    public boolean editar(String nome, String fone) {
        Log.i(Tag, "editar");

        for ( Contato c :this ) {
            if (c.getNome().equals(nome)) {
                c.setFone(fone);
                return true;
            }
        }
        return false;
    }

    public boolean excluir(String nome ) {
        Log.i(Tag, "excluir");

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
