package com.example.bboyc.inventoree;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class dialog extends DialogFragment {
//    DatabaseHelper databaseHelper;
//    SQLiteDatabase sqLiteDatabase;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final LayoutInflater inflater = getActivity().getLayoutInflater();

        final View view = inflater.inflate(R.layout.fragment_dialog, null);

        final DatabaseHelper helper = DatabaseHelper.getInstance(getContext());



        builder.setView(view);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Books");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {


                EditText editName, editDetail;

                editName = (EditText) view.findViewById(R.id.dialog_editTextName);
                editDetail = (EditText) view.findViewById(R.id.dialog_editTextDetail);

                helper.addInventory(editName.getText().toString(),editDetail.getText().toString());




                Log.e("LOG", editName.getText().toString());
                Log.e("LOG", editDetail.getText().toString());




            }
        });


                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.this.getDialog().cancel();
                    }
                });
                return builder.create();
    }
}