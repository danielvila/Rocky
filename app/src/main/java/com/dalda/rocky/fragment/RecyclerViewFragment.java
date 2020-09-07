package com.dalda.rocky.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dalda.rocky.R;
import com.dalda.rocky.adapter.ContactoAdaptador;
import com.dalda.rocky.pojo.Contacto;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    private RecyclerView rvContactos;
    public ContactoAdaptador adaptador;
    ArrayList<Contacto> contactos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*return super.onCreateView(inflater, container, savedInstanceState);*/
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        /*  GridLayoutManager glm = new GridLayoutManager(this, 2);*/

        rvContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, getActivity());
        rvContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Juan Pimentel", "2649784", "juan@test.com", R.drawable.mascota1));
        contactos.add(new Contacto("Maria Bellido", "2644613", "maria@test.com", R.drawable.mascota2));
        contactos.add(new Contacto("Rosario Tijeras", "2641379", "rosario@test.com", R.drawable.mascota3));
        contactos.add(new Contacto("Jose Sanches", "2641478", "jose@test.com", R.drawable.mascota4));
        contactos.add(new Contacto("Nancy Icarraime", "2643698", "nancy@test.com", R.drawable.mascota5));
        contactos.add(new Contacto("Sonia Sarmiento", "2641379", "sonia@test.com", R.drawable.mascota1));


    }

}
