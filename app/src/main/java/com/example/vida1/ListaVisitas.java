package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.vida1.Claseid.id.elnumero;
import static com.example.vida1.Claseid.id.ip_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vida1.Modelos.ListaVisitante;
import com.example.vida1.Modelos.Visitante;
import com.example.vida1.RecyclerVisitantes.VisitanteAdapter;
import com.example.vida1.Singleton.Singleton;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

public class ListaVisitas extends AppCompatActivity {
    Button btnPaginaCrearvistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_visitas);
        btnPaginaCrearvistas = findViewById(R.id.btnPaginaCrearvistas);
        btnPaginaCrearvistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CrearVisitante.class);
                startActivity(intent);
            }
        });

        String url = ip_final + "/api/visitantes/3";
        final RecyclerView rvVisitante = findViewById(R.id.RclistaVisitas);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Gson gson = new Gson();
                    ListaVisitante visilista = gson.fromJson(response.toString(), ListaVisitante.class);
                    List<Visitante> mvisi = visilista.getData();

                    VisitanteAdapter adapter = new VisitanteAdapter(mvisi, ListaVisitas.this);
                    rvVisitante.setAdapter(adapter);
                    rvVisitante.setHasFixedSize(true);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(ListaVisitas.this);
                    rvVisitante.setLayoutManager(manager);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        Singleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
}