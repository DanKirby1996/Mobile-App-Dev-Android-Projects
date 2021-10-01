package com.example.shoppinglist;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class myDialog extends AppCompatDialogFragment {
    private EditText addName;
    private EditText addPrice;
    private EditText addDesc;
    private Spinner addCat;
    private CheckBox addPurchased;

    private myDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.newitemdialog, null);

        builder.setView(view).setTitle("Shopping List")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })
                .setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String itemName = addName.getText().toString();
                        String itemDesc = addDesc.getText().toString();
                        String itemPrice = addPrice.getText().toString();
                        String itemCat = addCat.getSelectedItem().toString();
                        Boolean itemPurchased = addPurchased.isChecked();
                        if (!itemName.matches("")) {
                            listener.applyTexts(itemName, itemDesc, itemPrice, itemPurchased, itemCat);
                        }
                    }
                });
        addName = view.findViewById(R.id.additemname);
        addPrice = view.findViewById(R.id.additemcost);
        addDesc = view.findViewById(R.id.additemdesc);
        addCat = view.findViewById(R.id.spinner);
        addPurchased = view.findViewById(R.id.additemcheckbox);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (myDialogListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " implement listener");
        }


    }

    public interface myDialogListener{
        void applyTexts(String name, String desc, String price, Boolean purchased, String categ );
    }

}
