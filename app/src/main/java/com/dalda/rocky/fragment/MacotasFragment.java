package com.dalda.rocky.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dalda.rocky.pojo.Mascota;
import com.dalda.rocky.R;
import com.dalda.rocky.adapter.MascotaAdapter;

import java.util.ArrayList;

public class MacotasFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listamascotas;
    public MascotaAdapter adaptadormascota;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_macotas, container, false);

        listamascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llmmascotas = new LinearLayoutManager(getActivity());
        llmmascotas.setOrientation(LinearLayoutManager.VERTICAL);
        listamascotas.setLayoutManager(llmmascotas);
        iniciarListaMascotas();
        iniciarAdaptador();
        return v;
    }

    public void iniciarAdaptador(){
        adaptadormascota = new MascotaAdapter(mascotas, getActivity());
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

}