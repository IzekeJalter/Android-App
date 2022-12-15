package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.vida1.Claseid.id.elnumero;
import static com.example.vida1.Claseid.id.ip_final;
import static com.example.vida1.Claseid.id.tokens;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.example.vida1.Singleton.Singleton;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CrearParque extends AppCompatActivity {
    private RequestQueue mQueue;
    EditText crearnombre, medialargo, medidaancho, reglas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_parque);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        crearnombre = findViewById(R.id.EditTextCrearNombreParque);
        medialargo = findViewById(R.id.EditTextCrearLargoTerreno);
        medidaancho = findViewById(R.id.EditTextCrearAnchoTerreno);
        reglas = findViewById(R.id.EditTextCrearReglasParque);
        findViewById(R.id.btnregresar).setOnClickListener(this::RegresarPagina);
        findViewById(R.id.btnCrearParque).setOnClickListener(this::CrearParque1);
        mQueue = Singleton.getInstance(CrearParque.this).getRequestQueue();
    }

    private void CrearParque1(View view) {
        String ApiAddparque = ip_final + "/api/anadirparque/" + elnumero;
       // JSONObject parque = new JSONObject();
        JSONObject jBody = new JSONObject();
        try {

            jBody.put("nombre",""+crearnombre.getText());
            jBody.put("reglas",""+reglas.getText());
            jBody.put("medida_largoTerreno",""+medialargo.getText());
            jBody.put("medida_anchoTerreno",""+medidaancho.getText());


        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, ApiAddparque, jBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();

                Toast.makeText(getApplicationContext(), "Se ha creado tu parque ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),PaginaPrincipal.class);
                startActivity(intent);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Bearer " + tokens);
                return headers;
            }
        };
        mQueue.add(request);


    }

    private void RegresarPagina(View view) {
        startActivity(new Intent(getApplicationContext(), PaginaPrincipal.class));
    }
}