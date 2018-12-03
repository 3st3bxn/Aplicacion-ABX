package com.esteban.proyectos.abx.clases_de_listas;

import java.io.Serializable;
import java.util.ArrayList;

public class Cotizaciones implements Serializable {
    private ArrayList<Cotizacion> cotizaciones;

    public ArrayList<Cotizacion> getCotizaciones() {
        return cotizaciones;
    }

    public void setCotizaciones(ArrayList<Cotizacion> cotizaciones){ this.cotizaciones = cotizaciones; }
}