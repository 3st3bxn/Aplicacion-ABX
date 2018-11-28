package com.upt.madejesus.grupoabx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Introduccion_dos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccion_dos);
    }
    public void Menu(View view){
        Intent menu = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(menu);
        finish();
    }
    public void Siguiente(View view){
        Intent siguiente = new Intent(getApplicationContext(), Introduccion_tres.class);
        startActivity(siguiente);
        finish();
    }
}
