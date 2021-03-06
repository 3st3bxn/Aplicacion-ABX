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
import android.widget.ListView;

public class Act_articulos extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_articulos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_articulos);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_articulos);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_articulos);
        navigationView.setNavigationItemSelectedListener(this);

        listView = (ListView)this.findViewById(R.id.lv_articulos);
        new Peticiones("","mostrarArticulos",Act_articulos.this,listView).execute();
    }

    public void nuevaCotizacion(View view) {
        Intent cotizacion = new Intent(getApplicationContext(), Act_nueva_cotizacion.class);
        startActivity(cotizacion);
        finish();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_articulos);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.act_articulos, menu);
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
        Intent i;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_articulos) {

        } else if (id == R.id.nav_cotizaciones) {

            i = new Intent(this, Act_cotizaciones.class);
            startActivity(i);
            finish();

        } else if (id == R.id.nav_visitar) {

        } else if (id == R.id.nav_salir) {
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_articulos);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
