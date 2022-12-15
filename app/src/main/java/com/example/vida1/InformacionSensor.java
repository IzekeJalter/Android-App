package com.example.vida1;

import static com.example.vida1.Claseid.id.elnumero;
import static com.example.vida1.Claseid.id.ip_final;
import static com.example.vida1.Claseid.id.tokens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import Singleton.Singleton;

public class InformacionSensor extends AppCompatActivity {
    String key,nombre;
    TextView txtNombreSensor,txtInformacionSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_sensor);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        txtNombreSensor = findViewById(R.id.TextVerNombreSensor);
        txtInformacionSensor = findViewById(R.id.TextVerInformacionSensor);
        findViewById(R.id.btnregresar).setOnClickListener(this::regresarpagina);
        Intent intent = getIntent();
        key = intent.getStringExtra("sensor_key");
        nombre = intent.getStringExtra("nombre");
        txtNombreSensor.setText(nombre);
        json();

    }

    private void regresarpagina(View view) {
        Intent intent = new Intent(getApplicationContext(),InformacionSensores.class);
        startActivity(intent);
    }

    public void json(){
        Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show();
        String url = ip_final + "/api/traerinfo/" + elnumero + "/" + key;
//        String url = "http://io.adafruit.com/api/v2/IvonneLoba/feeds/viyda.gas-co/data/last";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Toast.makeText(InformacionSensor.this, response.toString(), Toast.LENGTH_SHORT).show();

                try {
                    txtInformacionSensor.setText(response.getString("value"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(InformacionSensor.this, error.toString(), Toast.LENGTH_SHORT).show();
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