package com.upt.madejesus.grupoabx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Introduccion_tres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccion_tres);
    }
    public void Menu(View view){
        Intent menu = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(menu);
        finish();
    }
}
