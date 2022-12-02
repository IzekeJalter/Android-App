package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PaginaPrincipal extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);
        sharedPreferences = getSharedPreferences("sesiones",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        findViewById(R.id.btnCerrarSesion).setOnClickListener(this::cerrarSesion);
    }

    private void cerrarSesion(View view) {
        editor.putBoolean("sesion",false);
        editor.apply();
        Toast.makeText( this,"La sesion fue cerrada.", Toast.LENGTH_SHORT).show();
    }
}