package com.dalda.rocky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.dalda.rocky.adapter.MascotaAdapter;
import com.dalda.rocky.fragment.IMascotasFragment;
import com.dalda.rocky.pojo.Mascota;
import com.dalda.rocky.presentador.IMascotasFragmentPresenter;
import com.dalda.rocky.presentador.MascotasFragmentPresenter;

import java.util.ArrayList;

public class ListaFavoritos extends AppCompatActivity implements IMascotasFragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listafavoritos;
    private IMascotasFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoritos_lista);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listafavoritos = (RecyclerView) findViewById(R.id.rvMascotasfav);
        presenter = new MascotasFragmentPresenter(this, getApplicationContext());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ListaFavoritos.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llmfavoritos = new LinearLayoutManager(this);
        llmfavoritos.setOrientation(LinearLayoutManager.VERTICAL);
        listafavoritos.setLayoutManager(llmfavoritos);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdapter adapter = new MascotaAdapter(mascotas, this);
        return adapter;
    }

    @Override
    public void iniciarAdaptadorRV(MascotaAdapter adapter) {
        listafavoritos.setAdapter(adapter);
    }
}