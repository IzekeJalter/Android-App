package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class CrearParque extends AppCompatActivity {

    public EditText nombreParque, largoTerreno, anchoTerreno, reglas;
    public Button btnCrearParque;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_parque);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        findViewById(R.id.btnregresar).setOnClickListener(this::RegresarPagina);

        nombreParque = (EditText)findViewById(R.id.EditTextCrearNombreParque);
        largoTerreno = (EditText) findViewById(R.id.EditTextCrearLargoTerreno);
        anchoTerreno = (EditText) findViewById(R.id.EditTextCrearAnchoTerreno);
        reglas = (EditText) findViewById(R.id.EditTextCrearReglasParque);
        btnCrearParque = (Button) findViewById(R.id.btnCrearParque);
        requestQueue = Volley.newRequestQueue(this);
        btnCrearParque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void RegresarPagina(View view) {
        startActivity(new Intent(getApplicationContext(),PaginaPrincipal.class));
    }
}