package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class PopUpVentaUnoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_venta_uno);


        DisplayMetrics medidaVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidaVentana);

        int ancho = medidaVentana.widthPixels;
        int alto = medidaVentana.heightPixels;

        getWindow().setLayout((int)(ancho * 0.85), (int)(alto * 0.5));

    }

    // Método para confirmar pedido.

    public void ConfirmarPedido(View view) {
        Intent regresar = new Intent(this, VistaPrincipalUsuarioActivity.class);
        startActivity(regresar);
        Toast.makeText(this, "Has realizado un pedido.", Toast.LENGTH_SHORT).show();
    }
}