package com.esteban.proyectos.abx.clasesLista;

import java.io.Serializable;
import java.util.ArrayList;

public class Articulos_cotizacion implements Serializable {
    private ArrayList<Articulo_cotizacion> articulos_cotizacion;

    public ArrayList<Articulo_cotizacion> getArticulos_cotizacion() {
        return articulos_cotizacion;
    }

    public void setArticulos_cotizacion(ArrayList<Articulo_cotizacion> articulos_cotizacion) {
        this.articulos_cotizacion = articulos_cotizacion;
    }
}
