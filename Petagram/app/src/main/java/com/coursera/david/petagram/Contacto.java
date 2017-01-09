package com.coursera.david.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class Contacto extends AppCompatActivity{

    //Declaring EditText
    private EditText edNombre;
    private EditText edEmail;
    private EditText edMensaje;

    //Send button
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        //Initializing the views
        edNombre = (EditText) findViewById(R.id.input_nombre);
        edEmail = (EditText) findViewById(R.id.input_email);
        edMensaje = (EditText) findViewById(R.id.input_mensaje);

        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        //Adding click listener
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              sendEmail();

            }
        });
    }


    private void sendEmail() {
        //Getting content for email
        String email = edEmail.getText().toString().trim();
        String subject = edNombre.getText().toString().trim();
        String message = edMensaje.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(Contacto.this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }


}