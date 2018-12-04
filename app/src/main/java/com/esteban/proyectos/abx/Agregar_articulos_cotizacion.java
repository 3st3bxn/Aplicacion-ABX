package com.esteban.proyectos.abx;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class Agregar_articulos_cotizacion extends AppCompatActivity{
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_articulos_cotizacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_agregar_articulos_cotizacion);
        setSupportActionBar(toolbar);

        spinner = (Spinner)findViewById(R.id.sp_articulos);
        new Peticiones("","mostrarArticulos",Agregar_articulos_cotizacion.this, spinner).execute();

    }

}
