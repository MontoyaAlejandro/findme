package com.montoyaweb.findme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.montoyaweb.findme.clases.Mensajes;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater propiedades = getMenuInflater();
        propiedades.inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i = null;

        switch (item.getItemId())
        {
            case R.id.menu_mniHome:
                i = new Intent(this, BienvenidaHome.class);
                break;

            case R.id.menu_mniPerfil:
                i = new Intent(this, Login.class);
                break;

            case R.id.menu_mniAgregarContacto:
              i= new Intent(this, contactos.class);
               break;

            case R.id.menu_mniLugares:
                i = new Intent(this, Lugares.class);
                break;

            case R.id.menu_mniAcerca:
                 i = new Intent(this, AcercaDeActivity.class);
                 break;
        }
            startActivity(i);
        return super.onOptionsItemSelected(item);
    }
}