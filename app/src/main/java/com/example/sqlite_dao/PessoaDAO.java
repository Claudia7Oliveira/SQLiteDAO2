package com.example.sqlite_dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private bdHelper dbHelper;
    private SQLiteDatabase bd;

    public PessoaDAO(Context context) {
        dbHelper = new bdHelper(context);
        bd = dbHelper.getWritableDatabase();
    }

    public long insert(Pessoa pessoa) {
        ContentValues values = new ContentValues();
        values.put("nome", pessoa.getNome());
        values.put("cpf", pessoa.getCpf());
        values.put("idade", pessoa.getIdade());
        values.put("nasc", pessoa.getDataNasc());
        values.put("fone", pessoa.getTelefone());
        values.put("email", pessoa.getEmail());

        return
                bd.insert("pessoa", null, values);

    }

    public List<Pessoa> returnAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        Cursor cursor = bd.query("pessoa", new String[]{"id", "nome", "cpf", "idade", "dataNasc", "telefone", "email"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Pessoa p = new Pessoa();
            p.setId(cursor.getInt(0));
            p.setNome(cursor.getString(1));
            p.setCpf(cursor.getString(2));
            p.setIdade(cursor.getString(3));
            p.setDataNasc(cursor.getString(4));
            p.setTelefone(cursor.getString(5));
            p.setEmail(cursor.getString(6));

            pessoas.add(p);
        }
        return pessoas;
    }
}


