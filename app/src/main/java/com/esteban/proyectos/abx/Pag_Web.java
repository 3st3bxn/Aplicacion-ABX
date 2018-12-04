package com.esteban.proyectos.abx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Pag_Web extends AppCompatActivity {
    WebView View_web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag__web);
        View_web = (WebView)findViewById(R.id.web_view);
        View_web.setWebViewClient(new WebViewClient());
        View_web.loadUrl("http://www.grupo-abx.com");
    }
    public void regresar(View view){
        Intent regresar = new Intent(getApplicationContext(), Act_cotizaciones.class);
        startActivity(regresar);
        finish();
    }
}
