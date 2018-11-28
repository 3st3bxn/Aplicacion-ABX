package com.upt.madejesus.grupoabx;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    ProgressBar progressBarHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, IntroduccionABX.class);
                startActivity(intent);
                finish();

            }
        },3000);

        progressBarHorizontal = (ProgressBar)findViewById(R.id.progressBar);
        progressBarHorizontal.setProgress(0);

        new AsyncTask_load().execute();

    }



    public class AsyncTask_load extends AsyncTask {
        int progreso;

        @Override
        protected void onPreExecute(){
            progreso = 0;
        }


        @Override
        protected Object doInBackground(Object[] objects) {
            while(progreso <100){
                progreso++;
                publishProgress(progreso);
                SystemClock.sleep(20);
            }
            return null;
        }


        protected void onProgressUpdate(Integer... values){
            progressBarHorizontal.setProgress(values[0]);
        }

        public void Introduccion(View view){
            Intent introduccion = new Intent(getApplicationContext(), IntroduccionABX.class);
            startActivity(introduccion);
        }
    }



}
