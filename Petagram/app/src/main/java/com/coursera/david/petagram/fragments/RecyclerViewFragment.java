package com.coursera.david.petagram.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.coursera.david.petagram.R;
import com.coursera.david.petagram.adaptadores.MascotaAdaptador;
import com.coursera.david.petagram.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    private ArrayList mascotas;
    private RecyclerView listaMascotas;


    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listaMascotas = (RecyclerView)v.findViewById(R.id.lstMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList();
        mascotas.add(new Mascota("deivi", "0", R.drawable.deivi));
        mascotas.add(new Mascota("javi", "0", R.drawable.javi));
        mascotas.add(new Mascota("manuel", "0", R.drawable.manuel));
        mascotas.add(new Mascota("paco", "0", R.drawable.paco));
        mascotas.add(new Mascota("pepa", "0", R.drawable.pepa));


    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }


}
