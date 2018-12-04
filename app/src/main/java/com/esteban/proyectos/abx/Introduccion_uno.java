package com.esteban.proyectos.abx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Introduccion_uno extends AppCompatActivity {
    Button btn1;
    ImageButton btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccion_uno);
        btn1 = (Button)findViewById(R.id.boton1);
        btn2 = (ImageButton)findViewById(R.id.boton2);
    }

    public void Menu (View view){
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
