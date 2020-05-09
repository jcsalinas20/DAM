package com.example.myapplication;

import java.io.Serializable;

public class User implements Comparable<User>, Serializable {

    /*********VARIABLES*********/
    private String fotoPerfil;
    private String nombre;
    private int contador;

    /*********CONSTRUCTOR*********/
    public User(String fotoPerfil, String nombre, int contador) {
        this.fotoPerfil = fotoPerfil;
        this.nombre = nombre;
        this.contador = contador;
    }

    /*********GETTERS AND SETTERS*********/
    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public int getContador() {
        return contador;
    }

    /*********COMPARE TO*********/
    @Override
    public int compareTo(User o) {
        return this.contador - o.contador;
    }
}