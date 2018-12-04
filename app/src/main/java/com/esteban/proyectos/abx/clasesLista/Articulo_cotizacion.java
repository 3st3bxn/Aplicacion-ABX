package com.esteban.proyectos.abx.clasesLista;

import android.util.Log;

import java.io.Serializable;

public class Articulo_cotizacion implements Serializable {
    private String nombre_cotizacion,concepto, precio, cantidad;

    public String getNombre_cotizacion() {
        return nombre_cotizacion;
    }

    public void setNombre_cotizacion(String nombre_cotizacion) {
        this.nombre_cotizacion = nombre_cotizacion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
