package br.ufrn.edu.brenov.homework5.exercise1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import java.util.Calendar;
import java.util.Date;

public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private DatePickerListener listener;
    private static Calendar c = Calendar.getInstance();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof DatePickerListener)) {
            throw new RuntimeException("The context has to be a DatePickerListener");
        }
        this.listener = (DatePickerListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.YEAR, year);
        this.listener.update(c.getTime());
    }

    public interface DatePickerListener {
        void update(Date date);
    }
}
