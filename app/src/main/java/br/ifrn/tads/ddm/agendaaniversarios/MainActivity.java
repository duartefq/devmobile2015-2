package br.ifrn.tads.ddm.agendaaniversarios;

import android.app.DatePickerDialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements DatePickerDialog.OnDateSetListener {

    private TextView list;
    private TextView previewDate;

    private EditText nome;
    private Button buttonInsert;

    private Agenda agenda;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agenda = new Agenda();
        list = (TextView) findViewById(R.id.viewDate);
        previewDate = (TextView) findViewById(R.id.previewDate);
        nome = (EditText) findViewById(R.id.editTextNome);
        buttonInsert = (Button) findViewById(R.id.buttonInsert);
        date = "";

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agenda.inserir(nome.getText().toString(), date);
                list.setText(agenda.toString());
            }
        });


    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        date = day + "/" + (month + 1) + "/" + year;
        previewDate.setText(date);
    }

    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }


}
