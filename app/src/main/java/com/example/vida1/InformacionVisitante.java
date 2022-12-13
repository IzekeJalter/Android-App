package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.example.vida1.Singleton.Singleton;

public class InformacionVisitante extends AppCompatActivity {

    private RequestQueue requestQueue;
    public EditText id_visi, email_visi, nombre_visi, apellido_visi, edad_visi, telefono_visi, numero_tarjetaVisi;
    public Button btnEditarVisi, btnEliminarVisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_visitante);
        getSupportActionBar().hide();
        requestQueue = Singleton.getInstance(InformacionVisitante.this).getRequestQueue();
        solicitarInfo();

    }

    public void solicitarInfo(){
        String URL = "http://127.0.0.1:8000/api/traevisitante/3";
    }
}