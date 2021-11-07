package com.montoyaweb.findme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class contactos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);
    }

    public void ir_Bienvenida(View view){
        Intent irBienvenida = new Intent (this, BienvenidaHome.class);
        startActivity(irBienvenida);
    }
}