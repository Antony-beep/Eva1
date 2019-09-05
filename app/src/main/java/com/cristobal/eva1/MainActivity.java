package com.cristobal.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private TextView textView;
    private EditText lab1;
    private EditText lab2;
    private EditText lab3;
    private EditText lab4;
    private EditText teo1;
    private EditText teo2;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner_1);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.sistema_evaluacion,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        lab1 = (EditText) findViewById(R.id.edit_L1);
        lab2 = (EditText) findViewById(R.id.edit_L2);
        lab3 = (EditText) findViewById(R.id.edit_L3);
        lab4 = (EditText) findViewById(R.id.edit_L4);

        teo1 = (EditText) findViewById(R.id.edit_n1);
        teo2 = (EditText) findViewById(R.id.edit_n2);
        textView = (TextView) findViewById(R.id.textview_resultado);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text= parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void evaluar(View view){
        String primerCa = lab1.getText().toString();
        String segundo = lab2.getText().toString();
        String tercer= lab3.getText().toString();
        String cuarto = lab4.getText().toString();
        int calificacion1 = Integer.parseInt(primerCa);
        int calificacion2 = Integer.parseInt(segundo);
        int calificacion3 = Integer.parseInt(tercer);
        int calificacion4 = Integer.parseInt(cuarto);
        double promedioL = ((calificacion1+calificacion2+calificacion3+calificacion4)/4)*0.7;
        Spinner spinner = (Spinner) findViewById(R.id.spinner_1);
        String size = spinner.getSelectedItem().toString();

        if(promedioL >= 13 ) {
            textView.setText("Aprobado con :"+promedioL );
        }else{
            textView.setText("Desaprobado con :"+promedioL);
        }

    }
}
