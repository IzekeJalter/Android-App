package com.example.vida1;

import static com.example.vida1.Claseid.id.elnumero;
import static com.example.vida1.Claseid.id.ip_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    private RequestQueue requestQueue;
    public TextView id_visi, email_visi, nombre_visi, apellido_visi, edad_visi, telefono_visi, numero_tarjetaVisi;
    public Button btnEditarVisi, btnEliminarVisi;
    public String ids, emails, nombres, apellidos, edades, telefonos, n_tajeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_visitante);
        getSupportActionBar().hide();
        requestQueue = Singleton.getInstance(InformacionVisitante.this).getRequestQueue();
        solicitarInfo();
    }

    public void solicitarInfo(){
        String valor=String.valueOf(elnumero);


        String URL = ip_final + "/api/visitante/"+valor;


        id_visi = findViewById(R.id.TextVerIDVisitante);
        email_visi = findViewById(R.id.TextVerCorreoVisitante);
        nombre_visi = findViewById(R.id.TextVerNombreVisitante);
        apellido_visi = findViewById(R.id.TextVerApellidoVisitante);
        edad_visi= findViewById(R.id.TextVerEdadVisitante);
        telefono_visi= findViewById(R.id.TextVerTarjetaVisitante);
        numero_tarjetaVisi = findViewById(R.id.TextVerTarjetaVisitante);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    ids=response.getJSONObject("data").getString("id");
                    id_visi.setText(ids);
                    emails=response.getJSONObject("data").getString("email");
                    email_visi.setText(emails);
                    nombres=response.getJSONObject("data").getString("nombre");
                    nombre_visi.setText(nombres);
                    apellidos=response.getJSONObject("data").getString("apellidos");
                    apellido_visi.setText(apellidos);
                    edades=response.getJSONObject("data").getString("edad");
                    edad_visi.setText(edades);
                    telefonos=response.getJSONObject("data").getString("telefono");
                    telefono_visi.setText(telefonos);
                    n_tajeta=response.getJSONObject("data").getString("numero_tarjeta");
                    numero_tarjetaVisi.setText(n_tajeta);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(InformacionVisitante.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);

    }
}