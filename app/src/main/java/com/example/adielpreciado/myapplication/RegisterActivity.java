package com.example.adielpreciado.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private EditText mail,usen,passn;
    private TextView txtnew;
    private Button btnagregar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);
        mail = (EditText)findViewById(R.id.txtEmail);
        usen = (EditText)findViewById(R.id.Usernew);
        passn = (EditText)findViewById(R.id.Clavenew);
        btnagregar =(Button)findViewById(R.id.btnRegister);
        txtnew =(TextView)findViewById(R.id.txtnew);

    }
    public void onClick(View v) {
        Intent Intent = null;
        switch (v.getId()) {
            case R.id.txtnew:
                Intent = new Intent(RegisterActivity.this, LoginActivity.class);
                break;
        }
        if (Intent != null) {
            startActivity(Intent);
        }
    }
}
