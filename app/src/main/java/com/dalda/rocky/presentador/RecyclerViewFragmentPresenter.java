package com.dalda.rocky.presentador;

import android.content.Context;

import com.dalda.rocky.adapter.ContactoAdaptador;
import com.dalda.rocky.db.ConstructorContactos;
import com.dalda.rocky.fragment.IRecyclerViewFragmentView;
import com.dalda.rocky.pojo.Contacto;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private  Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactos();
    }


    @Override
    public void obtenerContactos() {
        constructorContactos = new ConstructorContactos((context));
        contactos = constructorContactos.ObtenerDatos();
        mostrarContactos();
    }

    @Override
    public void mostrarContactos() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
