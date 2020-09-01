package com.dalda.rocky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMilista;

    ArrayList<Mascota> mascotas;
    private RecyclerView listamascotas;
    public MascotaAdapter adaptadormascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listamascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llmmascotas = new LinearLayoutManager(this);
        llmmascotas.setOrientation(LinearLayoutManager.VERTICAL);
        listamascotas.setLayoutManager(llmmascotas);
        iniciarListaMascotas();
        iniciarAdaptador();

        lstMilista = (ListView) findViewById(R.id.lstMilista);
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMilista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas));

        sfiMiIndicadorRefresh = (SwipeRefreshLayout) findViewById(R.id.sfiMiIndicadorRefresh);
        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });
        Toast.makeText(this, getResources().getString(R.string.oncreate), Toast.LENGTH_LONG).show();
    }

    public void iniciarAdaptador(){
        adaptadormascota = new MascotaAdapter(mascotas, this);
        listamascotas.setAdapter(adaptadormascota);
    }
    public void iniciarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Zepellin", 2, R.drawable.mascota1));
        mascotas.add(new Mascota("Lucifer", 4, R.drawable.mascota2));
        mascotas.add(new Mascota("Rocky", 5, R.drawable.mascota3));
        mascotas.add(new Mascota("Yeico", 1, R.drawable.mascota4));
        mascotas.add(new Mascota("Duran", 3, R.drawable.mascota5));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mFavorito:
                Intent intent = new Intent(MainActivity.this, ListaFavoritos.class);
                intent.putExtra("mymascotas", mascotas);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void refrescandoContenido(){
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMilista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas));
        sfiMiIndicadorRefresh.setRefreshing(false);
    }

}