package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

import Singleton.Singleton;


public class SensorRueda extends AppCompatActivity  implements View.OnClickListener {
    Button push;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        queue=Singleton.getInstance(SensorRueda.this).getRequestQueue();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_rueda);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String url2="https://io.adafruit.com/api/v2/IvonneLoba/feeds/viyda.led/data";
        JSONObject led = new JSONObject();

        switch (view.getId()) {
            case R.id.button:
                try {
                    led.put("value", "1");
                } catch (Exception e) {
                }
                break;
            case R.id.button2:

                try {
                    led.put("value", "0");
                } catch (Exception e) {
                }
                break;
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url2, led, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                Log.i("vol", error.toString());


            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("X-AIO-Key","aio_azPQ14DkwuOnX0yt4VhQwZj9lhNg");
                return headers;
            }
        };
        queue.add(jsonObjectRequest);
    }
}









 