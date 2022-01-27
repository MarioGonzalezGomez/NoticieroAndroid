package mgg.noticiero;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Dialogo extends DialogFragment {
    private MainActivity main;

    private EditText etTitulo;
    private EditText etAutor;
    private EditText etFecha;
    private EditText etLink;

    private Button btnAdd;
    private Button btnCancel;

    public Dialogo() {

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialog = inflater.inflate(R.layout.noticia, null);

        initView(dialog);
        builder.setView(dialog).setTitle("Nueva noticia");

        initListeners();

        return builder.create();
    }

    private void initView(View dialog) {
        etTitulo = dialog.findViewById(R.id.titularNoticia);
        etAutor = dialog.findViewById(R.id.autorNoticia);
        etFecha = dialog.findViewById(R.id.fechaNoticia);
        etLink = dialog.findViewById(R.id.linkNoticia);

        btnAdd = dialog.findViewById(R.id.ok);
        btnCancel = dialog.findViewById(R.id.cancelar);
    }

    private void initListeners() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Noticia noticia = new Noticia();
                noticia.setTitular(etTitulo.getText().toString());
                noticia.setAutor(etAutor.getText().toString());
                noticia.setFecha(etFecha.getText().toString());
                noticia.setLink(etLink.getText().toString());

                main = (MainActivity) getActivity();
                main.addNoticia(noticia);
                Toast.makeText(getContext(), "Noticia añadida con éxito", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

}

