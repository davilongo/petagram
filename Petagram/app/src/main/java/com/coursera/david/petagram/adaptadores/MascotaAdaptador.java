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
 * Created by David on 28/12/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList mascotas, Activity activity){

        this.mascotas= mascotas;
        this.activity = activity;

    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota =(Mascota) mascotas.get(position);
        mascotaViewHolder.nombre.setText(mascota.getNombre());
        mascotaViewHolder.valoracion.setText(mascota.getValoracion());
        mascotaViewHolder.imgFoto.setImageResource(mascota.getImagen());

        //metodo onclick del hueso

        mascotaViewHolder.huesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String valoracion = mascota.getValoracion();
                int valoracionEntera = parseInt(valoracion);
                valoracionEntera++;
                String valoracionCadena= String.valueOf(valoracionEntera);
                mascota.setValoracion(valoracionCadena);
                mascotaViewHolder.valoracion.setText(mascota.getValoracion());
            }
        });
    }

    @Override
    public int getItemCount() {//Cantidad de elementos q contiene la lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{


        //Declarar todos los views

        private ImageView imgFoto;
        private TextView nombre;
        private TextView valoracion;
        private ImageView huesoBlanco;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView)itemView.findViewById(R.id.imgMascota);
            nombre = (TextView)itemView.findViewById(R.id.txtNombreMascota);
            valoracion = (TextView)itemView.findViewById(R.id.txtLikes);
            huesoBlanco = (ImageView)itemView.findViewById(R.id.imgHuesoBlanco);
        }
    }

}
