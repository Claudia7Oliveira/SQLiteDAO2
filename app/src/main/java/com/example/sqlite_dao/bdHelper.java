package com.example.sqlite_dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class bdHelper extends SQLiteOpenHelper{
    private static final String name = "db.db";//que criativo...
    private static final int versao =01;

    public bdHelper(Context context){
        super(context,name, null, versao);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table pessoa (id interger primary key autoincrement," +
                "nome varchar(50), cpf varchar(11),idade interger, dataNasc varchar(10), telefone varchar(11),email varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
