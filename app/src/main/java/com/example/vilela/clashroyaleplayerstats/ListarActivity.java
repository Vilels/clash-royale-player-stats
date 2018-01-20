package com.example.vilela.clashroyaleplayerstats;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListarActivity extends ListActivity {
    protected ArrayList<String> osItensDaLista;
    AdaptadorBaseDados a;

    private void mudarDeEcra(Class<?> subAtividade, String oValor){
        Intent x = new Intent(this, subAtividade);
        x.putExtra("aTag", oValor);
        startActivity(x);
    }


    @Override
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
        setContentView(R.layout.activity_listar);

        Intent oItent = getIntent();
        osItensDaLista = oItent.getStringArrayListExtra("asTags");
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osItensDaLista);
        setListAdapter(adaptador);

    }
    public void onListItemClick(ListView parent, View v, int position, long id){
        Toast.makeText(this, osItensDaLista.get(position), Toast.LENGTH_LONG).show();
        mudarDeEcra(Main2Activity.class, osItensDaLista.get(position));

    }
}
