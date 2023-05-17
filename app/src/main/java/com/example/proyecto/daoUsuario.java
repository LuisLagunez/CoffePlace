package com.example.proyecto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuario {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd = "BDUsuarios";
    String tabla = "create table usuario(id integer primary key autoincrement, usuario text, pass text, nombre text, ap text)";

    public daoUsuario(Context c) {
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u = new Usuario();
    }

    public boolean insertarUsuario(Usuario u) {
        if(buscar(u.getCorreoElectronico()) == 0) {
            ContentValues cv = new ContentValues();
            cv.put("Nombre Completo", u.getNombreCompleto());
            cv.put("Correo Electrónico", u.getCorreoElectronico());
            cv.put("Número de Teléfono", u.getNumeroTelefono());
            cv.put("Contraseña", u.getContrasenia());
            return (sql.insert("usuario", null, cv)>0);
        }else{
            return false;
        }
    }

    public int buscar(String u) {
        int x = 0;
        lista = seleccionarUsuario();
        for (Usuario us:lista) {
            if (us.getCorreoElectronico().equals(u)) {
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuario> seleccionarUsuario() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if(cr != null && cr.moveToFirst()) {
            do {
                Usuario u = new Usuario();
                u.setId(cr.getInt(0));
                u.setNombreCompleto(cr.getString(1));
                u.setCorreoElectronico(cr.getString(2));
                u.setNumeroTelefono(cr.getString(3));
                u.setContrasenia(cr.getString(4));
                lista.add(u);
            }while (cr.moveToNext());
        }
        return lista;
    }

}
