package br.ufrn.edu.brenov.homework2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Ex1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);
    }

    public void show(View view) {
        // Get infos
        TextView name = findViewById(R.id.name);
        RadioButton rbm = findViewById(R.id.sexm);
        RadioButton rbf = findViewById(R.id.sexf);
        // Show infos
        TextView showName = findViewById(R.id.showname);
        showName.setText(name.getText());
        TextView showSex = findViewById(R.id.showsex);
        if (rbm.isChecked()) {
            showSex.setText("Male");
        }
        if (rbf.isChecked()) {
            showSex.setText("Female");
        }
    }

    public void clear(View view) {
        TextView name = findViewById(R.id.name);
        name.setText("");
        RadioButton rbm = findViewById(R.id.sexm);
        rbm.setChecked(false);
        RadioButton rbf = findViewById(R.id.sexf);
        rbf.setChecked(false);
        TextView showName = findViewById(R.id.showname);
        showName.setText("");
        TextView showSex = findViewById(R.id.showsex);
        showSex.setText("");
    }
}
