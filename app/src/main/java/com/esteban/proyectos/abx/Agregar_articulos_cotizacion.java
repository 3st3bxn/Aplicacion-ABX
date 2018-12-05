package com.esteban.proyectos.abx;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.esteban.proyectos.abx.adaptadores.AdaptadorArticulosSpinner;
import com.esteban.proyectos.abx.clasesLista.Articulo;
import com.esteban.proyectos.abx.clasesLista.Articulos;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Agregar_articulos_cotizacion extends AppCompatActivity{
    private Spinner spinner = null;
    private Button btn_agregar_articulo_cotizacion;
    private EditText cantidad;
    private int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_articulos_cotizacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_agregar_articulos_cotizacion);
        setSupportActionBar(toolbar);

        cantidad = (EditText) findViewById(R.id.et_cantidad_agregar);

        final String id_cotizacion = getIntent().getStringExtra("id_cotizacion");

        spinner = (Spinner)findViewById(R.id.sp_articulos);
        new Peticiones("","mostrarArticulos",Agregar_articulos_cotizacion.this, spinner).execute();

        btn_agregar_articulo_cotizacion = (Button)findViewById(R.id.btn_agregar_articulo);
        btn_agregar_articulo_cotizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                String str_cantidad = cantidad.getText().toString();
                position = (int)spinner.getSelectedItemPosition();
                //Toast.makeText(getApplicationContext(),str_cantidad,Toast.LENGTH_SHORT).show();
                JSONObject json_obj = new JSONObject();
                try{
                    json_obj.put("id_cotizacion",id_cotizacion);
                    json_obj.put("id_articulo",position);
                    json_obj.put("cantidad",str_cantidad);
                }catch (JSONException error){}
                Toast.makeText(getApplicationContext(),json_obj.toString(),Toast.LENGTH_SHORT).show();
                //Log.e("Mi campo tiene",json_obj.toString());
                /*try{
                    new Peticiones(json_obj.toString(),"agregarArticulosCotizacion").execute();
                    Toast.makeText(getApplicationContext(), "Cotización agregada", Toast.LENGTH_LONG).show();
                }catch (Exception error){
                    Toast.makeText(getApplicationContext(), "Error al agregar", Toast.LENGTH_LONG).show();
                }
                Intent i = new Intent(getApplicationContext(), Act_descripcion_cotizacion.class);
                startActivity(i);
                finish();*/

            }
        });
    }

}
