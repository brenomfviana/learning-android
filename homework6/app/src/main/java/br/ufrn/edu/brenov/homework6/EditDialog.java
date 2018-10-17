package br.ufrn.edu.brenov.homework6;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

public class EditDialog extends DialogFragment {

    private EditText editText;
    private OnTextListener listener;

    public static void show(FragmentManager fm, OnTextListener listener){
        EditDialog dialog = new EditDialog();
        dialog.listener = listener;
        dialog.show(fm, "dialog");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Enter a text here:");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(listener != null){
                    String text = editText.getText().toString();
                    listener.onSetText(text);
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });
        View view = getActivity().getLayoutInflater().inflate(R.layout.edit_dialog,null);
        editText = view.findViewById(R.id.new_name);
        builder.setView(view);
        return builder.create();
    }

    public interface OnTextListener{
        void onSetText(String text);
    }
}
