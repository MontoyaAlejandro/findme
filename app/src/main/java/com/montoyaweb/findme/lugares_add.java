package com.montoyaweb.findme;

import static java.lang.Float.parseFloat;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.montoyaweb.findme.DAO.LugarDAO;
import com.montoyaweb.findme.Modelos.Lugar;
import com.montoyaweb.findme.clases.ConexionBaseDatos;
import com.montoyaweb.findme.clases.Mensajes;

public class lugares_add extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares_add);

        //hacer captura de la informacion:
        EditText campoNombre =(EditText) findViewById(R.id.txt_Nombre_LugaresAdd);
        EditText campoDescripcion =(EditText) findViewById(R.id.txt_Descripcion_LugaresAdd);
        EditText campoLatitud =(EditText) findViewById(R.id.txt_Latitud_LugaresAdd);
        EditText campoLongitud =(EditText) findViewById(R.id.txt_Longitud_LugaresAdd);
        Button btnInsertar = (Button) findViewById(R.id.btn_insert_LugaresAdd);
        //Button btnCoordenadas= (Button) findViewById(R.id.btn_Coordenadas_LugaresAdd);
        Button btnRegresar = (Button) findViewById(R.id.btn_Regresar_LugaresAdd);

        btnInsertar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String lugar = campoNombre.getText().toString();
                String descripcion = campoDescripcion.getText().toString();
                String latitud = campoLatitud.getText().toString();
                String longitud = campoLongitud.getText().toString();

                if(camposVacios(lugar, descripcion, latitud, longitud)){
                    Toast.makeText(lugares_add.this, "Debe diligenciar todos los campos", Toast.LENGTH_LONG).show();
                    //new Mensajes(view.getContext()).alerta("Campos vacios", "Debe diligenciar todos los campos");
                }else{
                    long id= insertar(campoNombre, campoDescripcion, campoLatitud, campoLongitud);
                    Toast.makeText(lugares_add.this, "Informacion Agregada con Exito", Toast.LENGTH_LONG).show();
                    //new Mensajes(view.getContext()).alerta("Registro Exitoso", "registro agregado correctamente");
                    onBackPressed();
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){onBackPressed();}
        });

    }


    private Boolean camposVacios(String lugar, String descripcion, String latitud, String longitud){
        boolean vacios=false;
        if(
                lugar.isEmpty() ||
                descripcion.isEmpty() ||
                latitud.isEmpty() ||
                longitud.isEmpty()

        ){
            vacios=true;
        }
    return vacios;
    }


    private long insertar(EditText lugar, EditText descripcion, EditText latitud, EditText longitud)
    {
        long id=0;
        Lugar lug= new Lugar();
        lug.setLugar(lugar.getText().toString());
        lug.setDescripcion(descripcion.getText().toString());
        lug.setLatitud(latitud.getText().toString());
        lug.setLongitud(longitud.getText().toString());

        LugarDAO lugares = new LugarDAO(this);
        lugares.insertar(lug);


        return id;
    }

}

