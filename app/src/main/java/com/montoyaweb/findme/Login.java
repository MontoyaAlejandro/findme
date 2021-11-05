package com.montoyaweb.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void ir_Registro(View view){
        Intent irRegistro = new Intent (this, registro.class);
        startActivity(irRegistro);
    }

    public void ir_Bienvenida(View view){
        Intent irBienvenida = new Intent (this, BienvenidaHome.class);
        startActivity(irBienvenida);
    }
}