package com.montoyaweb.findme.clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class ConexionBaseDatos extends SQLiteOpenHelper {
    public static final String NOMBRE_DB = "findme.db";


    public ConexionBaseDatos(@Nullable Context contexto) {
        super(contexto, NOMBRE_DB, null,2 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE lugares (id_lugar INTEGER PRIMARY KEY  AUTOINCREMENT, nombre_lugar TEXT(80) NOT NULL, descripcion_lugar TEXT(150) NOT NULL, latitud_lugar REAL NOT NULL, longitud_lugar REAL NOT NULL)");
        db.execSQL("CREATE TABLE usuario (id_usuario INTEGER PRIMARY KEY  AUTOINCREMENT, nombre_usuario TEXT(80) NOT NULL, email_usuario TEXT(150) NOT NULL, telefono_usuario TEXT(15) NOT NULL, pass_usuario TEXT NOT NULL)");
        db.execSQL("CREATE TABLE contacto (id_contacto INTEGER PRIMARY KEY  AUTOINCREMENT, nombre_contacto TEXT(80) NOT NULL, email_contacto TEXT(150) NOT NULL, telefono_contacto TEXT(15) NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE usuario;");
        db.execSQL("DROP TABLE lugares;");
        db.execSQL("DROP TABLE contactos;");
        onCreate(db);

    }
}
