package com.esteban.proyectos.abx.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.esteban.proyectos.abx.R;
import com.esteban.proyectos.abx.VariablesGlobales;
import com.esteban.proyectos.abx.clasesLista.Articulo_cotizacion;

import java.util.ArrayList;

public class AdaptadorArticulosCotizacion extends BaseAdapter {
    private ArrayList<Articulo_cotizacion> articulos_cotizacion;
    private LayoutInflater inflater;
    private Activity activity;
    public AdaptadorArticulosCotizacion(ArrayList<Articulo_cotizacion> articulos_cotizacion, Activity activity) {
        this.articulos_cotizacion = articulos_cotizacion;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return this.articulos_cotizacion.size();
    }

    @Override
    public Object getItem(int position) {
        return this.articulos_cotizacion.get(position);
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
        view = inflater.inflate(R.layout.item_lista_articulos_cotizacion, null);

        TextView tv_concepto_ac = view.findViewById(R.id.tv_concepto_ac);

        TextView tv_precio_ac   = view.findViewById(R.id.tv_precio_ac);
        TextView tv_cantidad_ac = view.findViewById(R.id.tv_cantidad_ac);
        TextView tv_total_ac    = view.findViewById(R.id.tv_total_ac);

        tv_concepto_ac.setText(this.articulos_cotizacion.get(position).getConcepto());
        tv_precio_ac.setText(this.articulos_cotizacion.get(position).getPrecio());
        tv_cantidad_ac.setText(this.articulos_cotizacion.get(position).getCantidad());

        String str_cantidad_ac = tv_cantidad_ac.getText().toString();
        String str_precio_ac   = tv_precio_ac.getText().toString();

        Double cantidad_ac     = Double.valueOf(str_cantidad_ac);
        Double precio_ac       = Double.valueOf(str_precio_ac);

        Double total_ac        = cantidad_ac * precio_ac;
        tv_total_ac.setText("$" + total_ac);
        tv_precio_ac.setText("$"+ tv_precio_ac.getText().toString());
        return view;
    }
}
