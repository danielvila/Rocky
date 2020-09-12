package com.dalda.rocky.pojo;

import java.io.Serializable;

public class Mascota implements Serializable {
    private int id;
    private String nombre;
    private int rating;
    private int foto;

    public Mascota(String nombre, int rating, int foto) {
        this.nombre = nombre;
        this.rating = rating;
        this.foto = foto;
    }

    public Mascota() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
