package com.dalda.rocky.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dalda.rocky.R;
import com.dalda.rocky.adapter.PerfilDogAdapter;
import com.dalda.rocky.pojo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MascotaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MascotaFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listamascotas;
    public PerfilDogAdapter adaptadormascota;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MascotaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MascotaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MascotaFragment newInstance(String param1, String param2) {
        MascotaFragment fragment = new MascotaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascota, container, false);
        listamascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        GridLayoutManager llmmascotas = new GridLayoutManager(getActivity(), 3);
        listamascotas.setLayoutManager(llmmascotas);
        iniciarListaMascotas();
        iniciarAdaptador();
        return v;
    }

    public void iniciarAdaptador(){
        adaptadormascota = new PerfilDogAdapter(mascotas, getActivity());
        listamascotas.setAdapter(adaptadormascota);
    }

    public void iniciarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Lucifer", 2, R.drawable.mascota4));
        mascotas.add(new Mascota("Lucifer", 4, R.drawable.mascota4));
        mascotas.add(new Mascota("Lucifer", 5, R.drawable.mascota4));
        mascotas.add(new Mascota("Lucifer", 1, R.drawable.mascota4));
        mascotas.add(new Mascota("Lucifer", 3, R.drawable.mascota4));
        mascotas.add(new Mascota("Lucifer", 0, R.drawable.mascota4));
        mascotas.add(new Mascota("Lucifer", 2, R.drawable.mascota4));
        mascotas.add(new Mascota("Lucifer", 4, R.drawable.mascota4));
        mascotas.add(new Mascota("Lucifer", 5, R.drawable.mascota4));
        mascotas.add(new Mascota("Lucifer", 1, R.drawable.mascota4));
        mascotas.add(new Mascota("Lucifer", 3, R.drawable.mascota4));
        mascotas.add(new Mascota("Lucifer", 0, R.drawable.mascota4));
    }
}