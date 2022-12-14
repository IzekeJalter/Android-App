package com.example.vida1;

import static com.example.vida1.Claseid.id.ip_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.toolbox.JsonObjectRequest;

public class InformacionParque extends AppCompatActivity {
    private String id;
    private TextView txtnombre, txtlargo,txtancho,txtentradas,txtsalidas,txtreglas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_parque);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        txtnombre = findViewById(R.id.txtVerNombreParque);
        txtlargo = findViewById(R.id.TextVerLargoTerreno);
        txtancho = findViewById(R.id.TextVerAnchoTerreno);
        txtentradas = findViewById(R.id.EditTextEditarCantidadSalidas);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        getinfo();
    }

    private void getinfo() {
        String URL = ip_final + "/api/parque/3/" + id;

    }
}