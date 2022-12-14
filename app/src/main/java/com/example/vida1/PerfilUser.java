package com.example.vida1;

import static com.example.vida1.Claseid.id.elnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vida1.Claseid.id;

import com.example.vida1.Singleton.Singleton;

import org.json.JSONException;
import org.json.JSONObject;


public class PerfilUser extends AppCompatActivity {

    RequestQueue requestQueue;
    TextView username;
    TextView email;
    TextView nombre;
    TextView apellido;
    TextView edad;
    TextView tel;
    TextView tarjeta;
    id i;
    String usernames;
    String emails;
    String nombres;
    String apellidos;
    String edades;
    String telefonos;
    String tarjetas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestQueue = Singleton.getInstance(PerfilUser.this).getRequestQueue();

        setContentView(R.layout.activity_perfil_user);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        findViewById(R.id.btnPaginaEditarCuenta).setOnClickListener(this::iraPaginaEditarPErfil);
        findViewById(R.id.btnregresar).setOnClickListener(this::regresarPagina);
        findViewById(R.id.btnCerrarSeccion).setOnClickListener(this::CerrarSesion);


        String valor = String.valueOf(elnumero);


        String url = "http://3.133.89.232/api/user/" + valor;

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
                   username.setText("username: "+usernames);
                   emails=response.getJSONObject("data").getString("email");
                   email.setText("correo: "+ emails);
                 nombres = response.getJSONObject("data").getString("nombre");
                   nombre.setText("nombre: "+nombres);
                   apellidos = response.getJSONObject("data").getString("apellidos");
                   apellido.setText("apellidos: "+apellidos);
                   edades=response.getJSONObject("data").getString("edad");
                   edad.setText("edad: "+ edades);
                   telefonos=response.getJSONObject("data").getString("telefono");
                   tel.setText("telefono: "+ telefonos);
                   tarjetas= String.valueOf(response.getJSONObject("data").getInt("numero_tarjeta"));
                   tarjeta.setText("tarjeta: " +tarjetas);

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


    private void CerrarSesion(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    private void regresarPagina(View view) {
        startActivity(new Intent(getApplicationContext(), PaginaPrincipal.class));
    }

    private void iraPaginaEditarPErfil(View view) {
        startActivity(new Intent(getApplicationContext(), EditarPerfil.class));
    }
}