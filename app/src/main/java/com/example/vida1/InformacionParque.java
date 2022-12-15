package com.example.vida1;

import static com.example.vida1.Claseid.id.ip_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vida1.Modelos.parque;

public class InformacionParque extends AppCompatActivity {
    private String id,nombre,reglas,medida_largoTerreno,medida_anchoTerreno,cantidad_entradas,cantidad_salidas;
    private TextView txtnombre, txtlargo,txtancho,txtentradas,txtsalidas,txtreglas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_parque);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        txtnombre = findViewById(R.id.TextVerNombreParque);
        txtlargo = findViewById(R.id.TextVerLargoTerreno);
        txtancho = findViewById(R.id.TextVerAnchoTerreno);
        txtentradas = findViewById(R.id.TextVerCantidadEntradas);
        txtsalidas = findViewById(R.id.TextVerCantidadSalidas);
        txtreglas = findViewById(R.id.TextVerReglasParque);
        findViewById(R.id.btnregresar).setOnClickListener(this::RegresarPagina);
        findViewById(R.id.btnpaginaListaSensores).setOnClickListener(this::ListaSensores);
        findViewById(R.id.btnPaginaListaVisitantes).setOnClickListener(this::vistaVisitantes);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        nombre = intent.getStringExtra("nombre");
        reglas = intent.getStringExtra("reglas");
        medida_largoTerreno = intent.getStringExtra("medida_largoTerreno");
        medida_anchoTerreno = intent.getStringExtra("medida_anchoTerreno");
        cantidad_entradas = intent.getStringExtra("cantidad_entradas");
        cantidad_salidas = intent.getStringExtra("cantidad_salidas");

        parque elemts = (parque) getIntent().getSerializableExtra("parque");
        txtnombre.setText(nombre);
        txtreglas.setText(reglas);
        txtlargo.setText(medida_largoTerreno);
        txtancho.setText(medida_anchoTerreno);
        txtentradas.setText(cantidad_entradas);
        txtsalidas.setText(cantidad_salidas);
    }

    private void vistaVisitantes(View view) {
        Intent intent = new Intent(getApplicationContext(),ListaVisitas.class);
        startActivity(intent);
    }

    private void ListaSensores(View view) {
        Intent intent= new Intent(getApplicationContext(),InformacionSensores.class);
        startActivity(intent);
    }

    private void RegresarPagina(View view) {
        Intent intent = new Intent(getApplicationContext(),PantallaParques.class);
        startActivity(intent);
    }

}