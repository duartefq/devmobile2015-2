package br.ifrn.tads.ddm.agendadetelefones;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int ITEM_NOVO_CONTATO = Menu.FIRST;
    private final int ITEM_SOBRE = Menu.FIRST + 1;
    private TableLayout tableLayout;
    private final String Tag="Main";
    private Agenda agenda;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(Tag, "onCreate");
        agenda = new Agenda();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableLayout = (TableLayout) findViewById(R.id.tableLayoutMain);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(Tag, "onCreateOptionsMenu");

        menu.add(Menu.NONE, ITEM_NOVO_CONTATO, Menu.NONE, R.string.novoContato);
        menu.add(Menu.NONE, ITEM_SOBRE, Menu.NONE, R.string.sobre);

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        Log.i(Tag, "onOptionsItemSelected");

        int id = item.getItemId();

        switch (id) {
            case ITEM_NOVO_CONTATO :
                openNovoContatoDialog();
                break;
            case ITEM_SOBRE :
                Intent sobre = new Intent(this, SobreActivity.class);
                startActivity(sobre);
                break;
            default:
                finish();
                break;
        }
        return true;
    }

    public void openNovoContatoDialog() {
        Button btnInserir, btnCancelar;
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_novo_contato);
        dialog.setTitle(R.string.app_name);
        btnInserir = (Button) dialog.findViewById(R.id.buttonInserir);
        btnCancelar = (Button) dialog.findViewById(R.id.buttonCancelar);
        btnInserir.setOnClickListener(listenerInserir);
        btnCancelar.setOnClickListener(listenerCancelar);
        dialog.show();
    }

    private View.OnClickListener listenerInserir =
            new View.OnClickListener() {
                public void onClick(View v) {
                    EditText nomeEdit = (EditText)
                            dialog.findViewById(R.id.editTextNome);
                    TextView foneEdit = (TextView)
                            dialog.findViewById(R.id.editTextTelefone);
                    String nome = nomeEdit.getText().toString();
                    String fone = foneEdit.getText().toString();
                    inserirContato(nome, fone);
                    Toast.makeText(MainActivity.this, nome + " " + fone,
                            Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    dialog = null;
                }
            };

    private View.OnClickListener listenerCancelar =
            new View.OnClickListener() {
                public void onClick(View v) {
                    dialog.dismiss();
                    dialog = null;
                }
            };

    private void inserirContato( String aNome, String aFone ) {
        Log.i(Tag, "inserirContato");
        agenda.inserir(aNome, aFone);


        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.tbrow_novo_contato, null);

        EditText editNome = (EditText) row.findViewById(R.id.row_nome);
        EditText editFone = (EditText) row.findViewById(R.id.row_fone);
        Button button = (Button) row.findViewById(R.id.botaoLigar);

        editNome.setText(aNome);
        editFone.setText(aFone);

        button.setOnClickListener(buttonListener);
        tableLayout.addView(row);
    }

    private View.OnClickListener buttonListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Log.i(Tag, "View.OnClickListener");


            TableRow row = (TableRow) v.getParent();

            EditText editFone = (EditText) row.findViewById(R.id.row_fone);
            String s = "tel:" + editFone.getText().toString();
            System.out.println(s);
            Uri uri = Uri.parse(s);
            Intent fone = new Intent(Intent.ACTION_CALL, uri);

            try {
                startActivity(fone);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    };

    @Override
    protected void onStart() {
        Log.i(Tag, "onStart");

        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(Tag, "onResume");

        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.i(Tag, "onRestart");

        super.onRestart();
    }

    @Override
    protected void onPause() {
        Log.i(Tag, "onPause");

        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(Tag, "onStop");

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(Tag, "onDestroy");

        super.onDestroy();
    }
}
