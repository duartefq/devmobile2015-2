package br.ifrn.tads.ddm.agendadecontatos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FormFragment extends Fragment {

    private OnButtonClicked mCallback;

    private EditText editTextNome;
    private EditText editTextFone;

    private Button buttonInserir;
    private Button buttonEditar;
    private Button buttonExcluir;

    public FormFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FormFragment newInstance(String param1, String param2) {
        FormFragment fragment = new FormFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_form, container, false);


        editTextNome = (EditText) rootView.findViewById(R.id.editTextNome);
        editTextFone = (EditText) rootView.findViewById(R.id.editTextFone);

        buttonInserir = (Button) rootView.findViewById(R.id.buttonInserir);
        buttonEditar = (Button) rootView.findViewById(R.id.buttonEditar);
        buttonExcluir = (Button) rootView.findViewById(R.id.buttonExcluir);

        buttonInserir.setOnClickListener(buttonListener);
        buttonEditar.setOnClickListener(buttonListener);
        buttonExcluir.setOnClickListener(buttonListener);

        return rootView;
    }

    public interface OnButtonClicked {
        public void sendAction(int action, String nome, String fone);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnButtonClicked) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement TextClicked");
        }

    }

    private View.OnClickListener buttonListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            if (v.equals(buttonInserir)) {
                mCallback.sendAction(0, editTextNome.getText().toString(),
                        editTextFone.getText().toString());
            }
            if (v.equals(buttonEditar)) {
                mCallback.sendAction(1, editTextNome.getText().toString(),
                        editTextFone.getText().toString());
            }
            if (v.equals(buttonExcluir)) {
                mCallback.sendAction(2, editTextNome.getText().toString(),
                        editTextFone.getText().toString());
            }
        }
    };

    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }
}
