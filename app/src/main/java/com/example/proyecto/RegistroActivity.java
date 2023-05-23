package com.example.proyecto;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity{

    private EditText et_nombre;
    private EditText et_correo;
    private EditText et_numero;
    private EditText et_contrasenia;
    private EditText et_confirmarContrasenia;
    private RadioButton rb_hombre;
    private RadioButton rb_mujer;
    private CheckBox cb_terminos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_nombre = (EditText) findViewById(R.id.etnombreregistro);
        et_correo = (EditText) findViewById(R.id.etemailregistro);
        et_numero = (EditText) findViewById(R.id.etptelefonoregistro);
        et_contrasenia = (EditText) findViewById(R.id.etcontrasenaregistro);
        et_confirmarContrasenia = (EditText) findViewById(R.id.etconfirmarcontrasenaregistro);
        rb_hombre = (RadioButton) findViewById(R.id.rbhombrelogin);
        rb_mujer = (RadioButton) findViewById(R.id.rbmujerlogin);
        cb_terminos = (CheckBox) findViewById(R.id.cbterminosregistro);
    }

    // Método para dar de alta a usuarios

    public void Registrar(View view) {

        String nombre = et_nombre.getText().toString();
        String correo = et_correo.getText().toString();
        String numero = et_numero.getText().toString();
        String contrasenia = et_contrasenia.getText().toString();
        String confirmarContrasenia = et_confirmarContrasenia.getText().toString();

        if (!nombre.isEmpty() && !correo.isEmpty() && !numero.isEmpty() && !contrasenia.isEmpty()
        && !confirmarContrasenia.isEmpty() && (rb_hombre.isChecked() || rb_mujer.isChecked()) && cb_terminos.isChecked())
        {
            Intent anterior = new Intent(this, LoginActivity.class);
            startActivity(anterior);
            Toast.makeText(this, "Registro Éxitoso", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para regresar a activity_login.xml.

    public void Anterior(View view) {
        Intent anterior = new Intent(this, LoginActivity.class);
        startActivity(anterior);
    }
}