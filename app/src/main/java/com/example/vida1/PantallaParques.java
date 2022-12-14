package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vida1.Adaptador.adaptadorparques;
import com.example.vida1.Modelos.parque;
import com.example.vida1.Modelos.parqueRespuesta;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Singleton.Singleton;

public class PantallaParques extends AppCompatActivity {
    List<parque> parque1;
    List<parqueRespuesta> results;
    adaptadorparques adaptador;
    private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_parques);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        findViewById(R.id.btnregresar).setOnClickListener(this::RegresarPagina);
        mQueue = Singleton.getInstance(PantallaParques.this).getRequestQueue();
        parque1 = new ArrayList<>();
        results = new ArrayList<>();
        jsrespons();
    }
    private void jsrespons() {
        String url ="http://18.219.177.143/api/traerparques";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                RecyclerView recyclerView = findViewById(R.id.RclistaParque);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                Gson gson = new Gson();
                parqueRespuesta parqu = gson.fromJson(response.toString(),parqueRespuesta.class);
                 adaptador = new adaptadorparques(parqu.getResults(), new adaptadorparques.OnItemClickListener(){
                    public void onItemClick(parque item) {

                        click(item);
                    }

                });

                recyclerView.setAdapter(adaptador);

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }

    public void click(parque item) {
        Intent intent = new Intent(getApplicationContext(),InformacionParque.class);
        startActivity(intent);
    }

    private void RegresarPagina(View view) {
        startActivity(new Intent(getApplicationContext(), PaginaPrincipal.class));
    }
}