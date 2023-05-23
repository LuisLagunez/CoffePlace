package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PromocionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones);
    }

    // Método para realizar pedido.

    public void RealizarPedido(View view) {
        Intent realizarPedido = new Intent(this, PopUpVentaUnoActivity.class);
        startActivity(realizarPedido);
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