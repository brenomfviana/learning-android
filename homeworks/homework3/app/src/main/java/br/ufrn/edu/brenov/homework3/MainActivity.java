package br.ufrn.edu.brenov.homework3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private float weight = 0, height = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.weight = 0;
        this.height = 0;
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView weightTV = findViewById(R.id.weight);
        weightTV.setText(String.valueOf(this.weight) + " kg");
        TextView heightTV = findViewById(R.id.height);
        heightTV.setText(String.valueOf(this.height) + " cm");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check code
        if (resultCode == 3){
            Bundle params = data.getExtras();
            this.weight = Float.parseFloat(params.getString("weight"));
            TextView weightTV = findViewById(R.id.weight);
            weightTV.setText(String.valueOf(this.weight) + " kg");
        } else if (resultCode == 4){
            Bundle params = data.getExtras();
            this.height = Float.parseFloat(params.getString("height"));
            TextView heightTV = findViewById(R.id.height);
            heightTV.setText(String.valueOf(this.height) + " m");
        }
    }

    public void changeWeight(View view) {
        Intent intent = new Intent(this, ChangeValueActivity.class);
        // Change weight
        Bundle params = new Bundle();
        params.putString("type", "weight");
        intent.putExtras(params);
        startActivityForResult(intent, 1);
    }

    public void changeHeight(View view) {
        Intent intent = new Intent(this, ChangeValueActivity.class);
        // Change height
        Bundle params = new Bundle();
        params.putString("type", "height");
        intent.putExtras(params);
        startActivityForResult(intent, 2);
    }

    public void calculate(View view) {
        float imc = 0;
        if (this.height != 0) {
            imc = this.weight / (this.height * this.height);
        }
        TextView result = findViewById(R.id.result);
        if (imc < 16) {
            result.setText("Magreza grave! (IMC < 16)");
        } else if (imc >= 16 && imc < 17) {
            result.setText("Magreza moderada! (16 <= IMC < 17)");
        } else if (imc >= 17 && imc < 18.5) {
            result.setText("Magreza leve! (17 <= IMC < 18.5)");
        } else if (imc >= 18.5 && imc < 25) {
            result.setText("Saudável! (18.5 <= IMC < 25)");
        } else if (imc >= 25 && imc < 30) {
            result.setText("Sobrepeso! (25 <= IMC < 30)");
        } else if (imc >= 30 && imc < 35) {
            result.setText("Obesidade grau I! (30 <= IMC < 35)");
        } else if (imc >= 35 && imc <= 40) {
            result.setText("Obesidade grau II (severa)! (35 <= IMC <= 40)");
        } else if (imc > 40) {
            result.setText("Obesidade grau III (mórbida)! (IMC > 40)");
        } else {
            Toast.makeText(this, "Algo deu errado!", Toast.LENGTH_LONG).show();
        }
    }
}
