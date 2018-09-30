package br.ufrn.edu.brenov.homework5.exercise1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.ufrn.edu.brenov.homework5.R;

public class Exercise1Activity extends AppCompatActivity implements DatePicker.DatePickerListener, TimePicker.TimePickerListener {

    private TextView schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
        this.schedule = findViewById(R.id.schedule);
        update(Calendar.getInstance().getTime());
    }

    public void setDate(View view) {
        DatePicker datePicker = new DatePicker();
        datePicker.show(getSupportFragmentManager(),"datePicker");
    }

    public void setHorary(View view) {
        TimePicker timePicker = new TimePicker();
        timePicker.show(getSupportFragmentManager(),"timePicker");
    }

    @Override
    public void update(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String str = sdf.format(date);
        this.schedule.setText(str);
    }
}
