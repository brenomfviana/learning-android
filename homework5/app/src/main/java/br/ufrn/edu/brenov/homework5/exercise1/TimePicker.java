package br.ufrn.edu.brenov.homework5.exercise1;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import java.util.Calendar;
import java.util.Date;

public class TimePicker  extends DialogFragment implements TimePickerDialog.OnTimeSetListener {


    private TimePickerListener listener;
    private static Calendar c = Calendar.getInstance();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof TimePickerListener)) {
            throw new RuntimeException("The context has to be a TimePickerListener");
        }
        this.listener = (TimePickerListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hour, minute,true);
    }

    @Override
    public void onTimeSet(android.widget.TimePicker timePicker, int hour, int minute) {
        c.set(Calendar.HOUR, hour);
        c.set(Calendar.MINUTE, minute);
        this.listener.update(c.getTime());
    }

    public interface TimePickerListener {
        void update(Date date);
    }
}
