package com.example.adielpreciado.myapplication;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LOGfrag extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logfrag);

        FragmentManager fm= getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.escenario , new LOGIN()).commit();
    }
}
