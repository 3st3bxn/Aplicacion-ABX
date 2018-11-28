package com.upt.madejesus.grupoabx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class SitioWeb extends AppCompatActivity {
    WebView View_web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitio_web);
        View_web = (WebView)findViewById(R.id.web_view);
        View_web.setWebViewClient(new WebViewClient());
        View_web.loadUrl("http://www.grupo-abx.com");
    }

    public void regresar(View view){
        Intent regresar = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(regresar);
        finish();
    }

}
