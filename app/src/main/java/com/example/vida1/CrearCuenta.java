package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
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
import com.example.vida1.Singleton.Singleton;

import org.json.JSONObject;

public class CrearCuenta extends AppCompatActivity {
    private RequestQueue requestQueue;

    public EditText nombre, apellidos, correo, contraseña, edad, telefono, username;
    public Button btnCrearNewCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        getSupportActionBar().hide();

        requestQueue = Singleton.getInstance(CrearCuenta.this).getRequestQueue();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        nombre = (EditText) findViewById(R.id.EditTextnewNombre);
        apellidos = (EditText) findViewById(R.id.EditTextnewApellido);
        correo = (EditText) findViewById(R.id.EditTextnewCorreo);
        contraseña = (EditText) findViewById(R.id.EditTextnewContraseña);
        edad = (EditText) findViewById(R.id.EditTextnewEdad);
        telefono = (EditText) findViewById(R.id.EditTextnewTel);
        username = (EditText) findViewById(R.id.EditTextnewApodo);

        btnCrearNewCuenta = (Button) findViewById(R.id.btnCrearNewCuenta);
        btnCrearNewCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nombre= nombre.getText().toString().trim();
                String Apellido = apellidos.getText().toString().trim();
                String Correo = correo.getText().toString().trim();
                String Contraseña = contraseña.getText().toString().trim();
                String Edad = edad.getText().toString().trim();
                String Telefono= telefono.getText().toString().trim();
                String Username = username.getText().toString().trim();

                if(TextUtils.isEmpty(Nombre))
                {
                    nombre.setError("El nombre es requerido");
                    return;
                }
                if(TextUtils.isEmpty(Apellido))
                {
                    apellidos.setError("Apellidos requeridos");
                    return;
                }
                if(TextUtils.isEmpty(Correo))
                {
                    correo.setError("Correo electronico requerido");
                    return;
                }
                if(TextUtils.isEmpty(Contraseña))
                {
                    contraseña.setError("Contraseña es requerida");
                    return;
                }
                if(TextUtils.isEmpty(Edad))
                {
                    edad.setError("Su edad es requerida");
                    return;
                }
                if(TextUtils.isEmpty(Telefono))
                {
                    telefono.setError("Numero telefonico requerido");
                    return;
                }
                if(TextUtils.isEmpty(Username))
                {
                    username.setError("Nombre de usuario requerido");
                    return;
                }


                JSONObject body = new JSONObject();
                try{
                    body.put("nombre", nombre.getText());
                    body.put("apellidos", apellidos.getText());
                    body.put("email", correo.getText());
                    body.put("contraseña", contraseña.getText());
                    body.put("edad", edad.getText());
                    body.put("telefono", telefono.getText());
                    body.put("username", username.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                }

<<<<<<< HEAD
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://3.133.89.232/api/registroDueño", body, new Response.Listener<JSONObject>() {
=======
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
                        "http://3.133.89.232/api/registroDueño",
                        body, new Response.Listener<JSONObject>() {
>>>>>>> 6cac6f3a96c196488be1b5659a8944d48e743922
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            Toast.makeText(CrearCuenta.this, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),verificar_numero.class));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(CrearCuenta.this, "Hubo un error al crear la cuenta: " +error, Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(request);

            }
        });
    }
}