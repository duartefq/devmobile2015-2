package br.ifrn.tads.ddm.agendadecontatos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BlankFragment extends Fragment {

    private Agenda agenda;
    private TextView textViewContatos;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);

        agenda = new Agenda();
        textViewContatos = (TextView) rootView.findViewById(R.id.textViewContatos);

        return rootView;
    }

    public void inserir(String nome, String fone) {
        agenda.inserir(nome, fone);
        textViewContatos.setText(agenda.toString());
    }

    public void editar(String nome, String fone) {
        agenda.editar(nome, fone);
        textViewContatos.setText(agenda.toString());
    }

    public void excluir(String nome) {
        agenda.excluir(nome);
        textViewContatos.setText(agenda.toString());
    }
}
