package br.ifrn.tads.ddm.agendadecontatos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FormFragment.OnButtonClicked {

    private final int ACTION_INSERIR = 0;
    private final int ACTION_EDITAR = 1;
    private final int ACTION_EXCLUIR = 2;

    private BlankFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFragment = (BlankFragment)
                getSupportFragmentManager().findFragmentById(R.id.contato_fragment);
    }

    @Override
    public void sendAction(int action, String nome, String fone) {

        switch (action) {
            case ACTION_INSERIR:
                myFragment.inserir( nome, fone );
                break;
            case ACTION_EDITAR:
                myFragment.editar(nome, fone);
                break;
            case ACTION_EXCLUIR:
                myFragment.excluir(nome);
                break;
        }
    }

}
