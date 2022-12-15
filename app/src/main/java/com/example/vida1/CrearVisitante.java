package com.example.vida1;

import static com.example.vida1.Claseid.id.elnumero;
import static com.example.vida1.Claseid.id.ip_final;
import static com.example.vida1.Claseid.id.n_tarjeta;
import static com.example.vida1.Claseid.id.tokens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarException;

import Singleton.Singleton;

public class CrearVisitante extends AppCompatActivity {
    RequestQueue requestQueue;
    public EditText nombre, apellidos, correo, telefono, edad;
    public Button btnCrearVisitante;
    private ImageButton btnRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_visitante);
        requestQueue = Singleton.getInstance(CrearVisitante.this).getRequestQueue();

        Intent parque = getIntent();
        String id_parque = parque.getStringExtra("id_parque");

        String valor=String.valueOf(elnumero);
        String tarjeta=String.valueOf(n_tarjeta);

        nombre = (EditText) findViewById(R.id.EditTextnewNombrevistante);
        apellidos = (EditText) findViewById(R.id.EditTextnewApellidovistante);
        edad = (EditText) findViewById(R.id.EditTextnewEdadvisitante);
        correo =(EditText) findViewById(R.id.EditTextnewCorreovisitante);
        telefono = (EditText) findViewById(R.id.EditTextnewTelvisitante);

        btnRegresar = (ImageButton) findViewById(R.id.btnregresarL);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Regresarpagina();
            }
        });

        btnCrearVisitante = (Button) findViewById(R.id.btnpaginaCrearVisitante);
        btnCrearVisitante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nombre = nombre.getText().toString().trim();
                String Apellidos = apellidos.getText().toString().trim();
                String Edad = edad.getText().toString().trim();
                String Correo = correo.getText().toString().trim();
                String Telefono = telefono.getText().toString().trim();

                if(TextUtils.isEmpty(Nombre)){
                    nombre.setError("Nombre requerido");
                    return;
                }
                if(TextUtils.isEmpty(Apellidos)){
                    apellidos.setError("Apellidos requeridos");
                    return;
                }
                if(TextUtils.isEmpty(Edad)){
                    edad.setError("Edad requerida");
                    return;
                }
                if(TextUtils.isEmpty(Correo)){
                    correo.setError("Correo requerido");
                    return;
                }
                if(TextUtils.isEmpty(Telefono)){
                    telefono.setError("Telefono requerido");
                    return;
                }

                JSONObject body = new JSONObject();
                try {
                    body.put("nombre", ""+nombre.getText());
                    body.put("apellidos", ""+apellidos.getText());
                    body.put("edad", ""+edad.getText());
                    body.put("email", ""+correo.getText());
                    body.put("telefono", ""+telefono.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String url = ip_final + "/api/anadirvisitanteL/"+ elnumero + "/" + id_parque;


                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, body, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //Toast.makeText(CrearVisitante.this, response.toString(), Toast.LENGTH_SHORT).show();
                            int status = 201;
                            int respuesta = Integer.parseInt(response.getString("status"));
                            if(status == respuesta){
                                Toast.makeText(CrearVisitante.this, "Visitante aceptado", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), PantallaParques.class);
                                startActivity(intent);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(CrearVisitante.this, "Hubo un error al crear el visitante: " + error, Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("Authorization", "Bearer " + tokens);
                        return headers;
                    }
                };
                requestQueue.add(request);
            }
        });
    }
    private void Regresarpagina() {
        Intent intent = new Intent(getApplicationContext(), ListaVisitas.class);
        startActivity(intent);
    }
}