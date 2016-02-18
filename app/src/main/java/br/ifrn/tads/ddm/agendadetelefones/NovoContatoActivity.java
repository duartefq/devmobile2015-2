package br.ifrn.tads.ddm.agendadetelefones;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NovoContatoActivity extends AppCompatActivity {

    private Button btnInserir;
    private Button btnCancel;
    private EditText editNome;
    private EditText editFone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_contato);

        btnInserir = (Button) findViewById(R.id.buttonInserir);
        btnCancel = (Button) findViewById(R.id.buttonCancelar);

        editNome = (EditText) findViewById(R.id.editTextNome);
        editFone = (EditText) findViewById(R.id.editTextTelefone);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

      public void buttonClick(View v) {

          if (btnInserir == v) {
              Intent ret = new Intent();
              String nome = editNome.getText().toString();
              String fone = editFone.getText().toString();

              ret.putExtra("nome", nome);
              ret.putExtra("fone", fone);

              setResult(RESULT_OK, ret);
              finish();
          }
          if (btnCancel == v) {
              setResult(RESULT_CANCELED);
              finish();
          }

      }

}
