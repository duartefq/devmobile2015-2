package br.ifrn.tads.ddm.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;

    private EditText userEntry;
    private TextView result;
    private TextView resultView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner) findViewById(R.id.spinnerId);

        userEntry = (EditText) findViewById(R.id.editTextReais);

        resultView = (TextView) findViewById(R.id.textViewResultadoText);

        result = (TextView) findViewById(R.id.textViewResultado);

    }



    public void onConvert(View v) {

        System.out.println(isEmpty(userEntry));

        if ( isEmpty(userEntry) ) {
            userEntry.setError(getResources().getString(R.string.error_noinput));
            return;
        }

        String selectedVal = getResources().
                getStringArray(R.array.moedasValues)[spinner1.getSelectedItemPosition()];

        Float currency = Float.parseFloat(selectedVal);

        Float reais = Float.parseFloat( userEntry.getText().toString() );

        if ( reais < 0 ) {
            userEntry.setError(getResources().getString(R.string.error_invalidinput));
            return;
        }

        Float finalResult = reais * currency;

        result.setText( String.format("%.2f", finalResult) );

        resultView.setVisibility(View.VISIBLE);

    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }


}
