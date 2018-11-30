package com.upt.madejesus.grupoabx;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "este hola", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Toast.makeText(MainActivity.this, "este botn", Toast.LENGTH_SHORT).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //toolbar.setTitle("Locochon");
        listView = (ListView)this.findViewById(R.id.lv_cotizaciones);
        new Peticiones("","mostrarCotizaciones",MainActivity.this,listView).execute();
        //navigationView.setItemIconTintList(null);


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
        getMenuInflater().inflate(R.menu.main, menu);
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
        FragmentManager fm = getSupportFragmentManager();

        if (id == R.id.nav_articulos) {
            fm.beginTransaction().replace(R.id.escenario, new Fragment_Articulos()).commit();

        } else if (id == R.id.nav_cotizaciones) {
            fm.beginTransaction().replace(R.id.escenario, new Fragment_Cotizacion()).commit();

        } else if (id == R.id.nav_finanzas) {
            fm.beginTransaction().replace(R.id.escenario, new Fragment_Finanazas()).commit();

        } else if (id == R.id.nav_publicidad) {
            fm.beginTransaction().replace(R.id.escenario, new Fragment_Publicidad()).commit();

        } else if (id == R.id.nav_web) {
            Intent navegar = new Intent(this, SitioWeb.class);
            startActivity(navegar);
            finish();

        } else if (id == R.id.nav_salir) {
            finish();
        }else if (id == R.id.nav_seguridad){
            fm.beginTransaction().replace(R.id.escenario, new Fragment_Seguridad()).commit();

        }else if (id == R.id.nav_software){
            fm.beginTransaction().replace(R.id.escenario, new Fragment_Software()).commit();

        }else if (id == R.id.nav_soporte){
            fm.beginTransaction().replace(R.id.escenario, new Fragment_Soporte()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
