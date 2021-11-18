package com.montoyaweb.findme.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

import com.montoyaweb.findme.clases.ConexionBaseDatos;
import com.montoyaweb.findme.Modelos.Lugar;
import java.util.ArrayList;


public class LugarDAO extends ConexionBaseDatos {
    private Context contexto;

    public LugarDAO(@Nullable Context c) {
       super(c);
       this.contexto =c;

    }

    public long insertar(Lugar lugar){
        long id=0;
        try{
            ConexionBaseDatos dbc = new ConexionBaseDatos(this.contexto);
            SQLiteDatabase db =dbc.getWritableDatabase();

            ContentValues valores = new ContentValues();

            valores.put("nombre_lugar", lugar.getLugar());
            valores.put("descripcion_lugar", lugar.getDescripcion());
            valores.put("latitud_lugar", lugar.getLatitud());
            valores.put("longitud_lugar", lugar.getLongitud());
            id=db.insert("lugares", null, valores);

        }
        catch (Exception ex){


        }
        return id;
    }


    public ArrayList<Lugar> listar(@Nullable String criterioBusqueda){
        //abriri conexion
        ConexionBaseDatos dbc = new ConexionBaseDatos(this.contexto);
        //cnfgurar conexion escribir
        SQLiteDatabase db = dbc.getWritableDatabase();

        //comparaciones y condiciones de busqueda

        String consultasSQL = "SELECT id_lugar, nombre_lugar, descripcion_lugar, latitud_lugar, longitud_lugar FROM lugares";
        if(criterioBusqueda !=null)
            consultasSQL += " WHERE nombre_lugar like '%" + criterioBusqueda + "%' or descripcion_lugar like '%" + criterioBusqueda + "%' or latitud_lugar like '%" + criterioBusqueda + "%' or longitud_lugar like '%" + criterioBusqueda + "%'";

        ArrayList<Lugar> lugares = new ArrayList<>();

        Cursor registros = db.rawQuery(consultasSQL, null);

        if(registros.moveToFirst())
            do{
                Lugar lugarConsulta = new Lugar();
                lugarConsulta.setId(Integer.parseInt(registros.getString(0)));
                lugarConsulta.setLugar(registros.getString(1));
                lugarConsulta.setDescripcion(registros.getString(2));
                lugarConsulta.setLatitud(registros.getString(3));
                lugarConsulta.setLongitud(registros.getString(4));
                lugares.add(lugarConsulta);
            }while(registros.moveToNext());
        registros.close();
        return lugares;
    }

    public boolean editar(Lugar editarLugar){
        boolean edicion=false;
        //abriri conexion
        ConexionBaseDatos dbc = new ConexionBaseDatos(this.contexto);
        //cnfgurar conexion escribir
        SQLiteDatabase db = dbc.getWritableDatabase();

        try{
            db.execSQL("UPDATE lugares SET nombre_lugar = "+ editarLugar.getLugar() + ", descripcion_lugar = "+ editarLugar.getDescripcion() + ", latitud_lugar = "+ editarLugar.getLatitud() + ", longitud_lugar = "+ editarLugar.getLongitud() + " WHERE id_lugar = " + editarLugar.getId());
            edicion=true;
        }catch (Exception ex){

        }
        return edicion;
    }

    public boolean eliminar(Lugar eliminarLugar){
        boolean eliminar=false;
        //abriri conexion
        ConexionBaseDatos dbc = new ConexionBaseDatos(this.contexto);
        //cnfgurar conexion escribir
        SQLiteDatabase db = dbc.getWritableDatabase();

        try{
            db.execSQL("DELETE FROM lugares WHERE id_lugar = " + eliminarLugar.getId());
            eliminar=true;
        }catch (Exception ex){

        }
        return eliminar;
    }



}
