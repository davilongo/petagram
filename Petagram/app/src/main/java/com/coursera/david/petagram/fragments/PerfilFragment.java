package com.coursera.david.petagram.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coursera.david.petagram.R;
import com.coursera.david.petagram.adaptadores.MascotaAdaptador;
import com.coursera.david.petagram.adaptadores.PerfilAdaptador;
import com.coursera.david.petagram.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList mascotas;
    private RecyclerView listaMascotas;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.lstPerfil);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList();
        mascotas.add(new Mascota("deivi", "0", R.drawable.deivi));
        mascotas.add(new Mascota("javi", "0", R.drawable.javi));
        mascotas.add(new Mascota("manuel", "0", R.drawable.manuel));
        mascotas.add(new Mascota("paco", "0", R.drawable.paco));
        mascotas.add(new Mascota("pepa", "0", R.drawable.pepa));


    }

    public void inicializarAdaptador() {
        PerfilAdaptador adaptador = new PerfilAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

}