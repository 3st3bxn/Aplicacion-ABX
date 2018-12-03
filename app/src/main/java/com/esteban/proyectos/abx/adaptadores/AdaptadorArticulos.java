package com.esteban.proyectos.abx.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.esteban.proyectos.abx.R;
import com.esteban.proyectos.abx.clases_de_listas.Articulo;

import java.util.ArrayList;

public class AdaptadorArticulos extends BaseAdapter {
    private ArrayList<Articulo> articulos;
    private LayoutInflater inflater;
    private Activity activity;



    public AdaptadorArticulos(ArrayList<Articulo> articulos, Activity activity){
        this.articulos = articulos;
        this.activity     = activity;
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
        view = inflater.inflate(R.layout.item_lista_articulos, null);
        TextView tv_nombre_articulo = view.findViewById(R.id.tv_nombre_articulo);
        TextView tv_existencias     = view.findViewById(R.id.tv_existencias);
        TextView tv_precio          = view.findViewById(R.id.tv_precio);

        tv_nombre_articulo.setText(this.articulos.get(position).getNombre_articulo());
        tv_existencias.setText(this.articulos.get(position).getExistencias());
        tv_precio.setText(this.articulos.get(position).getPrecio());
        return view;
    }

}
