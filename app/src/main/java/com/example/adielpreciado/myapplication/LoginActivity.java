package com.example.adielpreciado.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText edtusu, edtclv;
    private Button btningr;
    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        edtusu = (EditText) findViewById(R.id.Usuario);
        edtclv = (EditText) findViewById(R.id.Clave);
        btningr = (Button) findViewById(R.id.btningr);
        register = (TextView) findViewById(R.id.txtRH);

    }

    public void onClick(View v) {
        Intent miIntent = null;
        switch (v.getId()) {
            case R.id.txtRH:
                miIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                break;
        }
        if (miIntent != null) {
            startActivity(miIntent);
        }
    }
}





