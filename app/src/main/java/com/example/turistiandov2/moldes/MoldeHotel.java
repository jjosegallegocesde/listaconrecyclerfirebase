package com.example.turistiandov2.moldes;

import java.io.Serializable;

public class MoldeHotel implements Serializable {

    private String nombre;
    private String precio;
    private String telefono;
    private Integer foto;

    public MoldeHotel() { //constructor vacio
    }

    public MoldeHotel(String nombre, String precio, String telefono, Integer foto) {
        this.nombre = nombre;
        this.precio = precio;
        this.telefono = telefono;
        this.foto = foto;
    } //constructor lleno

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }
}
