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
import com.example.vida1.Modelos.parque;
import com.example.vida1.Modelos.parqueRespuesta;
import com.example.vida1.RecyclerParques.ParqueAdaptador;
import com.example.vida1.Singleton.Singleton;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

public class PantallaParques extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_parques);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        findViewById(R.id.btnregresar).setOnClickListener(this::RegresarPagina);
        jsrespons();
    }
    private void jsrespons() {
        String url ="http://18.219.177.143/api/parques/3";
        final RecyclerView rvParque = findViewById(R.id.RclistaParque);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = new Gson();

                parqueRespuesta parquelista = gson.fromJson(response.toString(), parqueRespuesta.class);
                List<parque> mparques= parquelista.getData();

                ParqueAdaptador parqueAdaptador = new ParqueAdaptador(mparques, PantallaParques.this);
                rvParque.setAdapter(parqueAdaptador);
                rvParque.setHasFixedSize(true);

                RecyclerView.LayoutManager manager = new LinearLayoutManager(PantallaParques.this);
                rvParque.setLayoutManager(manager);

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Singleton.getInstance(this).addToRequestQueue(request);
    }

    public void click(parque item) {
        Intent intent = new Intent(getApplicationContext(),InformacionParque.class);
        startActivity(intent);
    }

    private void RegresarPagina(View view) {
        startActivity(new Intent(getApplicationContext(), PaginaPrincipal.class));
    }
}