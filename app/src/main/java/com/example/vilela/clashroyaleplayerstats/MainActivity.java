package com.example.vilela.clashroyaleplayerstats;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    protected TextView textView;
    protected EditText editTextTag;
    protected Button buttonSearch, buttonList;
    protected AdaptadorBaseDados a;
    Cursor c;
    List<String> asTags;

    private void mudarDeEcra2(Class<?> subAtividade, ArrayList<String> oValor){
        Intent x = new Intent(this, subAtividade);
        x.putExtra("asTags", oValor);
        startActivity(x);
    }

    protected void onStart(){
        super.onStart();
        a = new AdaptadorBaseDados(this).open();
    }

    protected void onStop(){
        super.onStop();
        a.close();
    }

    private void mudarDeEcra(Class<?> subAtividade, String tag){
        Intent x = new Intent(this, subAtividade);
        x.putExtra("aTag", tag);
        startActivity(x);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        editTextTag = (EditText) findViewById(R.id.editTextTag);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        buttonList = (Button) findViewById(R.id.buttonList);

        buttonSearch.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                mudarDeEcra(Main2Activity.class,editTextTag.getText().toString());

            }
        });

        buttonList.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                asTags = a.obterTodasTags();
                mudarDeEcra2(ListarActivity.class, (ArrayList)asTags);

            }
        });
    }
}
