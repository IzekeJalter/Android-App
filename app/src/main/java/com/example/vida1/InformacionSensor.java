package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

public class InformacionSensor extends AppCompatActivity {
    String nombre,info;
    TextView txtNombreSensor,txtInformacionSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_sensor);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        txtNombreSensor = findViewById(R.id.TextVerNombreSensor);
        txtInformacionSensor = findViewById(R.id.TextVerInformacionSensor);

        Intent intent = getIntent();
        nombre = intent.getStringExtra("nombre");
        info = intent.getStringExtra("info");

        txtNombreSensor.setText(nombre);
        txtInformacionSensor.setText(info);

    }
}