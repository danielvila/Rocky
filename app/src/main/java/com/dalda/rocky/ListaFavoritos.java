package com.dalda.rocky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import java.util.ArrayList;

public class ListaFavoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listafavoritos;
    public MascotaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoritos_lista);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listafavoritos = (RecyclerView) findViewById(R.id.rvMascotasfav);
        LinearLayoutManager llmfavoritos = new LinearLayoutManager(this);
        llmfavoritos.setOrientation(LinearLayoutManager.VERTICAL);
        listafavoritos.setLayoutManager(llmfavoritos);

        Intent intent = getIntent();
        mascotas = (ArrayList<Mascota>) intent.getSerializableExtra("mymascotas");
        iniciarAdaptador();
    }
    public void iniciarAdaptador(){
        adapter = new MascotaAdapter(mascotas, this);
        listafavoritos.setAdapter(adapter);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ListaFavoritos.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}