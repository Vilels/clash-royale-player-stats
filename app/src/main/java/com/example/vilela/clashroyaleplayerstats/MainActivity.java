package com.example.vilela.clashroyaleplayerstats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    protected TextView textView;
    protected EditText editTextTag;
    protected Button buttonSearch, buttonList;

    protected void onStart(){
        super.onStart();
    }

    protected void onStop(){
        super.onStop();
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

            }
        });
    }
}
