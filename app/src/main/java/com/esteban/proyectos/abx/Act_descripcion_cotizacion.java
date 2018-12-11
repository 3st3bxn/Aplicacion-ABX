package com.esteban.proyectos.abx;

import android.content.Intent;
import android.os.Bundle;
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
import android.widget.ListView;

public class Act_descripcion_cotizacion extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ListView listView;
    private Button btn_editar, btn_agregar_art, btn_eliminar, btn_compartir, btn_facturar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_descripcion_cotizacion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_descripcion_cotizacion);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_descripcion_cotizacion);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        /*Bundle position*/
        Log.e("Hola",getIntent().getStringExtra("POSICION"));
        final int position = Integer.parseInt(getIntent().getStringExtra("POSICION"));

        String id_cotizacion = (String)VariablesGlobales.COTIZACIONES.getCotizaciones().get(position).getId_cotizacion();
        //Log.e("Log",VariablesGlobales.COTIZACIONES.getCotizaciones().get(position).getId_cotizacion());

        String json = "{\"id_cotizacion\" : \""+ id_cotizacion +"\"}";

        listView = (ListView)this.findViewById(R.id.lv_articulos_cotizacion);

        new Peticiones(json, "consultarNombreCotizacion",Act_descripcion_cotizacion.this,listView).execute();

        new Peticiones(json,"consultarArticulosCotizacion",Act_descripcion_cotizacion.this,listView).execute();

        btn_editar          = (Button)findViewById(R.id.btn_editar);
        btn_agregar_art     = (Button)findViewById(R.id.btn_agregar_articulo);
        btn_eliminar        = (Button)findViewById(R.id.btn_eliminar);
        btn_compartir       = (Button)findViewById(R.id.btn_compartir);
        btn_facturar        = (Button)findViewById(R.id.btn_facturar);

        btn_agregar_art.setVisibility(View.INVISIBLE);
        btn_facturar.setVisibility(View.INVISIBLE);

        btn_editar.setVisibility(View.VISIBLE);
        btn_compartir.setVisibility(View.VISIBLE);
        btn_eliminar.setVisibility(View.VISIBLE);

        btn_facturar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_agregar_art.setVisibility(View.INVISIBLE);
                btn_facturar.setVisibility(View.INVISIBLE);

                btn_editar.setVisibility(View.VISIBLE);
                btn_compartir.setVisibility(View.VISIBLE);
                btn_eliminar.setVisibility(View.VISIBLE);

            }
        });

        btn_agregar_art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Agregar_articulos_cotizacion.class);
                i.putExtra("POSICION",""+position);
                startActivity(i);
            }
        });

        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_agregar_art.setVisibility(View.VISIBLE);
                btn_facturar.setVisibility(View.VISIBLE);

                btn_editar.setVisibility(View.INVISIBLE);
                btn_compartir.setVisibility(View.INVISIBLE);
                btn_eliminar.setVisibility(View.INVISIBLE);
            }
        });
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.act_descripcion_cotizacion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_articulos) {
            Intent i = new Intent(getApplicationContext(), Act_articulos.class);
            startActivity(i);
            finish();
        } else if (id == R.id.nav_cotizaciones) {
            Intent i = new Intent(getApplicationContext(), Act_cotizaciones.class);
            startActivity(i);
            finish();
        } else if (id == R.id.nav_visitar) {
            Intent i = new Intent(getApplicationContext(), Pag_Web.class);
            startActivity(i);
        } else if (id == R.id.nav_salir) {
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}