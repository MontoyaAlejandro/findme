package com.montoyaweb.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class lugares_add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares_add);
    }

    public void onClick(View view) {
        Intent miIntent=new Intent(lugares_add.this, Lugares.class);
        startActivity(miIntent);
    }
}