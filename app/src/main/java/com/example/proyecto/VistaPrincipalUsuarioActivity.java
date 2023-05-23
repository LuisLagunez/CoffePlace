package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class VistaPrincipalUsuarioActivity extends AppCompatActivity {

    private ImageButton imgBtnInfoPopUp;
    private TextView txtPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_principal_usuario);
    }

    public void VerTodoNoticias(View view) {
        Intent verTodoNoticias = new Intent(this, NoticiasActivity.class);
        startActivity(verTodoNoticias);

        imgBtnInfoPopUp = findViewById(R.id.imgbtnordenvistauno);
    }


    // Barra de navegación.

    public void Inicio(View view) {
        Intent inicio = new Intent(this, VistaPrincipalUsuarioActivity.class);
        startActivity(inicio);
    }

    public void Pedido(View view) {
        Intent pedido = new Intent(this, PopUpPedidoActivity.class);
        startActivity(pedido);
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