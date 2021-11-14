package com.montoyaweb.findme;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    TextView txtEmail ;
    TextView txtClave ;
    Button btnregistro;
    Button btnacceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Asigna los componentes a su respectiva variable
        this.txtEmail = findViewById(R.id.editTextTextEmailAddress);
        this.txtClave = findViewById(R.id.editTextTextPassword);


        //Crea los eventos de acceso y registro
        this.btnregistro = findViewById(R.id.login_Btn_Registro);
        this.btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar(txtEmail.getText().toString(), txtClave.getText().toString());
                System.out.println("prueba de registro exitosa");
                msgError(view.getContext());

            }
        });
        this.btnacceder = findViewById(R.id.login_Btn_Ingresar);
        this.btnacceder.setOnClickListener(view -> acceder(txtEmail.getText().toString(), txtClave.getText().toString()));
    }

    private void registrar(String email, String clave)
    {
        if(email.isEmpty() || clave.isEmpty()) {
            msgError(this);
        }

        if(!email.isEmpty() && !clave.isEmpty()) {
            msgExitosoRegistro(email);
        }

    }

    private void acceder(String email, String clave)
    {
        if(email.isEmpty() || clave.isEmpty()) {
            msgError(this);
        }

        if(!email.isEmpty() && !clave.isEmpty()) {
            msgExitoso(email);
        }

        }


    private void msgError(Context contexto)
    {
        AlertDialog.Builder mensaje = new AlertDialog.Builder(contexto);
        mensaje.setTitle("Error");
        mensaje.setMessage("Se ha producido un error autenticando al usuario");
        mensaje.setPositiveButton("Aceptar", null);
        mensaje.create();
        mensaje.show();
    }

    private void msgExitosoRegistro(String email)
    {
        AlertDialog.Builder mensaje = new AlertDialog.Builder(this);
        mensaje.setTitle("Registro exitoso");
        mensaje.setMessage("Se ha registrado el email "+ email + "\nPresione Aceptar y luego Ingresar");
        mensaje.setPositiveButton("Aceptar", null);
        mensaje.create();
        mensaje.show();
    }


    private void msgExitoso(String email)
    {
        Intent home = new Intent(this, MenuActivity.class);
        home.putExtra("email", email);
        startActivity(home);
    }
}



 /*   @Override
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
}*/