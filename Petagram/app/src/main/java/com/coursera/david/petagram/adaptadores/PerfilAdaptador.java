package com.coursera.david.petagram.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coursera.david.petagram.R;
import com.coursera.david.petagram.pojo.Mascota;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * Created by Davilongo on 06/01/2017.
 */

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {

    ArrayList mascotas;
    Activity activity;

    public PerfilAdaptador(ArrayList mascotas, Activity activity){

        this.mascotas= mascotas;
        this.activity = activity;

    }

    @Override
    public PerfilAdaptador.PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        return new PerfilAdaptador.PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PerfilAdaptador.PerfilViewHolder perfilViewHolder, int position) {

        final Mascota mascota =(Mascota) mascotas.get(position);
        perfilViewHolder.nombre.setText(mascota.getNombre());
        perfilViewHolder.valoracion.setText(mascota.getValoracion());
        perfilViewHolder.imgFoto.setImageResource(mascota.getImagen());

        //metodo onclick del hueso

        perfilViewHolder.huesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String valoracion = mascota.getValoracion();
                int valoracionEntera = parseInt(valoracion);
                valoracionEntera++;
                String valoracionCadena= String.valueOf(valoracionEntera);
                mascota.setValoracion(valoracionCadena);
                perfilViewHolder.valoracion.setText(mascota.getValoracion());
            }
        });
    }

    @Override
    public int getItemCount() {//Cantidad de elementos q contiene la lista
        return mascotas.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{


        //Declarar todos los views

        private ImageView imgFoto;
        private TextView nombre;
        private TextView valoracion;
        private ImageView huesoBlanco;


        public PerfilViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView)itemView.findViewById(R.id.imgMascota);
            nombre = (TextView)itemView.findViewById(R.id.txtNombreMascota);
            valoracion = (TextView)itemView.findViewById(R.id.txtLikes);
            huesoBlanco = (ImageView)itemView.findViewById(R.id.imgHuesoBlanco);
        }
    }

}
