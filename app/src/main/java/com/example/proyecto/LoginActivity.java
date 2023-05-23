package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText et_correoLogin;
    private EditText et_correo;
    private EditText et_contrasenia;
    private CheckBox cb_guardarCorreo;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_correoLogin = (EditText) findViewById(R.id.etcorreologin);
        et_correo = (EditText) findViewById(R.id.etcorreologin);
        et_contrasenia = (EditText) findViewById(R.id.etpasswordlogin);
        cb_guardarCorreo = (CheckBox) findViewById(R.id.cbrecuerdamelogin);

        sharedPreferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et_correoLogin.setText(sharedPreferences.getString("mail", ""));
    }

    // Método para el botón del SharedPreferences.

    public void GuardarCorreo(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (cb_guardarCorreo.isChecked()) {
            editor.putString("mail", et_correoLogin.getText().toString());
        } else {
            editor.remove("mail");
        }
        editor.apply();
    }

    // Método para realizar log-in.

    public void Loguearse(View view) {

        String correoIngresado = et_correo.getText().toString();
        String correoValido = "correodeprueba@gmail.com";
        String contraseniaIngresada = et_contrasenia.getText().toString();
        String contraseniaValida = "contrasenia";

        if(correoIngresado.equals(correoValido) && contraseniaIngresada.equals(contraseniaValida))
        {
            Intent prueba = new Intent(this, VistaPrincipalUsuarioActivity.class);
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

    // Método para acceder al activity de registro.

    public void AccederRegistro(View view) {
        Intent registrar = new Intent(this, RegistroActivity.class);
        startActivity(registrar);
    }
}