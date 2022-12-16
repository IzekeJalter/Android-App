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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vida1.Modelos.ListaSensor;
import com.example.vida1.Modelos.Sensor;
import com.example.vida1.RecyclerViewSensor.SensorAdaptador;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Singleton.Singleton;

public class InformacionSensores extends AppCompatActivity {
    String key;
    Button rueda;
    ImageButton bntregresa;
    private RequestQueue requestQueue ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_sensores);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Intent intent= getIntent();
        key = intent.getStringExtra("sensor_key");
        rueda = (Button) findViewById(R.id.btnPaginaRueda);
        rueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SensorFortune.class);
                startActivity(intent);
            }
        });
        bntregresa = (ImageButton) findViewById(R.id.btnregresarLS);
        bntregresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), PantallaParques.class);
                startActivity(intent1);
            }
        });

        info();

    }

    private void info() {
        String url= ip_final + "/api/sens";
        final RecyclerView rvSensor = findViewById(R.id.RclistaSensores);
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //Toast.makeText(InformacionSensores.this, response.toString(), Toast.LENGTH_SHORT).show();
                    Gson gson = new Gson();
                    ListaSensor listaSensor = gson.fromJson(response.toString(), ListaSensor.class);
                    List<Sensor> msensor = listaSensor.getData();

                    SensorAdaptador adaptador = new SensorAdaptador(msensor, InformacionSensores.this);
                    rvSensor.setAdapter(adaptador);
                    rvSensor.setHasFixedSize(true);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(InformacionSensores.this);
                    rvSensor.setLayoutManager(manager);

                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
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

        Singleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

}