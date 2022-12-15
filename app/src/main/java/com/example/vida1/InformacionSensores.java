package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vida1.Recyclerviewdelsensor.Adaptadordelsensor.Adaptadordelossensores;
import com.example.vida1.Recyclerviewdelsensor.Respuestas.Respuesta;
import com.example.vida1.Recyclerviewdelsensor.Respuestas.sensores;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InformacionSensores extends AppCompatActivity {

    Adaptadordelossensores adapter ;
    List<Respuesta> respuestas;
    List<sensores> sensoresList;

    private RequestQueue requestQueue ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_sensores);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        respuestas = new  ArrayList<>();
        sensoresList = new ArrayList<>();
        info();



    }

    private void info() {
        String url="http://18.219.177.143/api/sens";
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                RecyclerView recyclerView = findViewById(R. id. RclistaSensores);

                recyclerView. setLayoutManager(new LinearLayoutManager(getApplicationContext ()));
                Gson gson = new Gson();
                Respuesta pk = gson. fromJson(response. toString(), Respuesta.class);
                adapter = new Adaptadordelossensores(pk.getData());

                recyclerView. setAdapter(adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}