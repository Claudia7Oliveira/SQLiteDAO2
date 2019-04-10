package com.example.sqlite_dao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroPessoa extends AppCompatActivity {
    private EditText nome;
    private EditText cpf;
    private EditText idade;
    private EditText dataNasc;
    private EditText fone;
    private EditText email;

    private PessoaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoa);
        //recebe paarmetro xml//

         nome = findViewById(R.id.editNome);
         cpf = findViewById(R.id.editCpf);
         idade = findViewById(R.id.editIdade);
         dataNasc = findViewById(R.id.editData);
         fone = findViewById(R.id.editFone);
         email = findViewById(R.id.editMail);

         dao = new PessoaDAO(this);
    }
    // salvar
    public void salvar(View view){
        Pessoa p = new Pessoa();
        p.setNome(nome.getText().toString());
        p.setCpf(cpf.getText().toString());
        p.setIdade(idade.getText().toString());
        p.setDataNasc(dataNasc.getText().toString());
        p.setTelefone(fone.getText().toString());
        p.setEmail(email.getText().toString());

        long id = dao.insert(p);

        //testa
        Toast.makeText(this, "sucesso ! id"+id, Toast.LENGTH_SHORT).show();
    }

    //voltar
    public void voltar(View view){
        Intent it = new Intent(CadastroPessoa.this,MainActivity.class);
        startActivity(it);
    }

}
