package com.example.proyecto;

import static com.example.proyecto.R.id.bregistrologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity{

    private EditText et_nombre;
    private EditText et_correo;
    private EditText et_numero;
    private EditText et_contrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_nombre = (EditText) findViewById(R.id.etnombreregistro);
        et_correo = (EditText) findViewById(R.id.etemailregistro);
        et_numero = (EditText) findViewById(R.id.etptelefonoregistro);
        et_contrasenia = (EditText) findViewById(R.id.etcontrasenaregistro);
    }

    // Método para dar de alta a usuarios

    public void RegistrarUsuario(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Usuarios", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String nombre = et_nombre.getText().toString();
        String correo = et_nombre.getText().toString();
        String numero = et_nombre.getText().toString();
        String contrasenia = et_nombre.getText().toString();

        if (!nombre.isEmpty() && !correo.isEmpty() && !numero.isEmpty() && !contrasenia.isEmpty()) {
            ContentValues registro = new ContentValues();
            registro.put("Nombre", nombre);
            registro.put("Correo", correo);
            registro.put("Numero", numero);
            registro.put("Contrasenia", contrasenia);

            BaseDeDatos.insert("usuarios", null, registro);

            BaseDeDatos.close();
            et_nombre.setText("");
            et_correo.setText("");
            et_numero.setText("");
            et_contrasenia.setText("");

            Toast.makeText(this, "Registro Éxitoso.", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Debes llenar todos los campos.", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para consultar usuarios.

    public void BuscarUsuarios(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Usuarios", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String correoElectronico = et_correo.getText().toString();

        if (!correoElectronico.isEmpty()) {
            Cursor fila = BaseDeDatos.rawQuery
                    ("select nombre, numero, contrasenia, from Usuarios where correoElectronico = " + correoElectronico, null);

            if (fila.moveToFirst()) {
                et_nombre.setText(fila.getString(0));
                et_numero.setText(fila.getString(1));
                et_contrasenia.setText(fila.getString(2));
                BaseDeDatos.close();
            }else {
                Toast.makeText(this, "No existe el correo electrónico.", Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }
        }else {
            Toast.makeText(this, "Introduce el correo electrónico a buscar.", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para regresar a activity_login.xml.

    public void Anterior(View view) {
        Intent anterior = new Intent(this, LoginActivity.class);
        startActivity(anterior);
    }
}