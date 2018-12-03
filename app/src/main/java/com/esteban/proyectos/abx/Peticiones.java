package com.esteban.proyectos.abx;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import com.esteban.proyectos.abx.adaptadores.AdaptadorArticulos;
import com.esteban.proyectos.abx.adaptadores.AdaptadorCotizaciones;
import com.esteban.proyectos.abx.clasesLista.Articulos;
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
    private Context context;
    private Activity activity;
    private ListView listView;



    public Peticiones(String json, String metodoApi, Activity activity, ListView listView) {
        this.json = json;
        this.metodoApi = metodoApi;
        this.activity = activity;
        this.listView = listView;
    }

    public Peticiones(String json, String metodoApi) {
        this.json = json;
        this.metodoApi = metodoApi;
    }

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
                //generar el adaptador

                AdaptadorCotizaciones adaptador = new AdaptadorCotizaciones(cotizaciones.getCotizaciones(),this.activity);
                adaptador.notifyDataSetChanged();
                listView.setAdapter(adaptador);
                for (int i=0; i< cotizaciones.getCotizaciones().size();i++){
                    Log.e("nombre",cotizaciones.getCotizaciones().get(i).getNombre_cotizacion());
                }
            }catch (Exception error){}

        }
        else if(this.metodoApi == "mostrarArticulos"){
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
    }
}
