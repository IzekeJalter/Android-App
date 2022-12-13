package com.example.vida1;

import static com.example.vida1.Claseid.id.elnumero;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vida1.Claseid.id;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import Singleton.Singleton;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBoxGuardar;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button btnIniciarSesion;
    String llave = "sesion";
   public  EditText Correo, Contraseña;
    private RequestQueue requestQueue;
    id il;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestQueue = Singleton.getInstance(MainActivity.this).getRequestQueue();
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        checkBoxGuardar = findViewById(R.id.checkBoxGuardarsesion);

        findViewById(R.id.btnCrearCuenta).setOnClickListener(this::irPaginaCrearCuenta);


        btnIniciarSesion = (Button) findViewById(R.id.btnIniciarSesion);
        btnIniciarSesion.setOnClickListener(this::IniciarSesion);
        Correo= (EditText) findViewById(R.id.txtCorreo);
        Contraseña = (EditText) findViewById(R.id.txtContraseña);



        inicializarElementos();

        if (resvisarSesion()){
            startActivity(new Intent(this,PaginaPrincipal.class));
        }else{
            String mensaje= "Inicia sesion";
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        }
    }
    private void revisarcampos() {
        if (Correo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Correo Nesesario", Toast.LENGTH_SHORT).show();
        }else{
            if (Contraseña.getText().toString().isEmpty()) {
                Toast.makeText(this, "Contraseña Necesaria", Toast.LENGTH_SHORT).show();
            }else{
                startActivity(new Intent(getApplicationContext(),PaginaPrincipal.class));
            }
        }
    }




    private boolean resvisarSesion() {
        boolean sesion =this.sharedPreferences.getBoolean(llave,false);
        return sesion;
    }

    private void inicializarElementos() {
        sharedPreferences = this.getSharedPreferences("sesiones",Context.MODE_PRIVATE);
        editor= sharedPreferences.edit();
    }

    private void IniciarSesion(View view) {
        revisarcampos();
        guardarSesion(checkBoxGuardar.isChecked());
        revisarcampos();

                String login =  "http://25.62.178.77:8000/api/login";

                JSONObject jsonbody= new JSONObject();
                try
                {
                    jsonbody.put("email", Correo.getText());
                    jsonbody.put("contraseña",Contraseña.getText());
                } catch (JSONException e)
                {
                    e.printStackTrace();
                }

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, login, jsonbody, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            Integer i=Integer.parseInt(response.get("id").toString());
                            String token=response.get("token").toString();

                            Toast.makeText(MainActivity.this,response.toString(), Toast.LENGTH_SHORT).show();

elnumero=i;


                            startActivity(new Intent(getApplicationContext(), PaginaPrincipal.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                }, new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText( MainActivity.this, "Hubo un error al inciar sesion"+error, Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(request);

        };





    private void guardarSesion(boolean checked) {
        editor.putBoolean(llave,checked);
        editor.putString("contraseña","615243");
        editor.apply();
    }

    private void irPaginaCrearCuenta(View view) {
        startActivity(new Intent(getApplicationContext(),CrearCuenta.class));
    }
}