package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBoxGuardar;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String llave = "sesion";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBoxGuardar = findViewById(R.id.checkBoxGuardarsesion);
        findViewById(R.id.btnCrearCuenta).setOnClickListener(this::irPaginaCrearCuenta);
        findViewById(R.id.btnIniciarSesion).setOnClickListener(this::IniciarSesion);
        inicializarElementos();
        if (resvisarSesion()){
            startActivity(new Intent(this,PaginaPrincipal.class));
        }else{
            String mensaje= "Inicia sesion";
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean resvisarSesion() {
        boolean sesion =this.sharedPreferences.getBoolean(llave,false);
        return sesion;
    }

    private void inicializarElementos() {
        sharedPreferences = this.getSharedPreferences("sesiones",Context.MODE_PRIVATE);
        editor= sharedPreferences.edit();

    }

    private void IniciarSesion(View view) {
        guardarSesion(checkBoxGuardar.isChecked());
        startActivity(new Intent(getApplicationContext(),PaginaPrincipal.class));
    }

    private void guardarSesion(boolean checked) {
        editor.putBoolean(llave,checked);
        editor.putString("email","andrea@gmail.com");

        editor.apply();

    }

    private void irPaginaCrearCuenta(View view) {
        Intent intent = new Intent(getApplicationContext(),CrearCuenta.class);
        startActivity(intent);
    }
}