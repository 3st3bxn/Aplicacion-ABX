package com.esteban.proyectos.abx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
    protected static final int TIMER_RUNTIME = 10000;

    protected  boolean mbActive;
    protected ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mProgressBar =(ProgressBar)findViewById(R.id.progressBar);

        final Thread timerThread = new Thread(){
            public void run(){
                mbActive = true;
                try{
                    int waited = 0;
                    while (mbActive && (waited < TIMER_RUNTIME)){
                        sleep(200);
                        if(mbActive){
                            waited += 200;
                            updateProgress(waited);
                        }
                    }
                }catch (InterruptedException e){
                }finally {
                    onContinue();
                }
            }
        };
        timerThread.start();
    }

    public void updateProgress(final int timePassed){
        if(null != mProgressBar){
            final  int progress = mProgressBar.getMax() * timePassed / TIMER_RUNTIME;
            mProgressBar.setProgress(progress);
        }
    }

    public void onContinue(){
        //Log.d("mensageFinal", "termine de cargar");
       Intent Introduccion = new Intent(this, Introduccion_uno.class);
        startActivity(Introduccion);
        finish();
    }
}
