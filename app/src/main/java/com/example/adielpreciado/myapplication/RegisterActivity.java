package com.example.adielpreciado.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

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
    private class CargarDatos extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            try{
                return downloadUrl(urls[0]);

            }catch (IOException e){
                return "Unable to retrieve web page. URL may be invalid";
            }
        }
        @Override
        protected void onPostExecute(String result){
            Toast.makeText(getApplicationContext(), "Se almacenaron los datos correctamente", Toast.LENGTH_LONG).show();
        }
    }
    private class ConsultarDatos extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {
            try{
                return downloadUrl(urls[0]);

            }catch (IOException e){
                return "Unable to retrieve web page. URL may be invalid";
            }
        }
        @Override
        protected void onPostExecute(String result){
            Toast.makeText(getApplicationContext(), "Se almacenaron los datos correctamente", Toast.LENGTH_LONG).show();
        }
    }
    private String downloadUrl(String myurl) throws IOException{
        InputStream is = null;
        int len = 500;
        try{
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /*milisegundos*/);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("Respuesta", "The response is: " + response);
            is=conn.getInputStream();

            String contentAsString =  readIt(is, len);
            return contentAsString;
        }finally {
            if (is != null){
                is.close();
            }
        }


    }
    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream,"UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
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
