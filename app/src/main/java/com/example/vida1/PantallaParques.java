package com.example.vida1;

import static com.example.vida1.Claseid.id.elnumero;
import static com.example.vida1.Claseid.id.ip_final;
import static com.example.vida1.Claseid.id.tokens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String url = ip_final + "/api/parques/" + elnumero;
        final RecyclerView rvParque = findViewById(R.id.RclistaParque);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //Toast.makeText(PantallaParques.this, response.toString(), Toast.LENGTH_SHORT).show();
                    //Boolean respuesta = response.isNull("info");
                    int status = 200;
                    int respuesta = Integer.parseInt(response.getString("status"));
                    if(respuesta != status){
                        Toast.makeText(PantallaParques.this, "Tienes que agregar primero un parque", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), PaginaPrincipal.class);
                        startActivity(intent);
                    }else if(respuesta == status){
                        //Toast.makeText(PantallaParques.this, response.toString(), Toast.LENGTH_SHORT).show();
                        Gson gson = new Gson();

                        parqueRespuesta parquelista = gson.fromJson(response.toString(), parqueRespuesta.class);
                        List<parque> mparques= parquelista.getData();

                        ParqueAdaptador parqueAdaptador = new ParqueAdaptador(mparques, PantallaParques.this);
                        rvParque.setAdapter(parqueAdaptador);
                        rvParque.setHasFixedSize(true);

                        RecyclerView.LayoutManager manager = new LinearLayoutManager(PantallaParques.this);
                        rvParque.setLayoutManager(manager);
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(PantallaParques.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Bearer " + tokens);
                return headers;
            }
        };
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