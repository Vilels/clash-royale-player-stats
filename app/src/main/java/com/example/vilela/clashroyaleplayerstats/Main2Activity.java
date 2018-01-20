package com.example.vilela.clashroyaleplayerstats;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends Activity {
    protected TextView textView2, textViewName, textViewStatusClan, textViewTrophies, textViewArena, textViewMaxTrophies, textViewWins, textViewLosses, textViewWinP, textViewTime, textViewTotal, textViewP1, textViewP2, textViewP3, textViewP4, textViewP5, textViewP6, textViewP7, textViewP8, textViewP9, textViewP10, textViewP11, textViewP12, textViewP13, textViewP14;
    protected ImageView imageViewArena;
    protected ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, imageView14;
    protected String tag;
    protected Button button;
    protected AdaptadorBaseDados a;
    AsyncGenerator backgroundTask;
    Activity activity;
    public Boolean b;
    String buttonText;

    String nome, statusClan, clan, trophies, URLImage, arena, maxTrophies, wins, losses, winP, time, total, URLChest1, p1, n1, URLChest2, p2, n2, URLChest3, p3, n3, URLChest4, p4, n4, URLChest5, p5, n5, URLChest6, p6, n6, URLChest7, p7, n7, URLChest8, p8, n8, URLChest9, p9, n9, URLChest10, p10, n10, URLChest11, p11, n11, URLChest12, p12, n12, URLChest13, p13, n13, URLChest14, p14, n14;
    Element image, imageChest1, imageChest2, imageChest3, imageChest4, imageChest5, imageChest6, imageChest7, imageChest8, imageChest9, imageChest10, imageChest11, imageChest12, imageChest13, imageChest14;

    protected void onStart(){
        super.onStart();
        a = new AdaptadorBaseDados(this).open();
    }

    protected void onStop(){
        super.onStop();
        a.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView2 = (TextView) findViewById(R.id.textView2);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewStatusClan = (TextView) findViewById(R.id.textViewStatusClan);
        textViewTrophies = (TextView) findViewById(R.id.textViewTrophies);
        textViewArena = (TextView) findViewById(R.id.textViewArena);
        textViewMaxTrophies = (TextView) findViewById(R.id.textViewMaxTrophies);
        textViewWins = (TextView) findViewById(R.id.textViewWins);
        textViewLosses = (TextView) findViewById(R.id.textViewLosses);
        textViewWinP = (TextView) findViewById(R.id.textViewWinP);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        textViewTotal = (TextView) findViewById(R.id.textViewTotal);
        textViewP1 = (TextView) findViewById(R.id.textViewP1);
        textViewP2 = (TextView) findViewById(R.id.textViewP2);
        textViewP3 = (TextView) findViewById(R.id.textViewP3);
        textViewP4 = (TextView) findViewById(R.id.textViewP4);
        textViewP5 = (TextView) findViewById(R.id.textViewP5);
        textViewP6 = (TextView) findViewById(R.id.textViewP6);
        textViewP7 = (TextView) findViewById(R.id.textViewP7);
        textViewP8 = (TextView) findViewById(R.id.textViewP8);
        textViewP9 = (TextView) findViewById(R.id.textViewP9);
        textViewP10 = (TextView) findViewById(R.id.textViewP10);
        textViewP11 = (TextView) findViewById(R.id.textViewP11);
        textViewP12 = (TextView) findViewById(R.id.textViewP12);
        textViewP13 = (TextView) findViewById(R.id.textViewP13);
        textViewP14 = (TextView) findViewById(R.id.textViewP14);

        imageViewArena = (ImageView) findViewById(R.id.imageViewArena);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        imageView10 = (ImageView) findViewById(R.id.imageView10);
        imageView11 = (ImageView) findViewById(R.id.imageView11);
        imageView12 = (ImageView) findViewById(R.id.imageView12);
        imageView13 = (ImageView) findViewById(R.id.imageView13);
        imageView14 = (ImageView) findViewById(R.id.imageView14);

        Intent x = getIntent();
        tag = x.getStringExtra("aTag");
        textView2.setText(x.getStringExtra("aTag"));

        button = (Button) findViewById(R.id.button);

        activity=this;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonText.equals("Adicionar")){
                    a.insertPlayerTagName(textView2.getText().toString(), textViewName.getText().toString());
                    Toast.makeText(activity, "Jogador Adicionado", Toast.LENGTH_SHORT).show();
                    buttonText = "Remover";
                    button.setText(buttonText);
                } else if (buttonText.equals("Remover")){
                    a.deletePlayer(tag);
                    Toast.makeText(activity, "Jogador Removido", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(activity, "Jogador Adicionado", Toast.LENGTH_SHORT).show();
            }
        });

        backgroundTask = new AsyncGenerator();
        backgroundTask.execute();





        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, n1, Toast.LENGTH_SHORT).show();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, n2, Toast.LENGTH_SHORT).show();
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, n3, Toast.LENGTH_SHORT).show();
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, n4, Toast.LENGTH_SHORT).show();
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, n5, Toast.LENGTH_SHORT).show();
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, n6, Toast.LENGTH_SHORT).show();
            }
        });

        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, n7, Toast.LENGTH_SHORT).show();
            }
        });

        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, n8, Toast.LENGTH_SHORT).show();
            }
        });

        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, n9, Toast.LENGTH_SHORT).show();
            }
        });

        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, n10, Toast.LENGTH_SHORT).show();
            }
        });

        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, n11, Toast.LENGTH_SHORT).show();
            }
        });

        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, n12, Toast.LENGTH_SHORT).show();
            }
        });

        imageView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, n13, Toast.LENGTH_SHORT).show();
            }
        });

        imageView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, n14, Toast.LENGTH_SHORT).show();
            }
        });



    }

    private final class AsyncGenerator extends AsyncTask<Void,Void,Void> {
        boolean error;
        boolean b;
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
                    statusClan = document.select("div.ui.header.item").text();
                    clan = document.select("body > div.pusher > div:nth-child(6) > div.ui.top.attached.padded.segment > div > div.thirteen.wide.column > div.ui.horizontal.divided.list > div:nth-child(2) > a").text();
                    trophies = document.select("#player > div > div:nth-child(1) > div > div.header").text();
                    arena = document.select("#player > div > div:nth-child(4) > div > div.header").text();
                    maxTrophies = document.select("#player > div > div:nth-child(2) > div > div.header").text();
                    wins = document.select("#player > div > div:nth-child(5) > div > div.header").text();
                    losses = document.select("#player > div > div:nth-child(6) > div > div.header").text();
                    winP = document.select("#player > div > div:nth-child(9) > div > div.header").text();
                    time = document.select("#player > div > div:nth-child(12) > div > div.header").text();
                    total = document.select("#player > div > div:nth-child(8) > div > div.header").text();
                    n1 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(1) > div.content > div").text();
                    p1 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(1) > div.image > div").text();
                    n2 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(2) > div.content > div").text();
                    p2 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(2) > div.image > div").text();
                    n3 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(3) > div.content > div").text();
                    p3 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(3) > div.image > div").text();
                    n4 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(4) > div.content > div").text();
                    p4 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(4) > div.image > div").text();
                    n5 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(5) > div.content > div").text();
                    p5 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(5) > div.image > div").text();
                    n6 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(6) > div.content > div").text();
                    p6 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(6) > div.image > div").text();
                    n7 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(7) > div.content > div").text();
                    p7 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(7) > div.image > div").text();
                    n8 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(8) > div.content > div").text();
                    p8 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(8) > div.image > div").text();
                    n9 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(9) > div.content > div").text();
                    p9 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(9) > div.image > div").text();
                    n10 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(10) > div.content > div").text();
                    p10 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(10) > div.image > div").text();
                    n11 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(11) > div.content > div").text();
                    p11 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(11) > div.image > div").text();
                    n12 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(12) > div.content > div").text();
                    p12 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(12) > div.image > div").text();
                    n13 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(13) > div.content > div").text();
                    p13 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(13) > div.image > div").text();
                    n14 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(14) > div.content > div").text();
                    p14 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(14) > div.image > div").text();

                    image = document.select("#player > div > div:nth-child(4) > div > img").first();
                    URLImage = image.absUrl("src");
                    imageChest1 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(1) > div.image > img").first();
                    URLChest1 = imageChest1.absUrl("src");
                    imageChest2 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(2) > div.image > img").first();
                    URLChest2 = imageChest2.absUrl("src");
                    imageChest3 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(3) > div.image > img").first();
                    URLChest3 = imageChest3.absUrl("src");
                    imageChest4 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(4) > div.image > img").first();
                    URLChest4 = imageChest4.absUrl("src");
                    imageChest5 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(5) > div.image > img").first();
                    URLChest5 = imageChest5.absUrl("src");
                    imageChest6 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(6) > div.image > img").first();
                    URLChest6 = imageChest6.absUrl("src");
                    imageChest7 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(7) > div.image > img").first();
                    URLChest7 = imageChest7.absUrl("src");
                    imageChest8 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(8) > div.image > img").first();
                    URLChest8 = imageChest8.absUrl("src");
                    imageChest9 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(9) > div.image > img").first();
                    URLChest9 = imageChest9.absUrl("src");
                    imageChest10 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(10) > div.image > img").first();
                    URLChest10 = imageChest10.absUrl("src");
                    imageChest11 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(11) > div.image > img").first();
                    URLChest11 = imageChest11.absUrl("src");
                    imageChest12 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(12) > div.image > img").first();
                    URLChest12 = imageChest12.absUrl("src");
                    imageChest13 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(13) > div.image > img").first();
                    URLChest13 = imageChest13.absUrl("src");
                    imageChest14 = document.select("body > div.pusher > div:nth-child(9) > div > div:nth-child(14) > div.image > img").first();
                    URLChest14 = imageChest14.absUrl("src");

                    b = a.existe(tag);
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
                Toast.makeText(activity, "Erro, tag inexistente", Toast.LENGTH_SHORT).show();
            }

            textViewName.setText(nome);
            textViewStatusClan.setText(statusClan + " in " + clan);
            textViewTrophies.setText("Trophies: " + trophies);
            textViewMaxTrophies.setText("Max Trophies: " + maxTrophies);
            textViewArena.setText(arena);
            textViewWins.setText("Wins: " + wins);
            textViewLosses.setText("Losses: " + losses);
            textViewWinP.setText("Win%: " + winP);
            textViewTime.setText("Time Played: " + time);
            textViewTotal.setText("Total Games: " + total);
            textViewP1.setText(p1);
            textViewP2.setText(p2);
            textViewP3.setText(p3);
            textViewP4.setText(p4);
            textViewP5.setText(p5);
            textViewP6.setText(p6);
            textViewP7.setText(p7);
            textViewP8.setText(p8);
            textViewP9.setText(p9);
            textViewP10.setText(p10);
            textViewP11.setText(p11);
            textViewP12.setText(p12);
            textViewP13.setText(p13);
            textViewP14.setText(p14);

            new DownloadImage(imageViewArena).execute(URLImage);
            new  DownloadImage(imageView1).execute(URLChest1);
            new  DownloadImage(imageView2).execute(URLChest2);
            new  DownloadImage(imageView3).execute(URLChest3);
            new  DownloadImage(imageView4).execute(URLChest4);
            new  DownloadImage(imageView5).execute(URLChest5);
            new  DownloadImage(imageView6).execute(URLChest6);
            new  DownloadImage(imageView7).execute(URLChest7);
            new  DownloadImage(imageView8).execute(URLChest8);
            new  DownloadImage(imageView9).execute(URLChest9);
            new  DownloadImage(imageView10).execute(URLChest10);
            new  DownloadImage(imageView11).execute(URLChest11);
            new  DownloadImage(imageView12).execute(URLChest12);
            new  DownloadImage(imageView13).execute(URLChest13);
            new  DownloadImage(imageView14).execute(URLChest14);

            //Toast.makeText(activity, URLImage, Toast.LENGTH_SHORT).show();

            if (b==true){
                buttonText = "Remover";
                button.setText(buttonText);
            } else if (b==false){
                buttonText = "Adicionar";
                button.setText(buttonText);
            }
        }
    }

    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        protected ImageView imageViewArena;

        public DownloadImage(ImageView imageViewArena) {
            this.imageViewArena= imageViewArena;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String url = urls[0];
            Bitmap imageViewArena = null;

            try {
                InputStream inputStream = new URL(url).openStream();
                imageViewArena = BitmapFactory.decodeStream(inputStream);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return imageViewArena;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageViewArena.setImageBitmap(bitmap);
        }
    }

}

