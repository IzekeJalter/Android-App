package com.example.vida1;

import static com.example.vida1.Claseid.id.elnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.RequestQueue;

public class CrearVisitante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_visitante);

        RequestQueue requestQueue;
        String valor=String.valueOf(elnumero);
    }
}