package com.esteban.proyectos.abx.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.esteban.proyectos.abx.R;
import com.esteban.proyectos.abx.clasesLista.Articulo;

import java.util.ArrayList;

public class AdaptadorArticulosSpinner extends BaseAdapter {

    private ArrayList<Articulo> articulos;
    private LayoutInflater inflater;
    private Activity activity;

    public AdaptadorArticulosSpinner(ArrayList<Articulo> articulos, Activity activity) {
        this.articulos = articulos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return this.articulos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.articulos.get(position);
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
        view = inflater.inflate(R.layout.item_spinner_articulos, null);

        TextView tv_nombre_articulo = view.findViewById(R.id.tv_nombre_articulo);
        tv_nombre_articulo.setText(this.articulos.get(position).getNombre_articulo());

        return view;
    }
}