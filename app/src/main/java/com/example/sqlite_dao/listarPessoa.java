package com.example.sqlite_dao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class listarPessoa extends AppCompatActivity {
    private ListView listview;
    private PessoaDAO dao;
    private List<Pessoa> pessoas;
    private List<Pessoa> pessoaBusca = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pessoa);

        listview.findViewById(R.id.lista);
        dao = new PessoaDAO(this);

        pessoas = dao.returnAll();
        pessoaBusca.addAll(pessoas);
        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<Pessoa>(this, android.R.layout.simple_list_item_1, pessoas);
        listview.setAdapter(adapter);
    }
}
