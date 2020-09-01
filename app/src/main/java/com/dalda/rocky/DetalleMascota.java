package com.dalda.rocky;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class DetalleMascota extends AppCompatActivity {
    TextView tvNombre;
    TextView tvTelefono;
    TextView tvEmail;
    public Contacto contact;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.mascota_detalle);
       /* Toast.makeText(this, "estamos comenzando esta vista", Toast.LENGTH_LONG).show();

        Intent intent = getIntent();
        contact = (Contacto)intent.getSerializableExtra("mycontact");

        String nombre   = contact.getNombre();
        String telefono = contact.getTelefono();
        String email    = contact.getEmail();
        Toast.makeText(this, email + " aqui con el email", Toast.LENGTH_LONG).show();*/
       /* tvNombre   = findViewById(R.id.tvNombre);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail    = findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);*/
/*
        Log.i("Nombre: ", nombre);
        Log.i("Telefono: ", telefono);
        Log.i("Email: ", email);*/
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleMascota.this, ListadoMascotas.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void llamar(View v){
        String telefono = tvTelefono.getText().toString();
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));
    }

    public void enviarMail(View v){
        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }
}
