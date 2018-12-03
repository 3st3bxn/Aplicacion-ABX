package com.esteban.proyectos.abx.clasesLista;

import java.io.Serializable;

public class Cotizacion implements Serializable {

    private String id_cotizacion, nombre_cotizacion, descripcion, fecha, estatus;

    public String getId_cotizacion() {
        return id_cotizacion;
    }

    public void setId_cotizacion(String id_cotizacion) {
        this.id_cotizacion = id_cotizacion;
    }

    public String getNombre_cotizacion() {
        return nombre_cotizacion;
    }

    public void setNombre_cotizacion(String nombre_cotizacion) {
        this.nombre_cotizacion = nombre_cotizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
