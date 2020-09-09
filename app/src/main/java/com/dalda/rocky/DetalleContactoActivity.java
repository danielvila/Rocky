package com.dalda.rocky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.dalda.rocky.pojo.Contacto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DetalleContactoActivity extends AppCompatActivity {

    TextView tvDcNombre;
    TextView tvDcTelefono;
    TextView tvDcEmail;
    ImageView imgDcFoto;
    public Contacto contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        agregarFAB();

        Intent intent = getIntent();
        contact = (Contacto)intent.getSerializableExtra("mycontact");

        String nombre   = contact.getNombre();
        String telefono = contact.getTelefono();
        String email    = contact.getEmail();

        tvDcNombre   = (TextView) findViewById(R.id.tvDcNombre);
        tvDcTelefono = (TextView) findViewById(R.id.tvDcTelefono);
        tvDcEmail    = (TextView) findViewById(R.id.tvDcEmail);

        /*registramos la linea de abajo para el menu contextual*/
        registerForContextMenu(tvDcNombre);

        tvDcNombre.setText(nombre);
        tvDcTelefono.setText(telefono);
        tvDcEmail.setText(email);

    }

    public void llamar(View v){
        String telefono = tvDcTelefono.getText().toString();
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));
    }

    public void enviarMail(View v){
        String email = tvDcEmail.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }

    /*boton flotante*/
    public void agregarFAB(){
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(findViewById(android.R.id.content),"diste click al boton flotante",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    /*metodo para el menupopup*/
    public void levantarMenuPopup(View v){
        ImageView imagen = (ImageView) findViewById(R.id.imgDcFoto);
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

    /** start metodos para el menu contextual*/
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
    /** end metodos para el menu contextual*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContactoActivity.this, ListadoMascotas.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}