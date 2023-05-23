package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VistaPrincipalUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_principal_usuario);
    }

    public void VerTodoNoticias(View view) {
        Intent verTodoNoticias = new Intent(this, NoticiasActivity.class);
        startActivity(verTodoNoticias);
    }


    // Barra de navegación.
    // Método para acceder a vista_uno_usuario.xml.

    public void Inicio(View view) {
        Intent inicio = new Intent(this, VistaPrincipalUsuarioActivity.class);
        startActivity(inicio);
    }

    public void Promociones(View view) {
        Intent promociones = new Intent(this, PromocionesActivity.class);
        startActivity(promociones);
    }

    public void Perfil(View view) {
        Intent perfil = new Intent(this, PerfilActivity.class);
        startActivity(perfil);
    }
}