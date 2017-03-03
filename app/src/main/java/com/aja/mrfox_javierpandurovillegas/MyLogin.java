package com.aja.mrfox_javierpandurovillegas;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyLogin extends AppCompatActivity {
    TextView tvTitulo, tvSub, tvSing;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);

        tvTitulo = (TextView) findViewById(R.id.tvTituloS);
        tvSub = (TextView) findViewById(R.id.tvSubS);
        tvSing = (TextView) findViewById(R.id.tvSing);
        login = (Button) findViewById(R.id.login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/AmaticSC-Regular.ttf");
        tvTitulo.setTypeface(face);
        tvSub.setTypeface(face);
        tvSing.setTypeface(face);

    }

    public void goMain(View view){
        Intent intent = new Intent(MyLogin.this, MyMain.class);
        startActivity(intent);
    }

}
