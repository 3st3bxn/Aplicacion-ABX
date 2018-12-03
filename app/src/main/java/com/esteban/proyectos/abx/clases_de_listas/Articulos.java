package com.esteban.proyectos.abx.clases_de_listas;

import java.io.Serializable;
import java.util.ArrayList;

public class Articulos implements Serializable {
    private ArrayList<Articulo> articulos;

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }
}

