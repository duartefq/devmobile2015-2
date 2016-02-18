package br.ifrn.tads.ddm.agendadetelefones;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class SobreActivity extends AppCompatActivity {
    private final String Tag="Sobre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(Tag, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
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

    public void btnFecharClick(View v) {
        Log.i(Tag, "btnFecharClick");

        finish();
    }

}
