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
import com.dalda.rocky.presentador.IMascotasFragmentPresenter;
import com.dalda.rocky.presentador.MascotasFragmentPresenter;

import java.util.ArrayList;

public class MacotasFragment extends Fragment implements IMascotasFragment{

    private RecyclerView listamascotas;
    private IMascotasFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_macotas, container, false);

        listamascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new MascotasFragmentPresenter(this, getContext());

        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llmmascotas = new LinearLayoutManager(getActivity());
        llmmascotas.setOrientation(LinearLayoutManager.VERTICAL);
        listamascotas.setLayoutManager(llmmascotas);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdapter adaptadormascota = new MascotaAdapter(mascotas, getActivity());
        return adaptadormascota;
    }

    @Override
    public void iniciarAdaptadorRV(MascotaAdapter adapter) {
        listamascotas.setAdapter(adapter);
    }
}