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
    private TextView textView2;
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
        textView2 = (TextView) findViewById(R.id.textview_spinner);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text= parent.getItemAtPosition(position).toString();
       // Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void evaluar(View view){
        int nT1 = Integer.parseInt(teo1.getText().toString());
        int nT2 = Integer.parseInt(teo2.getText().toString());
        int nL1 = Integer.parseInt(lab1.getText().toString());
        int nL2 = Integer.parseInt(lab2.getText().toString());
        int nL3 = Integer.parseInt(lab3.getText().toString());
        int nL4 = Integer.parseInt(lab4.getText().toString());
        int myr = Math.max(nT1,nT2);
        int m1 = Math.min(nL1,nL2);
        int m2 = Math.min(nL3,nL4);
        int min = Math.min(m1,m2);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_1);
        String size = spinner.getSelectedItem().toString();
        if (size.equalsIgnoreCase("A:30% T+ 70% L")){
            double pom1 = ((nL1+nL2+nL3+nL4-min)/3)*0.70+myr*0.3;
            if(pom1 >= 13 ) {
                textView.setText("Aprobado con :"+pom1 );
                textView2.setText(size);
            }else{
                textView.setText("Desaprobado con :"+pom1);
            }
        }else if (size.equalsIgnoreCase("B:40% T+ 60% L")){
            double pom2 = ((nL1+nL2+nL3+nL4-min)/3)*0.60+myr*0.4;
            if(pom2 >= 13 ) {
                textView.setText("Aprobado con :"+pom2);
                textView2.setText(size);
            }else{
                textView.setText("Desaprobado con :"+pom2);
            }
        }else if(size.equalsIgnoreCase("C:20% T+ 80% L")){
            double pom3 = ((nL1+nL2+nL3+nL4-min)/3)*0.80+myr*0.2;
            if(pom3 >= 13 ) {
                textView.setText("Aprobado con :"+pom3);
                textView2.setText(size);
            }else{
                textView.setText("Desaprobado con :"+pom3);
            }
        }

    }
}
