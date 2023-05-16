package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    // Barra de navegación.
    // Método para acceder a vista_uno_usuario.xml.

    public void Inicio(View view) {
        Intent inicio = new Intent(this, VistaUnoUsuarioActivity.class);
        startActivity(inicio);
    }

    public void Perfil(View view) {
        Intent perfil = new Intent(this, PerfilActivity.class);
        startActivity(perfil);
    }
}