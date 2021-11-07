package com.montoyaweb.findme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class lugares_edit_delete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares_edit_delete);
    }

    public void onClick(View view) {

        Intent miIntent=null;
        switch (view.getId()){
            case R.id.btn_update:

            case R.id.btn_delete:
                miIntent=new Intent(lugares_edit_delete.this, Lugares.class);
                startActivity(miIntent);
                break;
        }
    }
}
