package com.esteban.proyectos.abx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IntroduccionUno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccion_uno);
    }
    public void Menu(View view){
        Intent menu = new Intent(getApplicationContext(), Act_cotizaciones.class);
        startActivity(menu);
        finish();
    }

   public void Siguiente(View view){
        Intent siguiente = new Intent(getApplicationContext(), Introduccion_dos.class);
        startActivity(siguiente);
        finish();
    }
}
