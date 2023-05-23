package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class PerfilActivity extends AppCompatActivity {

    private Button btn_fecha;
    private EditText et_fecha;
    private int dia, mes, anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        btn_fecha = (Button) findViewById(R.id.btnFechaPerfil);
        et_fecha = (EditText) findViewById(R.id.etFechaPerfil);
    }

    // Método para ingresar la fecha de nacimiento.

    public void AsignarFecha(View view) {
        if (view == btn_fecha) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    et_fecha.setText(dayOfMonth+"/"+(month + 1)+"/"+year);
                }
            }, dia, mes, anio);
            datePickerDialog.show();
        }
    }

    // Método para cerrar sesión.

    public void CerrarSesion(View view) {
        Intent cerrarSesion = new Intent(this, LoginActivity.class);
        startActivity(cerrarSesion);
        Toast.makeText(this, "Has cerrado sesión.", Toast.LENGTH_SHORT).show();
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