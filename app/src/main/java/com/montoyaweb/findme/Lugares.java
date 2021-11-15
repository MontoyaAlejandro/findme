package com.montoyaweb.findme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.montoyaweb.findme.DAO.LugarDAO;
import com.montoyaweb.findme.adapters.LugaresAdapter;

public class Lugares extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);

        actualizarListaLugares();

        FloatingActionButton btnInsertar =(FloatingActionButton) findViewById(R.id.btn_Agregar_Lugares);
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = new Intent(view.getContext(), lugares_add.class);
                startActivity(i);
            }
        });

        Button btnBuscar = (Button) findViewById((R.id.btn_Buscar_Lugares));
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){actualizarListaLugares();}
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        actualizarListaLugares();
    }


    private void actualizarListaLugares() {
        EditText textoBusqueda = (EditText) findViewById(R.id.txt_Busqueda_Lugares);
        RecyclerView recLugares = (RecyclerView) findViewById(R.id.rcw_lista_lugares);
        recLugares.setLayoutManager(new LinearLayoutManager(this));
        LugarDAO db = new LugarDAO(this);
        LugaresAdapter luAD = new LugaresAdapter(db.listar(textoBusqueda.getText().toString()));
        recLugares.setNestedScrollingEnabled(true);
        recLugares.setAdapter(luAD);
    }
}