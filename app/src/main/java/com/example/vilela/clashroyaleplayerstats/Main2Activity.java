package com.example.vilela.clashroyaleplayerstats;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Main2Activity extends Activity {
    protected TextView textView2, textViewName;
    protected String tag;
    AsyncGenerator backgroundTask;
    Activity activity;

    String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView2 = (TextView) findViewById(R.id.textView2);
        textViewName = (TextView) findViewById(R.id.textViewName);

        Intent x = getIntent();
        tag = x.getStringExtra("aTag");
        textView2.setText(x.getStringExtra("aTag"));

        activity=this;

        backgroundTask = new AsyncGenerator();
        backgroundTask.execute();

    }

    private final class AsyncGenerator extends AsyncTask<Void,Void,Void> {
        boolean error;
        public AsyncGenerator (){

        }

        protected Void doInBackground (Void... args){
            try {
                Document document = Jsoup.connect("http://cr-api.com/player/"+tag).get();

                Element verificar = document.select("h1.ui").first();

                if (verificar == null){
                    error = true;
                } else {
                    nome = document.select("h1.ui").text();

                    String status = document.select("div.ui.header.item").text();

                    String clan = document.select("body > div.pusher > div:nth-child(6) > div.ui.top.attached.padded.segment > div > div.thirteen.wide.column > div.ui.horizontal.divided.list > div:nth-child(2) > a").text();

                }

            } catch (IOException e) {
                Toast.makeText(activity, "Erro na conexão a Internet", Toast.LENGTH_SHORT).show();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (error) {
                Toast.makeText(activity, "Erro", Toast.LENGTH_SHORT).show();
            }

            textViewName.setText(nome);
        }
    }

}

