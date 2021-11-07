package com.montoyaweb.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lugares extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);
    }


    public void onClick(View view) {
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.btn_editar:

            case R.id.btn_eliminar:
                miIntent=new Intent(Lugares.this, lugares_edit_delete.class);

                break;

            case R.id.btn_agregar:
                miIntent=new Intent(Lugares.this, lugares_add.class);

        }
        startActivity(miIntent);


    }
}