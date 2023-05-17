package com.example.proyecto;

import static com.example.proyecto.R.id.bregistrologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText correoElectronico;
    private EditText nombreCompleto;
    private EditText numeroTelefono;
    private EditText contrasenia;
    private Button registrar;
    private daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        correoElectronico = (EditText)findViewById(R.id.etemailregistro);
        nombreCompleto = (EditText)findViewById(R.id.etnombreregistro);
        numeroTelefono = (EditText)findViewById(R.id.etptelefonoregistro);
        contrasenia = (EditText)findViewById(R.id.etcontrasenaregistro);
        registrar = (Button)findViewById(R.id.bregistrologin);
        dao = new daoUsuario(this);
    }

    // Método para regresar a activity_login.xml.

    public void Anterior(View view) {
        Intent anterior = new Intent(this, LoginActivity.class);
        startActivity(anterior);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bregistrologin:
                Usuario u = new Usuario();
                u.setCorreoElectronico(correoElectronico.getText().toString());
                u.setNombreCompleto(nombreCompleto.getText().toString());
                u.setNumeroTelefono(numeroTelefono.getText().toString());
                u.setContrasenia(contrasenia.getText().toString());
                if (!u.isNull()) {
                    Toast.makeText(this, "ERROR: Campos Vacios", Toast.LENGTH_SHORT).show();
                }else if (dao.insertarUsuario(u)) {
                    Toast.makeText(this, "Registro Éxitoso", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}