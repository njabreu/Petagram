package com.example.nelson.petagram;

/**
 * Created by Nelson on 5/14/2016.
 */
public class Mascota {
    public String nombre;
    public int foto;
    public int totalLikes;

    public Mascota(String nombre, int foto, int totalLikes) {
        this.nombre = nombre;
        this.foto = foto;
        this.totalLikes = totalLikes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(int totalLikes) {
        this.totalLikes = totalLikes;
    }
}
