package com.dalda.rocky;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.dalda.rocky.pojo.Contacto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DetalleMascota extends AppCompatActivity {
    TextView tvNombre;
    TextView tvTelefono;
    TextView tvEmail;
    public Contacto contact;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.mascota_detalle);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        TextView tvTituloMascotas = (TextView) findViewById(R.id.tvNombre);
        registerForContextMenu(tvTituloMascotas);

        agregarFAB();

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
    public void agregarFAB(){
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(findViewById(android.R.id.content),"diste click al boton flotante",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    public void levantarMenuPopup(View v){
        ImageView imagen = (ImageView) findViewById(R.id.imgImagen);
        PopupMenu popupMenu = new PopupMenu(this, imagen);
        popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.mpFavorito:
                        Toast.makeText(getBaseContext(), "imagen", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.mpContacto:
                        Toast.makeText(getBaseContext(), "detalle", Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contexto, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cmEdit:
                Toast.makeText(this, "editando", Toast.LENGTH_LONG).show();
                break;
            case R.id.cmDelete:
                Toast.makeText(this, "borrando", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

}
