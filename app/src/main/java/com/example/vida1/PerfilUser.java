package com.example.vida1;

import static com.example.vida1.Claseid.id.elnumero;
import static com.example.vida1.Claseid.id.ip_final;
import static com.example.vida1.Claseid.id.n_tarjeta;
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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vida1.Claseid.id;

import com.example.vida1.Singleton.Singleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class PerfilUser extends AppCompatActivity {

    RequestQueue requestQueue;
    TextView username, email, nombre, apellido, edad, tel, tarjeta;
    id i;
    String usernames, emails, nombres, apellidos, edades, telefonos, tarjetas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestQueue = Singleton.getInstance(PerfilUser.this).getRequestQueue();

        setContentView(R.layout.activity_perfil_user);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        findViewById(R.id.btnPaginaEditarCuenta).setOnClickListener(this::iraPaginaEditarPErfil);
        findViewById(R.id.btnregresar).setOnClickListener(this::regresarPagina);
        findViewById(R.id.btnCerrarSeccion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CerrarSesion();
            }
        });


        String valor = String.valueOf(elnumero);
        String ntarjeta = String.valueOf(n_tarjeta);



        String url = ip_final + "/api/user/" + valor;


        username = findViewById(R.id.TextVerApodo);
        email = findViewById(R.id.TextVerCorreo);
        nombre = findViewById(R.id.TextVerNombre);
        apellido = findViewById(R.id.TextVerApellido);
        edad = findViewById(R.id.TextVerEdad);
        tel = findViewById(R.id.TextVerTel);
        tarjeta = findViewById(R.id.TextVerNumerotarjetaDueño);


       JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
           @Override
           public void onResponse(JSONObject response) {
               try{
                   usernames =response.getJSONObject("data").getString("username");
                   username.setText(usernames);
                   emails=response.getJSONObject("data").getString("email");
                   email.setText(emails);
                   nombres = response.getJSONObject("data").getString("nombre");
                   nombre.setText(nombres);
                   apellidos = response.getJSONObject("data").getString("apellidos");
                   apellido.setText(apellidos);
                   edades=response.getJSONObject("data").getString("edad");
                   edad.setText(edades);
                   telefonos=response.getJSONObject("data").getString("telefono");
                   tel.setText(telefonos);
                   tarjetas= String.valueOf(response.getJSONObject("data").getInt("numero_tarjeta"));
                   tarjeta.setText(tarjetas);

               } catch (Exception e) {
                   e.printStackTrace();
               }


           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               Toast.makeText( PerfilUser.this, "Hubo un error al inciar sesion"+error, Toast.LENGTH_SHORT).show();
           }
       });
        requestQueue.add(jsonObjectRequest);
         }


    private void CerrarSesion() {
        String Url = ip_final + "/api/salirsesionL";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Toast.makeText(PerfilUser.this, "Tu sesion ha sido cerrada exitosamente", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    tokens = "";
                } catch (Exception e) {
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

    private void regresarPagina(View view) {
        startActivity(new Intent(getApplicationContext(), PaginaPrincipal.class));
    }

    private void iraPaginaEditarPErfil(View view) {
        startActivity(new Intent(getApplicationContext(), EditarPerfil.class));
    }
}