package com.aja.mrfox_javierpandurovillegas;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MySplash extends AppCompatActivity {
    public static final int SEGUNDOS = 3;
    public static final int MILISEGUNDOS = SEGUNDOS * 1000;
    public static final int DELAY = 2;
    private ProgressBar progressBar;
    ImageView imageview;
    static String PackageName;
    TextView tvTituloS, tvSubS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_splash);
        PackageName=getPackageName();

        tvTituloS = (TextView) findViewById(R.id.tvTituloS);
        tvSubS = (TextView) findViewById(R.id.tvSubS);
        imageview = (ImageView) findViewById(R.id.imageView);

        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/AmaticSC-Regular.ttf");
        tvTituloS.setTypeface(face);
        tvSubS.setTypeface(face);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(maximo_prograso());
        progressBar.getIndeterminateDrawable()
                .setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.move); // creas la animacion
        tvTituloS.startAnimation(anim);//cargamos he iniciamos la animacion
        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.move2); // creas la animacion
        tvSubS.startAnimation(anim2);//cargamos he iniciamos la animacion
        Animation anim3 = AnimationUtils.loadAnimation(this, R.anim.move3); // creas la animacion
        imageview.startAnimation(anim3);//cargamos he iniciamos la animacion
        empezar_animacion();
    }


    private void empezar_animacion() {
        new CountDownTimer(MILISEGUNDOS, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress(establecer_progreso(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MySplash.this, MyLogin.class);
                startActivity(intent);
                finish();
            }
        }.start();

    }

    private int establecer_progreso(long milisegundos) {
        return (int) ((milisegundos - milisegundos)/1000);
    }

    private int maximo_prograso() {
        return (SEGUNDOS-DELAY);
    }
}

