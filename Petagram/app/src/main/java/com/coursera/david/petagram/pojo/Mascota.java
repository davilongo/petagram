package com.coursera.david.petagram.pojo;

/**
 * Created by David on 28/12/2016.
 */
public class Mascota {

    private String nombre;
    private String valoracion;
    private int imagen;
    public Mascota(String nombre, String valoracion, int imagen){
        this.setImagen(imagen);
        this.setNombre(nombre);
        this.setValoracion(valoracion);

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

}