package com.dalda.rocky.fragment;

import com.dalda.rocky.adapter.MascotaAdapter;
import com.dalda.rocky.pojo.Mascota;

import java.util.ArrayList;

public interface IMascotasFragment {

    public void generarLinearLayoutVertical();

    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void iniciarAdaptadorRV(MascotaAdapter adapter);
}
