package com.esteban.proyectos.abx;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.esteban.proyectos.abx.adaptadores.AdaptadorArticulos;
import com.esteban.proyectos.abx.adaptadores.AdaptadorArticulosCotizacion;
import com.esteban.proyectos.abx.adaptadores.AdaptadorArticulosSpinner;
import com.esteban.proyectos.abx.adaptadores.AdaptadorCotizaciones;
import com.esteban.proyectos.abx.clasesLista.Articulos;
import com.esteban.proyectos.abx.clasesLista.Articulos_cotizacion;
import com.esteban.proyectos.abx.clasesLista.Cotizaciones;
import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class Peticiones extends AsyncTask<String, String, String> {
    private String   json;
    private String   metodoApi;
    private Spinner  spinner;
    private Context  context;
    private Activity activity;
    private ListView listView;
    private TextView textView;


    public Peticiones(String json, String metodoApi, Activity activity, ListView listView) {
        this.json       = json;
        this.metodoApi  = metodoApi;
        this.activity   = activity;
        this.listView   = listView;
        this.spinner    = null;
    }

    public Peticiones(String json, String metodoApi) {
        this.json       = json;
        this.metodoApi  = metodoApi;
        this.spinner    = null;
    }
    public Peticiones(String json, String metodoApi, Activity activity, Spinner spinner) {
        this.json       = json;
        this.metodoApi  = metodoApi;
        this.activity   = activity;
        this.listView   = null;
        this.spinner    = spinner;
    }
    /*public Peticiones(String json, String metodoApi, Activity activity, TextView textView){
        this.json       = json;
        this.metodoApi  = metodoApi;
        this.activity   = activity;
        this.textView   = textView;
    }*/

    @Override
    protected String doInBackground(String... strings) {
        String resultado = "";
        HttpClient httpClient = new DefaultHttpClient();
        Log.d("Voy a mandar",this.json);
        try {
            HttpPost post = new HttpPost(VariablesGlobales.URL_API+this.metodoApi);
            StringEntity stringEntity= new StringEntity(this.json, "UTF8");
            post.setEntity(stringEntity);
            HttpResponse httpResponse = httpClient.execute(post);
            resultado = EntityUtils.toString(httpResponse.getEntity());
        }catch (Exception e) {
            Log.e("error", e.getMessage());
            httpClient.getConnectionManager().shutdown();
        }
        finally {
            httpClient.getConnectionManager().shutdown();
        }

        return resultado;
    }

    @Override
    protected void onPostExecute(String json) {
        super.onPostExecute(json);
        Log.d("Mi Json",json);
        if (this.metodoApi == "mostrarCotizaciones"){
            try {
                Gson gson = new Gson();
                Cotizaciones cotizaciones = gson.fromJson(json,Cotizaciones.class);
                VariablesGlobales.COTIZACIONES = cotizaciones;
                //generar el adaptador

                AdaptadorCotizaciones adaptador = new AdaptadorCotizaciones(cotizaciones.getCotizaciones(),this.activity);
                //Log.e("Resultado",cotizaciones.getCotizaciones().toString());
                adaptador.notifyDataSetChanged();
                listView.setAdapter(adaptador);
                for (int i=0; i< cotizaciones.getCotizaciones().size();i++){
                    Log.e("nombre",cotizaciones.getCotizaciones().get(i).getNombre_cotizacion());
                }
            }catch (Exception error){}

        }
        else if(this.metodoApi == "mostrarArticulos" && this.listView != null){
            try {
                Gson gson = new Gson();
                Articulos articulos = gson.fromJson(json,Articulos.class);
                //generar el adaptador

                AdaptadorArticulos adaptador = new AdaptadorArticulos(articulos.getArticulos(),this.activity);
                adaptador.notifyDataSetChanged();
                listView.setAdapter(adaptador);
                for (int i=0; i< articulos.getArticulos().size();i++){
                    Log.e("nombre",articulos.getArticulos().get(i).getNombre_articulo());
                }
            }catch (Exception error){}
        }

        else if(this.metodoApi == "mostrarArticulos"){

            try {
                Gson gson = new Gson();
                Articulos articulos = gson.fromJson(json,Articulos.class);
                //generar el adaptador
                VariablesGlobales.ARTICULOS = articulos;

                AdaptadorArticulosSpinner adaptador = new AdaptadorArticulosSpinner(articulos.getArticulos(),this.activity);
                adaptador.notifyDataSetChanged();
                spinner.setAdapter(adaptador);
                for (int i=0; i< articulos.getArticulos().size();i++){
                    Log.e("nombre",articulos.getArticulos().get(i).getNombre_articulo());
                }
            }catch (Exception error){}
        }
        else if(this.metodoApi == "consultarNombreCotizacion"){
            try{
                TextView tv_nombre = (TextView)activity.findViewById(R.id.tv_titulo_descripcion_cotizacion);
                Gson gson = new Gson();
                Cotizaciones cotizaciones = gson.fromJson(json,Cotizaciones.class);
                tv_nombre.setText(cotizaciones.getCotizaciones().get(0).getNombre_cotizacion());
            }catch (Exception error){}
        }
        else if(this.metodoApi == "consultarArticulosCotizacion"){
            try {
                int i;
                Double subtotal = 0.0, iva = 0.0, total = 0.0;
                TextView tv_subtotal          = (TextView)activity.findViewById(R.id.tv_rsubtotal);
                TextView tv_iva               = (TextView)activity.findViewById(R.id.tv_r_iva);
                TextView tv_total             = (TextView)activity.findViewById(R.id.tv_r_total);
                TextView tv_nombre_cotizacion = (TextView)activity.findViewById(R.id.tv_titulo_descripcion_cotizacion);
                Gson gson = new Gson();
                Articulos_cotizacion articulos_cotizacion = gson.fromJson(json,Articulos_cotizacion.class);
                //generar el adaptador

                AdaptadorArticulosCotizacion adaptador = new AdaptadorArticulosCotizacion(articulos_cotizacion.getArticulos_cotizacion(),this.activity);
                adaptador.notifyDataSetChanged();
                listView.setAdapter(adaptador);
                for (i=0; i< articulos_cotizacion.getArticulos_cotizacion().size();i++){
                    double cantidad =Double.valueOf(articulos_cotizacion.getArticulos_cotizacion().get(i).getCantidad());
                    double precio = Double.valueOf(articulos_cotizacion.getArticulos_cotizacion().get(i).getPrecio());
                    subtotal += (cantidad*precio);
                    Log.e("Concepto",articulos_cotizacion.getArticulos_cotizacion().get(i).getConcepto());
                }

                iva = subtotal * 0.16;
                total = iva + subtotal;

                tv_subtotal.setText("$"+subtotal);
                tv_iva.setText("$"+iva);
                tv_total.setText("$" + total);
            }catch (Exception error){}
        }
    }
}
