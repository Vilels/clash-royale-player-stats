package com.example.vilela.clashroyaleplayerstats;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vilela on 08/01/2018.
 */

public class AdaptadorBaseDados {
    private AjudaUsoBaseDados dbHelper;
    private SQLiteDatabase database;

    public AdaptadorBaseDados(Context context) {
        dbHelper = new AjudaUsoBaseDados(context.getApplicationContext());
    }

    public AdaptadorBaseDados open() {
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    private Cursor obterTodosRegistos() {
        String[] colunas = new String[2];
        colunas[0] = "playerTag";
        colunas[1] = "name";
        return database.query("players", colunas, null, null, null, null, null);
    }

    public List<String> obterTodosNames() {
        ArrayList<String> names = new ArrayList<String>();
        Cursor cursor = obterTodosRegistos();
        if (cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return names;
    }

    public List<String> obterTodasTags() {
        ArrayList<String> tags = new ArrayList<String>();
        Cursor cursor = obterTodosRegistos();
        if (cursor.moveToFirst()) {
            do {
                tags.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return tags;
    }

    public int obterTodosCampos(List<Integer> osIds, List<String> asTags, List<String> osName) {
        String[] colunas = new String[23];
        colunas[0] = "_id";
        colunas[1] = "playerTag";
        colunas[2] = "name";
        Cursor c = database.query("players", colunas, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                osIds.add(c.getInt(0));
                asTags.add(c.getString(1));
                osName.add(c.getString(2));
            } while (c.moveToNext());
        }
        c.close();
        return osIds.size();
    }

    public boolean existe(String umaTag){
        Cursor cursor = database.rawQuery("select playerTag from players where playerTag=?", new String[]{umaTag});
        boolean b = cursor.getCount()>=1;
        cursor.close();
        return b;
    }

    public long insertPlayerTagName(String aPlayerTag, String oName) {
        ContentValues values = new ContentValues() ;
        values.put("playerTag", aPlayerTag);
        values.put("name", oName);
        return database.insert("players", null, values);
    }

    public int deletePlayer (String aTag){
        String whereClause = "playerTag = ?";
        String[] whereArgs = new String[1];
        whereArgs[0] = aTag;
        return database.delete("players", whereClause, whereArgs);
    }
}
