package com.dalda.rocky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";
    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMilista;
    Adapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();
        sfiMiIndicadorRefresh = (SwipeRefreshLayout) findViewById(R.id.sfiMiIndicadorRefresh);
        lstMilista = (ListView) findViewById(R.id.lstMilista);
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMilista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas));
        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });
        Toast.makeText(this, getResources().getString(R.string.oncreate), Toast.LENGTH_LONG).show();
    }
    public void cambiarvista(View view){
        Intent intent = new Intent(this, ListadoMascotas.class);
        String message =getResources().getString(R.string.editText);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, getResources().getString(R.string.onstart), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, getResources().getString(R.string.onresume), Toast.LENGTH_LONG).show();
    }
    // actividad corriendo
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, getResources().getString(R.string.onrestart), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, getResources().getString(R.string.onpause), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, getResources().getString(R.string.onstop), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, getResources().getString(R.string.ondestroy), Toast.LENGTH_LONG).show();
    }

    public void refrescandoContenido(){
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMilista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas));
        sfiMiIndicadorRefresh.setRefreshing(false);
    }

    public void agregarFAB(){
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getResources().getString(R.string.mensaje), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.text_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SNACKBAR", "CLICK en snackbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });
    }
}