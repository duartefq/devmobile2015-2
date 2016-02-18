package br.ifrn.tads.ddm.agendadetelefones;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class MainActivity extends AppCompatActivity {

    private final int ITEM_NOVO_CONTATO = Menu.FIRST;
    private final int ITEM_SOBRE = Menu.FIRST + 1;
    private TableLayout tableLayout;
    private final String Tag="Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(Tag, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableLayout = (TableLayout) findViewById(R.id.tableLayoutMain);

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
                Intent novo_contato = new Intent(this, NovoContatoActivity.class);
                startActivityForResult(novo_contato, 0);
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

    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data ) {
        Log.i(Tag, "onActivityResult");

        if ( 0 == requestCode ) {
            if ( RESULT_OK == resultCode ) {
                String nome = data.getCharSequenceExtra("nome").toString();
                String fone = data.getCharSequenceExtra("fone").toString();

                inserirContato(nome, fone);
            }
        }
    }

    private void inserirContato( String aNome, String aFone ) {
        Log.i(Tag, "inserirContato");


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
}
