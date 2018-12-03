package com.esteban.proyectos.abx.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.esteban.proyectos.abx.R;
import com.esteban.proyectos.abx.clases_de_listas.Cotizacion;

import java.util.ArrayList;

public class AdaptadorCotizaciones extends BaseAdapter {
    private ArrayList<Cotizacion> cotizaciones;
    private LayoutInflater inflater;
    private Activity activity;



    public AdaptadorCotizaciones(ArrayList<Cotizacion> cotizaciones, Activity activity){
        this.cotizaciones = cotizaciones;
        this.activity     = activity;
    }
    @Override
    public int getCount() {
        return this.cotizaciones.size();
    }

    @Override
    public Object getItem(int position) {
        return this.cotizaciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater)this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        view = inflater.inflate(R.layout.item_lista_cotizaciones, null);
        TextView tv_nombre_cotizacion = view.findViewById(R.id.tv_nombre_cotizacion);
        TextView tv_fecha             = view.findViewById(R.id.tv_fecha);

        tv_nombre_cotizacion.setText(this.cotizaciones.get(position).getNombre_cotizacion());
        tv_fecha.setText(this.cotizaciones.get(position).getFecha());
        return view;
    }

}
