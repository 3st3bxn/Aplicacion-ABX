package com.esteban.proyectos.abx;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class Act_nueva_cotizacion extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_nueva_cotizacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_nueva_cotizacion);
        setSupportActionBar(toolbar);

        String json="";

        String metodoApi="agregarCotizacion";
        Button btn_guardar = findViewById(R.id.btn_guardar);
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_nombre_cotizacion = (EditText)findViewById(R.id.et_nombre_cotizacion);
                EditText et_descripcion       = (EditText)findViewById(R.id.et_descripcion);

                String  str_nombre_cotizacion  = et_nombre_cotizacion.getText().toString(),
                        str_descripcion        = et_descripcion.getText().toString();

                JSONObject json_obj = new JSONObject();
                try{
                    json_obj.put("nombre_cotizacion",str_nombre_cotizacion);
                    json_obj.put("descripcion",str_descripcion);
                }catch (JSONException error){}

                Log.d("Mi campo tiene",json_obj.toString());
                try{
                    new Peticiones(json_obj.toString(),"agregarCotizacion").execute();
                    Toast.makeText(getApplicationContext(), "Cotización agregada", Toast.LENGTH_LONG).show();
                }catch (Exception error){
                    Toast.makeText(getApplicationContext(), "Error al agregar", Toast.LENGTH_LONG).show();
                }
                Intent i = new Intent(getApplicationContext(), Act_cotizaciones.class);
                startActivity(i);
                finish();
            }
        });
    }
}
