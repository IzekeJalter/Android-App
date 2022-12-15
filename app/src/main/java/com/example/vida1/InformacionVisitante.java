package com.example.vida1;

import static com.example.vida1.Claseid.id.elnumero;
import static com.example.vida1.Claseid.id.ip_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vida1.Singleton.Singleton;

import org.json.JSONException;
import org.json.JSONObject;

public class InformacionVisitante extends AppCompatActivity {

    String nombre,apellidos,id,email,edad,telefono,numero_tarjeta;
    TextView txtid,txtnombre,txtapellidos,txtemail,txtedad,txttelefono,txttarjeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_visitante);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        findViewById(R.id.btnregresar).setOnClickListener(this::regresarPagina);


        txtid = findViewById(R.id.TextVerIDVisitante);
        txtnombre = findViewById(R.id.TextVerCorreoVisitante);
        txtapellidos = findViewById(R.id.TextVerNombreVisitante);
        txtemail = findViewById(R.id.TextVerApellidoVisitante);
        txtedad = findViewById(R.id.TextVerEdadVisitante);
        txttelefono = findViewById(R.id.TextVerTelVisitante);
        txttarjeta = findViewById(R.id.TextVerTarjetaVisitante);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        nombre = intent.getStringExtra("nombre");
        apellidos = intent.getStringExtra("apellidos");
        email = intent.getStringExtra("email");
        edad = intent.getStringExtra("edad");
        telefono = intent.getStringExtra("telefono");
        numero_tarjeta = intent.getStringExtra("numero_tarjeta");

        txtnombre.setText(nombre);
        txtid.setText(id);
        txtapellidos.setText(apellidos);
        txtemail.setText(email);
        txtedad.setText(edad);
        txttarjeta.setText(numero_tarjeta);

    }

    private void regresarPagina(View view) {
        Intent intent = new Intent(getApplicationContext(),ListaVisitas.class);
        startActivity(intent);
    }

}