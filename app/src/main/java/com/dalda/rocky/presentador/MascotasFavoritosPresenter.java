package com.dalda.rocky.presentador;

import android.content.Context;

import com.dalda.rocky.db.ConstructorMascotas;
import com.dalda.rocky.fragment.IMascotasFragment;
import com.dalda.rocky.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritosPresenter implements IMascotasFragmentPresenter{

    private IMascotasFragment iMascotasFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public MascotasFavoritosPresenter(IMascotasFragment iMascotasFragment, Context context) {
        this.iMascotasFragment = iMascotasFragment;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerFavoritos();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iMascotasFragment.iniciarAdaptadorRV(iMascotasFragment.crearAdaptador(mascotas));
        iMascotasFragment.generarLinearLayoutVertical();
    }
}
