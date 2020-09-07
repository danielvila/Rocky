package com.dalda.rocky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dalda.rocky.pojo.SendMailTask;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactoActivity extends AppCompatActivity {
    EditText etTextPersonName, etTextEmailAddress, etTextMultiLine;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarComentario(view);
            }
        });
    }

    public void enviarComentario(View view) {
        etTextPersonName = findViewById(R.id.etTextPersonName);
        etTextEmailAddress = findViewById(R.id.etTextEmailAddress);
        etTextMultiLine = findViewById(R.id.etTextMultiLine);

        String nombre = etTextPersonName.getText().toString();
        String toEmails = etTextEmailAddress.getText().toString();
        String msaje = etTextMultiLine.getText().toString();

        String emailBody = "Enviado por: " + nombre + ", Mensaje: " + msaje;

        try {
            String fromEmail ="info@agvideo.tv";
            String fromPassword = "r4lSkyBTbFmvOWT1";
            String emailSubject = "test App";

            List<String> toEmailList = Arrays.asList(toEmails.split("\\s*,\\s*"));
            Log.i("SendMailActivity", "To List: " + toEmailList);

            new SendMailTask(ContactoActivity.this).execute(fromEmail,
                    fromPassword, toEmails, emailSubject, emailBody);
            etTextPersonName.setText("");
            etTextEmailAddress.setText("");
            etTextMultiLine.setText("");
            Log.i("Mensaje", "enviado2");
        } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ContactoActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}