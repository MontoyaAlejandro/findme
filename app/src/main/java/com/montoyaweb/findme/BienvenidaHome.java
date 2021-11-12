package com.montoyaweb.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BienvenidaHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida_home);

        Button btn_acercade_bienvenida = (Button) findViewById(R.id.btn_acercade_bienvenida);
        btn_acercade_bienvenida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent acerca = new Intent(BienvenidaHome.this, AcercaDeActivity.class);
                BienvenidaHome.this.startActivity(acerca);

            }
        });

        Button btn_contactos_bienvenida = (Button) findViewById(R.id.btn_contactos_bienvenida);
        btn_contactos_bienvenida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contactos = new Intent(BienvenidaHome.this, contactos.class);
                BienvenidaHome.this.startActivity(contactos);
            }
        });

        Button btn_viajes_bienvenida = (Button) findViewById(R.id.btn_viajes_bienvenida);
        btn_viajes_bienvenida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viajes = new Intent(BienvenidaHome.this, Lugares.class);
                BienvenidaHome.this.startActivity(viajes);
            }
        });
    }
}