package com.dalda.rocky;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class ListadoMascotas extends AppCompatActivity {
    public static final String EXTRA_NOMBRE = "";
    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_mascotas);
        /*Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);*/

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);
        /*LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);*/
        GridLayoutManager llm = new GridLayoutManager(this, 2);


        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        /*
         ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto: contactos ) {
            nombresContacto.add(contacto.getNombre());
        }

        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListadoMascotas.this, DetalleMascota.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(i).getEmail());
                intent.putExtra(EXTRA_NOMBRE, contactos.get(i).getNombre());
                startActivity(intent);
                finish();
            }
        });*/

        // Get the Intent that started this activity and extract the string
        Intent intents = getIntent();
        String message = intents.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }
    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
    }
    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Juan Pimentel", "2649784", "juan@test.com", R.drawable.rayo));
        contactos.add(new Contacto("Maria Bellido", "2644613", "maria@test.com", R.drawable.rayo));
        contactos.add(new Contacto("Rosario Tijeras", "2641379", "rosario@test.com", R.drawable.rayo));
        contactos.add(new Contacto("Jose Sanches", "2641478", "jose@test.com", R.drawable.rayo));
        contactos.add(new Contacto("Nancy Icarraime", "2643698", "nancy@test.com", R.drawable.rayo));
        contactos.add(new Contacto("Sonia Sarmiento", "2641379", "sonia@test.com", R.drawable.rayo));


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ListadoMascotas.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}