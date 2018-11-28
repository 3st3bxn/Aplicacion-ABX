package com.upt.madejesus.grupoabx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IntroduccionABX extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccion_abx);


    }
    public void Menu(View view){
        Intent menu = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(menu);
        finish();
    }

    public void Siguiente(View view){
        Intent siguiente = new Intent(getApplicationContext(), Introduccion_dos.class);
        startActivity(siguiente);
        finish();
    }
}
