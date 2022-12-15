package com.example.vida1;

import static com.example.vida1.Claseid.id.IOK;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import Singleton.Singleton;

public class SensorFortune extends AppCompatActivity implements View.OnClickListener {

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_fortune);

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        queue = Singleton.getInstance(SensorFortune.this).getRequestQueue();
         findViewById(R.id.buttonR).setOnClickListener(this);
        findViewById(R.id.button2R).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String url="https://io.adafruit.com/api/v2/IvonneLoba/feeds/viyda.led/data";
        JSONObject led = new JSONObject();
        String v = "0";

        switch (view.getId()) {
            case R.id.buttonR:
                v = "1";
                break;
            case R.id.button2R:
                v = "0";
                break;
        }
        try {
            led.put("value", v);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                url,
                led, new Response.Listener<JSONObject>() {
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
                headers.put("X-AIO-Key", "aio_rGEy88mCdYkqwaz9uyXmqL0xL56u");
                return headers;
            }
        };
        queue.add(jsonObjectRequest);
    }
}