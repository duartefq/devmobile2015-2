package br.ifrn.tads.ddm.cadastramentocnat_ifrn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonRegistrar;
    private Button buttonReset;

    private EditText nomeText;
    private EditText matriculaText;
    private AutoCompleteTextView diretoriaText;
    private AutoCompleteTextView cursoText;

    private TextView textView;

    private static final String[] DIRETORIAS = new String[] {
            "Diretoria de Ciências (DIAC)", "Diretoria de Informática (DIATINF)",
            "Diretoria de Indústria (DIACIN)", "Diretoria de Construção Civil (DIACON)",
            "Diretoria de Recursos Naturais (DIAREN)"
    };

    private static final String[] CURSOS = new String[] {
            "Espanhol ", "Física ", "Geografia ", "Matemática ", "Gestão Pública ",
            "Análise e Desenvolvimento de Sistemas ", "Comércio Exterior ",
            "Construção de Edifícios ", "Gestão Ambiental ", "Redes de Computadores ",
            "Automação Industrial"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRegistrar = (Button) findViewById(R.id.buttonRegistrar);
        buttonReset = (Button) findViewById(R.id.buttonReset);

        nomeText = (EditText) findViewById(R.id.nomeText);
        matriculaText = (EditText) findViewById(R.id.matriculaText);
        diretoriaText = (AutoCompleteTextView) findViewById(R.id.diretoriaText);
        cursoText = (AutoCompleteTextView) findViewById(R.id.cursoText);

        textView = (TextView) findViewById(R.id.textView);

        /*
        * Autocompletes
        * */
        ArrayAdapter<String> diretoriasAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, DIRETORIAS);

        ArrayAdapter<String> cursosAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, CURSOS);


        diretoriaText.setAdapter(diretoriasAdapter);
        cursoText.setAdapter(cursosAdapter);

        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);

                buttonRegistrar.setEnabled(false);
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.INVISIBLE);

                nomeText.setText("");
                matriculaText.setText("");
                diretoriaText.setText("");
                cursoText.setText("");

                buttonRegistrar.setEnabled(true);
            }
        });
    }


}
