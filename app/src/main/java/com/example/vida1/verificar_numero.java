package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import Singleton.Singleton;

public class verificar_numero extends AppCompatActivity {

   private RequestQueue requestQueue;

    Button btnVerificarCuenta;
    EditText NumeroVerificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_numero);

        requestQueue = Singleton.getInstance(verificar_numero.this).getRequestQueue();

        btnVerificarCuenta = (Button) findViewById(R.id.btnVerificarCuenta);
        NumeroVerificacion = findViewById(R.id.NumeroVerificacion);

        btnVerificarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String verificacion = NumeroVerificacion.getText().toString().trim();

                if (TextUtils.isEmpty(verificacion)) {
                    NumeroVerificacion.setError("Codigo de verificacion requerido");
                    return;
                }


                JSONObject body = new JSONObject();
                try {
                    body.put("codigo", NumeroVerificacion.getText());

                } catch (Exception e) {
                    e.printStackTrace();
                }

                  JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://25.62.178.77:8000/api/telefonoregistr", body, new Response.Listener<JSONObject>() {
                      @Override
                      public void onResponse(JSONObject response) {
                          try{
                              Toast.makeText(verificar_numero.this, "Cuenta verificada correctamente", Toast.LENGTH_SHORT);
                              startActivity(new Intent(getApplicationContext(),MainActivity.class));

                          } catch (Exception e) {
                              e.printStackTrace();
                          }


                      }
                  }, new Response.ErrorListener() {
                      @Override
                      public void onErrorResponse(VolleyError error) {
                          Toast.makeText(verificar_numero.this, "Codigo Incorrecto", Toast.LENGTH_SHORT).show();
                      }
                  });
                requestQueue.add(request);
            }


        });
    }
}

