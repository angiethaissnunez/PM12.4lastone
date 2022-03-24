package com.example.pm124lastone;

public class Descripcion {
    Integer id;
    String Descripcion;
    String imagen;

    public Descripcion(){

    }

    public Descripcion(Integer id, String descripcion, String foto) {
        this.id = id;

        Descripcion = descripcion;

        this.imagen = foto;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }



}
