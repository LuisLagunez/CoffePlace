package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText correo;
    private EditText contrasena;
    private Button btnEntrar;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        correo = (EditText)findViewById(R.id.etcorreologin);
        contrasena = (EditText)findViewById(R.id.etpasswordlogin);
        btnEntrar = (Button)findViewById(R.id.btnlogin);
        btnRegistrar = (Button)findViewById(R.id.btnregistrar);


    }

    // Método para acceder al activity de registro.

    public void Registrar(View view) {
        Intent registrar = new Intent(this, RegistroActivity.class);
        startActivity(registrar);
    }

    public void Prueba(View view) {
        Intent prueba = new Intent(this, VistaUnoUsuarioActivity.class);
        startActivity(prueba);
    }
}