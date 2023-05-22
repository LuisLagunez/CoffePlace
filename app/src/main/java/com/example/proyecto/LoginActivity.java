package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText et_correo;
    private EditText et_contrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_correo = (EditText) findViewById(R.id.etcorreologin);
        et_contrasenia = (EditText) findViewById(R.id.etpasswordlogin);
    }

    // Método para acceder al activity de registro.

    public void Loguearse(View view) {

        String correoIngresado = et_correo.getText().toString();
        String correoValido = "correodeprueba@gmail.com";
        String contraseniaIngresada = et_contrasenia.getText().toString();
        String contraseniaValida = "contrasenia";

        if(correoIngresado.equals(correoValido) && contraseniaIngresada.equals(contraseniaValida))
        {
            Intent prueba = new Intent(this, VistaUnoUsuarioActivity.class);
            startActivity(prueba);
        }
        else if (correoIngresado.equals(correoValido) && !contraseniaIngresada.equals(contraseniaValida))
        {
            Toast.makeText(this, "La contraseña ingresada es incorrecta.", Toast.LENGTH_SHORT).show();
        }
        else if (correoIngresado.isEmpty() || contraseniaIngresada.isEmpty())
        {
            Toast.makeText(this, "Debes rellenar los campos.", Toast.LENGTH_SHORT).show();
        }
        else if (!correoIngresado.equals(correoValido))
        {
            Toast.makeText(this, "El correo ingresado no existe.", Toast.LENGTH_SHORT).show();
        }

    }

    public void AccederRegistro(View view) {
        Intent registrar = new Intent(this, RegistroActivity.class);
        startActivity(registrar);
    }
}