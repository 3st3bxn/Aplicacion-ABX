package com.esteban.proyectos.abx;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Act_cotizaciones extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_cotizaciones);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_cotizaciones);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_cotizaciones);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_cotizaciones);
        navigationView.setNavigationItemSelectedListener(this);

        listView = (ListView)this.findViewById(R.id.lv_cotizaciones);
        new Peticiones("","mostrarCotizaciones",Act_cotizaciones.this,listView).execute();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item_lista_cotizaciones);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(getApplicationContext(), "Posición "+position, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), Act_descripcion_cotizacion.class);
                i.putExtra("POSICION",""+position);

                startActivity(i);
                finish();
            }
        });

    }

    public void nuevaCotizacion(View view) {
        Intent cotizacion = new Intent(getApplicationContext(), Act_nueva_cotizacion.class);
        startActivity(cotizacion);
        //finish();
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_cotizaciones);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.act_cotizaciones, menu);
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
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent i;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_articulos) {
            i = new Intent(this, Act_articulos.class);
            startActivity(i);
            finish();
        } else if (id == R.id.nav_cotizaciones) {

        } else if (id == R.id.nav_visitar) {
            Intent navegar = new Intent(this, Pag_Web.class);
            startActivity(navegar);
            finish();

        } else if (id == R.id.nav_salir) {
            finish();

    }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_cotizaciones);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
